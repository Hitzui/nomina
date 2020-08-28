/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dysconcsa.app.nomina.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author jmigu
 */
@Entity
@Table(name = "horario")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h"),
        @NamedQuery(name = "Horario.findByIdempleado", query = "SELECT h FROM Horario h WHERE h.horarioPK.idempleado = :idempleado"),
        @NamedQuery(name = "Horario.findByFecha", query = "SELECT h FROM Horario h WHERE h.horarioPK.fecha = :fecha"),
        @NamedQuery(name = "Horario.findByFechaEmpleado", query = "SELECT h FROM Horario h WHERE h.empleado=?1 and h.horarioPK.fecha >= ?2 and h.horarioPK.fecha <= ?3"),
        @NamedQuery(name = "Horario.findByHoraEntrada", query = "SELECT h FROM Horario h WHERE h.horaEntrada = :horaEntrada"),
        @NamedQuery(name = "Horario.findByHoraSalida", query = "SELECT h FROM Horario h WHERE h.horaSalida = :horaSalida")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    private HorarioPK horarioPK;
    @Basic(optional = false)
    @Column(name = "hora_entrada")
    private String horaEntrada;
    @Column(name = "hora_salida")
    private String horaSalida;
    @JoinColumn(name = "idempleado", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;

    public Horario() {
    }

    public Horario(HorarioPK horarioPK) {
        this.horarioPK = horarioPK;
    }

    public Horario(HorarioPK horarioPK, String horaEntrada) {
        this.horarioPK = horarioPK;
        this.horaEntrada = horaEntrada;
    }

    public Horario(int idempleado, LocalDate fecha) {
        this.horarioPK = new HorarioPK(idempleado, fecha);
    }

    public HorarioPK getHorarioPK() {
        return horarioPK;
    }

    public void setHorarioPK(HorarioPK horarioPK) {
        this.horarioPK = horarioPK;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horarioPK != null ? horarioPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.horarioPK == null && other.horarioPK != null) || (this.horarioPK != null && !this.horarioPK.equals(other.horarioPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return horarioPK.toString();
    }

}
