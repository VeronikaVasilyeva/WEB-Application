package ru.hostco.competence.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;


/**
 * The persistent class for the lnk_SubdivisionExecutive database table.
 */
@Entity
@Table(name = "lnk_SubdivisionExecutive")
@NamedQuery(name = "SubdivisionExecutive.findAll", query = "SELECT l FROM SubdivisionExecutive l")
public class SubdivisionExecutive extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private SubdivisionExecutivePK id;

    @Column(name = "IsActive")
    private boolean isActive;

    //bi-directional many-to-one association to Dict_Subdivision
    @ManyToOne
    @JoinColumn(name = "SubdivisionId", insertable = false, updatable = false)
    private Subdivision dictSubdivision;

    //bi-directional many-to-one association to Sys_User
    @ManyToOne
    @JoinColumn(name = "UserId", insertable = false, updatable = false)
    private User sysUser;

    public SubdivisionExecutive() {
    }

    public SubdivisionExecutivePK getId() {
        return this.id;
    }

    public void setId(Object id) {
        this.id = (SubdivisionExecutivePK) id;
    }

    public boolean getIsActive() {
        return this.isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Subdivision getDictSubdivision() {
        return this.dictSubdivision;
    }

    public void setDictSubdivision(Subdivision dictSubdivision) {
        this.dictSubdivision = dictSubdivision;
    }

    public User getSysUser() {
        return this.sysUser;
    }

    public void setSysUser(User sysUser) {
        this.sysUser = sysUser;
    }

}