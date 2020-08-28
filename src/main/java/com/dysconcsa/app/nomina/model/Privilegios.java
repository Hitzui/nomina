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
@Table(name = "privilegios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Privilegios.findAll", query = "SELECT p FROM Privilegios p"),
    @NamedQuery(name = "Privilegios.findById", query = "SELECT p FROM Privilegios p WHERE p.id = :id"),
    @NamedQuery(name = "Privilegios.findByDescripcion", query = "SELECT p FROM Privilegios p WHERE p.descripcion = :descripcion"),
    @NamedQuery(name = "Privilegios.findByGrantAccess", query = "SELECT p FROM Privilegios p WHERE p.grantAccess = :grantAccess")})
public class Privilegios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "grant_access")
    private Integer grantAccess;

    public Privilegios() {
    }

    public Privilegios(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getGrantAccess() {
        return grantAccess;
    }

    public void setGrantAccess(Integer grantAccess) {
        this.grantAccess = grantAccess;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Privilegios)) {
            return false;
        }
        Privilegios other = (Privilegios) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dysconcsa.app.nomina.model.Privilegios[ id=" + id + " ]";
    }
    
}
