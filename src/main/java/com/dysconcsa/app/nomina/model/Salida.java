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
@Table(name = "salida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Salida.findAll", query = "SELECT s FROM Salida s"),
    @NamedQuery(name = "Salida.findByIdempleado", query = "SELECT s FROM Salida s WHERE s.salidaPK.idempleado = :idempleado"),
    @NamedQuery(name = "Salida.findByIdmotivo", query = "SELECT s FROM Salida s WHERE s.salidaPK.idmotivo = :idmotivo"),
    @NamedQuery(name = "Salida.findByFecha", query = "SELECT s FROM Salida s WHERE s.fecha = :fecha")})
public class Salida implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected SalidaPK salidaPK;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @JoinColumn(name = "idempleado", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Empleado empleado;
    @JoinColumn(name = "idmotivo", referencedColumnName = "idmotivo", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MotivoSalida motivoSalida;

    public Salida() {
    }

    public Salida(SalidaPK salidaPK) {
        this.salidaPK = salidaPK;
    }

    public Salida(SalidaPK salidaPK, Date fecha) {
        this.salidaPK = salidaPK;
        this.fecha = fecha;
    }

    public Salida(int idempleado, int idmotivo) {
        this.salidaPK = new SalidaPK(idempleado, idmotivo);
    }

    public SalidaPK getSalidaPK() {
        return salidaPK;
    }

    public void setSalidaPK(SalidaPK salidaPK) {
        this.salidaPK = salidaPK;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public MotivoSalida getMotivoSalida() {
        return motivoSalida;
    }

    public void setMotivoSalida(MotivoSalida motivoSalida) {
        this.motivoSalida = motivoSalida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salidaPK != null ? salidaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Salida)) {
            return false;
        }
        Salida other = (Salida) object;
        if ((this.salidaPK == null && other.salidaPK != null) || (this.salidaPK != null && !this.salidaPK.equals(other.salidaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dysconcsa.app.nomina.model.Salida[ salidaPK=" + salidaPK + " ]";
    }
    
}
