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
@Table(name = "feriados")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feriados.findAll", query = "SELECT f FROM Feriados f"),
    @NamedQuery(name = "Feriados.findByIdferiados", query = "SELECT f FROM Feriados f WHERE f.idferiados = :idferiados"),
    @NamedQuery(name = "Feriados.findByDescripcion", query = "SELECT f FROM Feriados f WHERE f.descripcion = :descripcion"),
    @NamedQuery(name = "Feriados.findByFecha", query = "SELECT f FROM Feriados f WHERE f.fecha = :fecha")})
public class Feriados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idferiados")
    private Integer idferiados;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;

    public Feriados() {
    }

    public Feriados(Integer idferiados) {
        this.idferiados = idferiados;
    }

    public Integer getIdferiados() {
        return idferiados;
    }

    public void setIdferiados(Integer idferiados) {
        this.idferiados = idferiados;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idferiados != null ? idferiados.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feriados)) {
            return false;
        }
        Feriados other = (Feriados) object;
        if ((this.idferiados == null && other.idferiados != null) || (this.idferiados != null && !this.idferiados.equals(other.idferiados))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dysconcsa.app.nomina.model.Feriados[ idferiados=" + idferiados + " ]";
    }
    
}
