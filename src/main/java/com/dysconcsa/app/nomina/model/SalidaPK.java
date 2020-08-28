/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dysconcsa.app.nomina.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author jmigu
 */
@Embeddable
public class SalidaPK implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
    @Column(name = "idempleado")
    private int idempleado;
    @Basic(optional = false)
    @Column(name = "idmotivo")
    private int idmotivo;

    public SalidaPK() {
    }

    public SalidaPK(int idempleado, int idmotivo) {
        this.idempleado = idempleado;
        this.idmotivo = idmotivo;
    }

    public int getIdempleado() {
        return idempleado;
    }

    public void setIdempleado(int idempleado) {
        this.idempleado = idempleado;
    }

    public int getIdmotivo() {
        return idmotivo;
    }

    public void setIdmotivo(int idmotivo) {
        this.idmotivo = idmotivo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idempleado;
        hash += (int) idmotivo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalidaPK)) {
            return false;
        }
        SalidaPK other = (SalidaPK) object;
        if (this.idempleado != other.idempleado) {
            return false;
        }
        if (this.idmotivo != other.idmotivo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.dysconcsa.app.nomina.model.SalidaPK[ idempleado=" + idempleado + ", idmotivo=" + idmotivo + " ]";
    }
    
}
