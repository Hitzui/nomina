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
@Table(name = "role_user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RoleUser.findAll", query = "SELECT r FROM RoleUser r"),
    @NamedQuery(name = "RoleUser.findByIduser", query = "SELECT r FROM RoleUser r WHERE r.roleUserPK.iduser = :iduser"),
    @NamedQuery(name = "RoleUser.findByIdrole", query = "SELECT r FROM RoleUser r WHERE r.roleUserPK.idrole = :idrole")})
public class RoleUser implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RoleUserPK roleUserPK;

    public RoleUser() {
    }

    public RoleUser(RoleUserPK roleUserPK) {
        this.roleUserPK = roleUserPK;
    }

    public RoleUser(int iduser, int idrole) {
        this.roleUserPK = new RoleUserPK(iduser, idrole);
    }

    public RoleUserPK getRoleUserPK() {
        return roleUserPK;
    }

    public void setRoleUserPK(RoleUserPK roleUserPK) {
        this.roleUserPK = roleUserPK;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleUserPK != null ? roleUserPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RoleUser)) {
            return false;
        }
        RoleUser other = (RoleUser) object;
        return !((this.roleUserPK == null && other.roleUserPK != null) || (this.roleUserPK != null && !this.roleUserPK.equals(other.roleUserPK)));
    }

    @Override
    public String toString() {
        return "com.dysconcsa.app.nomina.model.RoleUser[ roleUserPK=" + roleUserPK + " ]";
    }
    
}
