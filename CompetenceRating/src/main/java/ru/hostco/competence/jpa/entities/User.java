package ru.hostco.competence.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the sys_User database table.
 */
@Entity
@Table(name = "sys_User")
@NamedQuery(name = "User.findAll", query = "SELECT s FROM User s")
public class User extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "UserId")
    private String id;

    @Column(name = "IsActive")
    private boolean isActive;

    @Column(name = "Name")
    private String name;

    //bi-directional many-to-one association to Doc_Campaign
    @OneToMany(mappedBy = "sysUser")
    private List<Campaign> docCampaigns;

    //bi-directional many-to-one association to Doc_UserCompetence
    @OneToMany(mappedBy = "sysUser")
    private List<UserCompetence> docUserCompetences;

    //bi-directional many-to-one association to Lnk_SubdivisionExecutive
    @OneToMany(mappedBy = "sysUser")
    private List<SubdivisionExecutive> lnkSubdivisionExecutives;

    //bi-directional many-to-one association to Lnk_UserRole
    @OneToMany(mappedBy = "sysUser")
    private List<UserRole> lnkUserRoles;

    //bi-directional many-to-one association to Dict_Subdivision
    @ManyToOne
    @JoinColumn(name = "SubdivisionId")
    private Subdivision dictSubdivision;

    @ManyToOne
    @JoinColumn(name = "PositionId")
    private Position dictPosition;

    public User() {
        setId(UUID.randomUUID().toString().toUpperCase());
    }

    public String getId() {
        return this.id;
    }

    public void setId(Object userId) {
        this.id = (String) userId;
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

    public List<Campaign> getDocCampaigns() {
        return this.docCampaigns;
    }

    public void setDocCampaigns(List<Campaign> docCampaigns) {
        this.docCampaigns = docCampaigns;
    }

    public Campaign addDocCampaign(Campaign docCampaign) {
        getDocCampaigns().add(docCampaign);
        docCampaign.setSysUser(this);

        return docCampaign;
    }

    public Campaign removeDocCampaign(Campaign docCampaign) {
        getDocCampaigns().remove(docCampaign);
        docCampaign.setSysUser(null);

        return docCampaign;
    }

    public List<UserCompetence> getDocUserCompetences() {
        return this.docUserCompetences;
    }

    public void setDocUserCompetences(List<UserCompetence> docUserCompetences) {
        this.docUserCompetences = docUserCompetences;
    }

    public UserCompetence addDocUserCompetence(UserCompetence docUserCompetence) {
        getDocUserCompetences().add(docUserCompetence);
        docUserCompetence.setSysUser(this);

        return docUserCompetence;
    }

    public UserCompetence removeDocUserCompetence(UserCompetence docUserCompetence) {
        getDocUserCompetences().remove(docUserCompetence);
        docUserCompetence.setSysUser(null);

        return docUserCompetence;
    }

    public List<SubdivisionExecutive> getLnkSubdivisionExecutives() {
        return this.lnkSubdivisionExecutives;
    }

    public void setLnkSubdivisionExecutives(List<SubdivisionExecutive> lnkSubdivisionExecutives) {
        this.lnkSubdivisionExecutives = lnkSubdivisionExecutives;
    }

    public SubdivisionExecutive addLnkSubdivisionExecutive(SubdivisionExecutive lnkSubdivisionExecutive) {
        getLnkSubdivisionExecutives().add(lnkSubdivisionExecutive);
        lnkSubdivisionExecutive.setSysUser(this);

        return lnkSubdivisionExecutive;
    }

    public SubdivisionExecutive removeLnkSubdivisionExecutive(SubdivisionExecutive lnkSubdivisionExecutive) {
        getLnkSubdivisionExecutives().remove(lnkSubdivisionExecutive);
        lnkSubdivisionExecutive.setSysUser(null);

        return lnkSubdivisionExecutive;
    }

    public List<UserRole> getLnkUserRoles() {
        return this.lnkUserRoles;
    }

    public void setLnkUserRoles(List<UserRole> lnkUserRoles) {
        this.lnkUserRoles = lnkUserRoles;
    }

    public UserRole addLnkUserRole(UserRole lnkUserRole) {
        getLnkUserRoles().add(lnkUserRole);
        lnkUserRole.setSysUser(this);

        return lnkUserRole;
    }

    public UserRole removeLnkUserRole(UserRole lnkUserRole) {
        getLnkUserRoles().remove(lnkUserRole);
        lnkUserRole.setSysUser(null);

        return lnkUserRole;
    }

    public Subdivision getDictSubdivision() {
        return this.dictSubdivision;
    }

    public void setDictSubdivision(Subdivision dictSubdivision) {
        this.dictSubdivision = dictSubdivision;
    }

    public Position getDictPosition() {
        return this.dictPosition;
    }

    public void setDictPosition(Position dictPosition) {
        this.dictPosition = dictPosition;
    }

}