package ru.hostco.competence.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the sys_Privilege database table.
 */
@Entity
@Table(name = "sys_Privilege")
@NamedQuery(name = "Privilege.findAll", query = "SELECT s FROM Privilege s")
public class Privilege extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "PrivilegeId")
    private String id;

    @Lob
    @Column(name = "Description")
    private String description;

    @Column(name = "IsActive")
    private boolean isActive;

    //bi-directional many-to-one association to Lnk_RolePrivilege
    @OneToMany(mappedBy = "sysPrivilege")
    private List<RolePrivilege> lnkRolePrivileges;

    public Privilege() {
        setId(UUID.randomUUID().toString().toUpperCase());
    }

    public String getId() {
        return this.id;
    }

    public void setId(Object privilegeId) {
        this.id = (String) privilegeId;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public List<RolePrivilege> getLnkRolePrivileges() {
        return this.lnkRolePrivileges;
    }

    public void setLnkRolePrivileges(List<RolePrivilege> lnkRolePrivileges) {
        this.lnkRolePrivileges = lnkRolePrivileges;
    }

    public RolePrivilege addLnkRolePrivilege(RolePrivilege lnkRolePrivilege) {
        getLnkRolePrivileges().add(lnkRolePrivilege);
        lnkRolePrivilege.setSysPrivilege(this);

        return lnkRolePrivilege;
    }

    public RolePrivilege removeLnkRolePrivilege(RolePrivilege lnkRolePrivilege) {
        getLnkRolePrivileges().remove(lnkRolePrivilege);
        lnkRolePrivilege.setSysPrivilege(null);

        return lnkRolePrivilege;
    }

}