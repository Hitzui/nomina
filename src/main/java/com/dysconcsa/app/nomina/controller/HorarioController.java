package com.dysconcsa.app.nomina.controller;

import com.dysconcsa.app.nomina.model.Empleado;
import com.dysconcsa.app.nomina.model.Horario;
import com.dysconcsa.app.nomina.service.IEmpleadoService;
import com.dysconcsa.app.nomina.service.IHorarioService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.beans.PropertyEditorSupport;
import java.util.List;

@Repository
@RequestMapping("/horario")
public class HorarioController {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IHorarioService horarioService;
    @Autowired
    private IEmpleadoService empleadoService;

    @GetMapping({ "/index", "" })
    public ModelAndView index() {
        var view = new ModelAndView("horario/index");
        List<Empleado> findAllEmpleadosActivos = empleadoService.findAllByActivo();
        logger.info("Size of horarios: " + findAllHorarios().size());
        view.addObject("findAllHorariosNow", findAllHorarios());
        view.addObject("findAllEmpleadosActivos", findAllEmpleadosActivos);
        view.addObject("horario", new Horario());
        return view;
    }

    @PostMapping("/index")
    public ModelAndView asignHorario(@ModelAttribute("horario") Horario horario) {
        var model = new ModelAndView("redirect:/horario/index");
        if (horario.getEmpleado().getId() == 0 || horario.getEmpleado() == null)
            return new ModelAndView("redirect:/horario/");
        logger.info(horario.toString());
        var horarioPK = horario.getHorarioPK();
        horarioPK.setIdempleado(horario.getEmpleado().getId());
        Horario save = horarioService.save(horario);
        if (save == null)
            return new ModelAndView("redirect:/horario/");
        return model;
    }

    @GetMapping("/delete")
    public ModelAndView deleteHorario(@RequestParam int idempleado, @RequestParam String fecha) {
        var model = new ModelAndView("redirect:/horario/");
        logger.info("Empleado: " + idempleado + ", fecha: " + fecha);
        horarioService.delete(idempleado, fecha);
        return model;
    }

    @ModelAttribute("title")
    public String title() {
        return "Administracion de empleados";
    }

    public List<Horario> findAllHorarios() {
        return horarioService.findAllHorarioNow();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(Empleado.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                var type = empleadoService.findById(Integer.valueOf(text)).get();
                logger.info(text);
                setValue(type);
            }
        });
    }

}