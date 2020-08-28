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
@Table(name = "documentacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documentacion.findAll", query = "SELECT d FROM Documentacion d"),
    @NamedQuery(name = "Documentacion.findByIddocumentacion", query = "SELECT d FROM Documentacion d WHERE d.iddocumentacion = :iddocumentacion"),
    @NamedQuery(name = "Documentacion.findByDocumentos", query = "SELECT d FROM Documentacion d WHERE d.documentos = :documentos")})
public class Documentacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddocumentacion")
    private Integer iddocumentacion;
    @Column(name = "documentos")
    private String documentos;
    @JoinColumn(name = "idempleado", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Empleado idempleado;

    public Documentacion() {
    }

    public Documentacion(Integer iddocumentacion) {
        this.iddocumentacion = iddocumentacion;
    }

    public Integer getIddocumentacion() {
        return iddocumentacion;
    }

    public void setIddocumentacion(Integer iddocumentacion) {
        this.iddocumentacion = iddocumentacion;
    }

    public String getDocumentos() {
        return documentos;
    }

    public void setDocumentos(String documentos) {
        this.documentos = documentos;
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
        hash += (iddocumentacion != null ? iddocumentacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documentacion)) {
            return false;
        }
        Documentacion other = (Documentacion) object;
        if ((this.iddocumentacion == null && other.iddocumentacion != null) || (this.iddocumentacion != null && !this.iddocumentacion.equals(other.iddocumentacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dysconcsa.app.nomina.model.Documentacion[ iddocumentacion=" + iddocumentacion + " ]";
    }
    
}
