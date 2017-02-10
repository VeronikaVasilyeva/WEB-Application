package ru.hostco.competence.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the sys_Role database table.
 */
@Entity
@Table(name = "sys_Role")
@NamedQuery(name = "Role.findAll", query = "SELECT s FROM Role s")
public class Role extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "RoleId")
    private String id;

    @Column(name = "Dins")
    private Timestamp dins;

    @Column(name = "Dupd")
    private Timestamp dupd;

    @Column(name = "IsActive")
    private boolean isActive;

    @Column(name = "Name")
    private String name;

    @Column(name = "Uins")
    private String uins;

    @Column(name = "Uupd")
    private String uupd;

    //bi-directional many-to-one association to Lnk_RolePrivilege
    @OneToMany(mappedBy = "sysRole")
    private List<RolePrivilege> lnkRolePrivileges;

    //bi-directional many-to-one association to Lnk_UserRole
    @OneToMany(mappedBy = "sysRole")
    private List<UserRole> lnkUserRoles;

    public Role() {
        setId(UUID.randomUUID().toString().toUpperCase());
    }

    public String getId() {
        return this.id;
    }

    public void setId(Object roleId) {
        this.id = (String) roleId;
    }

    public Timestamp getDins() {
        return this.dins;
    }

    public void setDins(Timestamp dins) {
        this.dins = dins;
    }

    public Timestamp getDupd() {
        return this.dupd;
    }

    public void setDupd(Timestamp dupd) {
        this.dupd = dupd;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUins() {
        return this.uins;
    }

    public void setUins(String uins) {
        this.uins = uins;
    }

    public String getUupd() {
        return this.uupd;
    }

    public void setUupd(String uupd) {
        this.uupd = uupd;
    }

    public List<RolePrivilege> getLnkRolePrivileges() {
        return this.lnkRolePrivileges;
    }

    public void setLnkRolePrivileges(List<RolePrivilege> lnkRolePrivileges) {
        this.lnkRolePrivileges = lnkRolePrivileges;
    }

    public RolePrivilege addLnkRolePrivilege(RolePrivilege lnkRolePrivilege) {
        getLnkRolePrivileges().add(lnkRolePrivilege);
        lnkRolePrivilege.setSysRole(this);

        return lnkRolePrivilege;
    }

    public RolePrivilege removeLnkRolePrivilege(RolePrivilege lnkRolePrivilege) {
        getLnkRolePrivileges().remove(lnkRolePrivilege);
        lnkRolePrivilege.setSysRole(null);

        return lnkRolePrivilege;
    }

    public List<UserRole> getLnkUserRoles() {
        return this.lnkUserRoles;
    }

    public void setLnkUserRoles(List<UserRole> lnkUserRoles) {
        this.lnkUserRoles = lnkUserRoles;
    }

    public UserRole addLnkUserRole(UserRole lnkUserRole) {
        getLnkUserRoles().add(lnkUserRole);
        lnkUserRole.setSysRole(this);

        return lnkUserRole;
    }

    public UserRole removeLnkUserRole(UserRole lnkUserRole) {
        getLnkUserRoles().remove(lnkUserRole);
        lnkUserRole.setSysRole(null);

        return lnkUserRole;
    }

}