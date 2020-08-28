/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dysconcsa.app.nomina.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author jmigu
 */
@Entity
@Table(name = "motivo_salida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MotivoSalida.findAll", query = "SELECT m FROM MotivoSalida m"),
    @NamedQuery(name = "MotivoSalida.findByIdmotivo", query = "SELECT m FROM MotivoSalida m WHERE m.idmotivo = :idmotivo"),
    @NamedQuery(name = "MotivoSalida.findByDescripcion", query = "SELECT m FROM MotivoSalida m WHERE m.descripcion = :descripcion"),
    @NamedQuery(name = "MotivoSalida.findByPeriodo", query = "SELECT m FROM MotivoSalida m WHERE m.periodo = :periodo")})
public class MotivoSalida implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idmotivo")
    private Integer idmotivo;
    @Basic(optional = false)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "periodo")
    private int periodo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "motivoSalida", fetch = FetchType.LAZY)
    private List<Salida> salidaList;

    public MotivoSalida() {
    }

    public MotivoSalida(Integer idmotivo) {
        this.idmotivo = idmotivo;
    }

    public MotivoSalida(Integer idmotivo, String descripcion, int periodo) {
        this.idmotivo = idmotivo;
        this.descripcion = descripcion;
        this.periodo = periodo;
    }

    public Integer getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(Integer idmotivo) {
        this.idmotivo = idmotivo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPeriodo() {
        return periodo;
    }

    public void setPeriodo(int periodo) {
        this.periodo = periodo;
    }

    @XmlTransient
    public List<Salida> getSalidaList() {
        return salidaList;
    }

    public void setSalidaList(List<Salida> salidaList) {
        this.salidaList = salidaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idmotivo != null ? idmotivo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MotivoSalida)) {
            return false;
        }
        MotivoSalida other = (MotivoSalida) object;
        if ((this.idmotivo == null && other.idmotivo != null) || (this.idmotivo != null && !this.idmotivo.equals(other.idmotivo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dysconcsa.app.nomina.model.MotivoSalida[ idmotivo=" + idmotivo + " ]";
    }
    
}
