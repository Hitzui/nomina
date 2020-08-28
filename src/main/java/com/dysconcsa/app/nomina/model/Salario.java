/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dysconcsa.app.nomina.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author jmigu
 */
@Entity
@Table(name = "salario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salario.findAll", query = "SELECT s FROM Salario s"),
    @NamedQuery(name = "Salario.findByIdsalario", query = "SELECT s FROM Salario s WHERE s.idsalario = :idsalario"),
    @NamedQuery(name = "Salario.findByFechaAum", query = "SELECT s FROM Salario s WHERE s.fechaAum = :fechaAum"),
    @NamedQuery(name = "Salario.findBySalario", query = "SELECT s FROM Salario s WHERE s.salario = :salario")})
public class Salario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idsalario")
    private Integer idsalario;
    @Column(name = "fecha_aum")
    @Temporal(TemporalType.DATE)
    private Date fechaAum;
    @Column(name = "salario")
    private Long salario;
    @JoinColumn(name = "idempleado", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado idempleado;

    public Salario() {
    }

    public Salario(Integer idsalario) {
        this.idsalario = idsalario;
    }

    public Integer getIdsalario() {
        return idsalario;
    }

    public void setIdsalario(Integer idsalario) {
        this.idsalario = idsalario;
    }

    public Date getFechaAum() {
        return fechaAum;
    }

    public void setFechaAum(Date fechaAum) {
        this.fechaAum = fechaAum;
    }

    public Long getSalario() {
        return salario;
    }

    public void setSalario(Long salario) {
        this.salario = salario;
    }

    public Empleado getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(Empleado idempleado) {
        this.idempleado = idempleado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idsalario != null ? idsalario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salario)) {
            return false;
        }
        Salario other = (Salario) object;
        if ((this.idsalario == null && other.idsalario != null) || (this.idsalario != null && !this.idsalario.equals(other.idsalario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dysconcsa.app.nomina.model.Salario[ idsalario=" + idsalario + " ]";
    }
    
}
