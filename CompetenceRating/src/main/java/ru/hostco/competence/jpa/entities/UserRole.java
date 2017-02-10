package ru.hostco.competence.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the lnk_UserRole database table.
 */
@Entity
@Table(name = "lnk_UserRole")
@NamedQuery(name = "UserRole.findAll", query = "SELECT l FROM UserRole l")
public class UserRole extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private UserRolePK id;

    @Column(name = "IsActive")
    private boolean isActive;

    //bi-directional many-to-one association to Sys_Role
    @ManyToOne
    @JoinColumn(name = "RoleId", insertable = false, updatable = false)
    private Role sysRole;

    //bi-directional many-to-one association to Sys_User
    @ManyToOne
    @JoinColumn(name = "UserId", insertable = false, updatable = false)
    private User sysUser;

    public UserRole() {
    }

    public UserRolePK getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = (UserRolePK) id;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Role getSysRole() {
        return this.sysRole;
    }

    public void setSysRole(Role sysRole) {
        this.sysRole = sysRole;
    }

    public User getSysUser() {
        return this.sysUser;
    }

    public void setSysUser(User sysUser) {
        this.sysUser = sysUser;
    }

}