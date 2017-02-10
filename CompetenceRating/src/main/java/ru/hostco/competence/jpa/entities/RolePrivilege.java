package ru.hostco.competence.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the lnk_RolePrivilege database table.
 */
@Entity
@Table(name = "lnk_RolePrivilege")
@NamedQuery(name = "RolePrivilege.findAll", query = "SELECT l FROM RolePrivilege l")
public class RolePrivilege extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private RolePrivilegePK id;

    @Column(name = "IsActive")
    private boolean isActive;

    //bi-directional many-to-one association to Sys_Privilege
    @ManyToOne
    @JoinColumn(name = "PrivilegeId", insertable = false, updatable = false)
    private Privilege sysPrivilege;

    //bi-directional many-to-one association to Sys_Role
    @ManyToOne
    @JoinColumn(name = "RoleId", insertable = false, updatable = false)
    private Role sysRole;

    public RolePrivilege() {
    }

    public RolePrivilegePK getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = (RolePrivilegePK) id;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Privilege getSysPrivilege() {
        return this.sysPrivilege;
    }

    public void setSysPrivilege(Privilege sysPrivilege) {
        this.sysPrivilege = sysPrivilege;
    }

    public Role getSysRole() {
        return this.sysRole;
    }

    public void setSysRole(Role sysRole) {
        this.sysRole = sysRole;
    }

}