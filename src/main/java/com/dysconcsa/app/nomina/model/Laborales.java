/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dysconcsa.app.nomina.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 *
 * @author jmigu
 */
@Entity
@Table(name = "laborales")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Laborales.findAll", query = "SELECT l FROM Laborales l"),
    @NamedQuery(name = "Laborales.findByIdlaborales", query = "SELECT l FROM Laborales l WHERE l.idlaborales = :idlaborales"),
    @NamedQuery(name = "Laborales.findByDiaInicial", query = "SELECT l FROM Laborales l WHERE l.diaInicial = :diaInicial"),
    @NamedQuery(name = "Laborales.findByDiaFinal", query = "SELECT l FROM Laborales l WHERE l.diaFinal = :diaFinal")})
public class Laborales implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "idlaborales")
    private Integer idlaborales;
    @Column(name = "dia_inicial")
    private Integer diaInicial;
    @Column(name = "dia_final")
    private Integer diaFinal;

    public Laborales() {
    }

    public Laborales(Integer idlaborales) {
        this.idlaborales = idlaborales;
    }

    public Integer getIdlaborales() {
        return idlaborales;
    }

    public void setIdlaborales(Integer idlaborales) {
        this.idlaborales = idlaborales;
    }

    public Integer getDiaInicial() {
        return diaInicial;
    }

    public void setDiaInicial(Integer diaInicial) {
        this.diaInicial = diaInicial;
    }

    public Integer getDiaFinal() {
        return diaFinal;
    }

    public void setDiaFinal(Integer diaFinal) {
        this.diaFinal = diaFinal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlaborales != null ? idlaborales.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Laborales)) {
            return false;
        }
        Laborales other = (Laborales) object;
        if ((this.idlaborales == null && other.idlaborales != null) || (this.idlaborales != null && !this.idlaborales.equals(other.idlaborales))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dysconcsa.app.nomina.model.Laborales[ idlaborales=" + idlaborales + " ]";
    }
    
}
