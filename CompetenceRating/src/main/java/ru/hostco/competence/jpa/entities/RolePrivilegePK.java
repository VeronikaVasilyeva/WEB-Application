package ru.hostco.competence.jpa.entities;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * The primary key class for the lnk_RolePrivilege database table.
 */
@Embeddable
public class RolePrivilegePK implements Serializable {
    //default serial version id, required for serializable classes.
    private static final long serialVersionUID = 1L;

    @Column(name = "RoleId")
    private String roleId;

    @Column(name = "PrivilegeId")
    private String privilegeId;

    public RolePrivilegePK() {
    }

    public String getRoleId() {
        return this.roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getPrivilegeId() {
        return this.privilegeId;
    }

    public void setPrivilegeId(String privilegeId) {
        this.privilegeId = privilegeId;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RolePrivilegePK)) {
            return false;
        }
        RolePrivilegePK castOther = (RolePrivilegePK) other;
        return
                this.roleId.equals(castOther.roleId)
                        && this.privilegeId.equals(castOther.privilegeId);
    }

    public int hashCode() {
        final int prime = 31;
        int hash = 17;
        hash = hash * prime + this.roleId.hashCode();
        hash = hash * prime + this.privilegeId.hashCode();

        return hash;
    }
}