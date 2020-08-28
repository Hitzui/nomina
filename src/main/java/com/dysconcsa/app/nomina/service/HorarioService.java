package com.dysconcsa.app.nomina.service;

import com.dysconcsa.app.nomina.model.Horario;
import com.dysconcsa.app.nomina.model.HorarioPK;
import com.dysconcsa.app.nomina.repository.IHorarioRepository;
import com.dysconcsa.app.nomina.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HorarioService implements IHorarioService {

    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private IHorarioRepository horarioRepository;
    @Autowired
    private IEmpleadoService empleadoService;

    @Override
    public List<Horario> findAllHorarioNow() {
        List<Horario> collect = horarioRepository.findAll().stream()
                .filter(horario -> horario.getHorarioPK().getFecha().equals(LocalDate.now()))
                .collect(Collectors.toList());
        horarioRepository.findAll()
                .forEach(e -> logger.info("" + e.getHorarioPK().getFecha() + " - " + LocalDate.now()));
        return collect;
    }

    @Override
    public Horario save(Horario horario) {
        return horarioRepository.save(horario);
    }

    @Override
    @Transactional
    public void delete(int idempleado, String fecha) {
        var _fecha = DateUtil.parse(fecha);
        var horariopk = new HorarioPK(idempleado, _fecha);
        var findEmpleado = empleadoService.findById(idempleado);
        if (findEmpleado.isPresent()) {
            var empleado = findEmpleado.get();
            var find = horarioRepository.findByHorarioPKAndEmpleado(horariopk, empleado);
            if (find != null) {
                logger.info("Delete horario for empleado: " + find);
                horarioRepository.deleteByHorarioPK(idempleado,_fecha);
            }
        }
    }
}
