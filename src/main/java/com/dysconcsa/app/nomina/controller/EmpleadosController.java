package com.dysconcsa.app.nomina.controller;

import com.dysconcsa.app.nomina.model.Cargos;
import com.dysconcsa.app.nomina.model.Departamento;
import com.dysconcsa.app.nomina.model.Empleado;
import com.dysconcsa.app.nomina.model.Horario;
import com.dysconcsa.app.nomina.repository.ICargoRepository;
import com.dysconcsa.app.nomina.repository.IDepartamentoRepository;
import com.dysconcsa.app.nomina.repository.IHorarioRepository;
import com.dysconcsa.app.nomina.service.IEmpleadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/empleados")
public class EmpleadosController {

    @Autowired
    private IEmpleadoService empleadoService;
    @Autowired
    private IDepartamentoRepository departamentoRepository;
    @Autowired
    private ICargoRepository cargoRepository;
    @Autowired
    private IHorarioRepository horarioRepository;
    List<Horario> horarioEmpleado = new ArrayList<>();
    private Empleado empleado;
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping({ "/index", "/" })
    public ModelAndView index() {
        logger.info("Init index pages...");
        var modelAndView = new ModelAndView("empleados/index");
        modelAndView.addObject("title", "Administracion de empleados");
        return modelAndView;
    }

    @GetMapping("/view/{id}")
    public ModelAndView view(@PathVariable("id") Integer id) {
        var model = new ModelAndView("empleados/view");
        var empleado = empleadoService.findById(id);
        model.addObject("title", "Administracion de empleados");
        if (empleado.isEmpty()) {
            model.setViewName("redirect:/empleados/");
            return model;
        }
        var find = empleado.get();
        this.empleado = find;
        this.horarioEmpleado = find.getHorarioList();
        model.addObject("empleado", find);
        return model;
    }

    @GetMapping("/new")
    public ModelAndView newEmpleado() {
        var model = new ModelAndView("empleados/edit");
        model.addObject("title", "Administracion de empleados");
        model.addObject("editCreate", "Crear Empleado");
        model.addObject("empleado", new Empleado(0));
        return model;
    }

    @GetMapping("/horario")
    public ModelAndView viewHorario(
            @RequestParam("desde") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate desde,
            @RequestParam("hasta") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate hasta) {
        var model = new ModelAndView("empleados/horario :: horario");
        logger.info("Desde: " + desde + ", hasta: " + hasta);
        model.addObject("horarioList", findAllHorarioEmpleado(desde, hasta));
        return model;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getEdit(@PathVariable("id") Integer id) {
        var model = new ModelAndView("empleados/edit");
        var empleado = empleadoService.findById(id);
        if (empleado.isEmpty()) {
            model.setViewName("redirect:/empleados/");
            return model;
        }
        model.addObject("empleado", empleado.get());
        model.addObject("editCreate", "Editar Empleado");
        return model;
    }

    @PostMapping("/save/{id}")
    public ModelAndView postEdit(@PathVariable("id") Integer id, @ModelAttribute("empleado") Empleado empleado,
            BindingResult result) {
        var model = new ModelAndView("redirect:/empleados/");
        if (result.hasErrors()) {
            result.getAllErrors().forEach(System.out::println);
            model.addObject("errorCount", result.getErrorCount());
            model.addObject("fieldError", result.getFieldErrors());
            model.addObject("empleado", empleado);
            model.setViewName("empleados/edit/" + id);
            return model;
        }
        empleadoService.save(id, empleado);
        return model;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") Integer id) {
        var model = new ModelAndView("redirect:/empleados/");
        empleadoService.delete(id);
        return model;
    }

    public List<Horario> findAllHorarioEmpleado(LocalDate desde, LocalDate hasta) {
        return horarioRepository.findByFechaEmpleado(this.empleado, desde, hasta);
    }

    @ModelAttribute("findAllEmpleados")
    public List<Empleado> findAllEmpleados() {
        return empleadoService.findAll();
    }

    @ModelAttribute("title")
    public String title() {
        return "Administracion de empleados";
    }

    @ModelAttribute("findAllDepartamentos")
    public List<Departamento> findAllDepartamentos() {
        return departamentoRepository.findAll();
    }

    @ModelAttribute("findAllCargos")
    public List<Cargos> findAllCargos() {
        return cargoRepository.findAll();
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        /*
         * binder.registerCustomEditor(LocalDate.class, new PropertyEditorSupport(){
         * 
         * @Override public void setAsText(String text) { var type =
         * DateUtil.parse(text); setValue(type); } });
         */
        binder.registerCustomEditor(Departamento.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                var type = departamentoRepository.findById(Integer.valueOf(text)).get();
                setValue(type);
            }
        });
        binder.registerCustomEditor(Cargos.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                var type = cargoRepository.findById(Integer.valueOf(text)).get();
                setValue(type);
            }
        });
    }
}