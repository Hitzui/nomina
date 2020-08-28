package com.dysconcsa.app.nomina.service;

import com.dysconcsa.app.nomina.model.Empleado;
import com.dysconcsa.app.nomina.repository.IEmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmpleadoService implements IEmpleadoService {

    @Autowired
    private IEmpleadoRepository empleadoRepository;

    @Override
    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    @Override
    @Transactional
    public Empleado save(Integer id, Empleado empleado) {
        var findOptional = empleadoRepository.findById(id);
        if (findOptional.isPresent()) {
            var find = findOptional.get();
            find.setNombres(empleado.getNombres());
            find.setApellidos(empleado.getApellidos());
            find.setDireccion(empleado.getDireccion());
            find.setActivo(empleado.getActivo());
            find.setCargo(empleado.getCargo());
            find.setDepartamento(empleado.getDepartamento());
            find.setFechaIng(empleado.getFechaIng());
            find.setFechaNac(empleado.getFechaNac());
            find.setIdentificacion(empleado.getIdentificacion());
            find.setInss(empleado.getInss());
            find.setSalarioBase(empleado.getSalarioBase());
            return empleadoRepository.save(find);
        } else {
            return empleadoRepository.save(empleado);
        }
    }

    @Override
    public Optional<Empleado> findById(Integer id) {
        return empleadoRepository.findById(id);
    }

    @Override
    public boolean delete(Integer id) {
        var find = findById(id);
        if (find.isPresent()) {
            var delete = find.get();
            empleadoRepository.delete(delete);
            return true;
        } else return false;
    }

    @Override
    public List<Empleado> findAllByActivo() {
        return empleadoRepository.findAllByActivo(true);
    }

}