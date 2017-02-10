package ru.hostco.competence.jpa.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;


/**
 * The persistent class for the dict_Subdivision database table.
 */
@Entity
@Table(name = "dict_Subdivision")
@NamedQuery(name = "Subdivision.findAll", query = "SELECT d FROM Subdivision d")
public class Subdivision extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "SubdivisionId")
    private String id;

    @Column(name = "Dins")
    private Timestamp dins;

    @Column(name = "Dupd")
    private Timestamp dupd;

    @Column(name = "FullName")
    private String fullName;

    @Column(name = "IsActive")
    private boolean isActive;

    @Column(name = "Name")
    private String name;

    @Column(name = "Uins")
    private String uins;

    @Column(name = "Uupd")
    private String uupd;

    //bi-directional many-to-one association to Dict_Subdivision
    @ManyToOne
    @JoinColumn(name = "ParentId")
    private Subdivision dictSubdivision;

    //bi-directional many-to-one association to Dict_Subdivision
    @OneToMany(mappedBy = "dictSubdivision")
    private List<Subdivision> dictSubdivisions;

    //bi-directional many-to-one association to Doc_Campaign
    @OneToMany(mappedBy = "dictSubdivision")
    private List<Campaign> docCampaigns;

    //bi-directional many-to-one association to Lnk_CompetencePosition
    @OneToMany(mappedBy = "dictSubdivision")
    private List<CompetencePosition> lnkCompetencePositions;

    //bi-directional many-to-one association to Lnk_SubdivisionExecutive
    @OneToMany(mappedBy = "dictSubdivision")
    private List<SubdivisionExecutive> lnkSubdivisionExecutives;

    //bi-directional many-to-one association to Sys_User
    @OneToMany(mappedBy = "dictSubdivision")
    private List<User> sysUsers;

    public Subdivision() {
        setId(UUID.randomUUID().toString().toUpperCase());
    }

    public String getId() {
        return this.id;
    }

    public void setId(Object subdivisionId) {
        this.id = (String) subdivisionId;
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

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    public Subdivision getDictSubdivision() {
        return this.dictSubdivision;
    }

    public void setDictSubdivision(Subdivision dictSubdivision) {
        this.dictSubdivision = dictSubdivision;
    }

    public List<Subdivision> getDictSubdivisions() {
        return this.dictSubdivisions;
    }

    public void setDictSubdivisions(List<Subdivision> dictSubdivisions) {
        this.dictSubdivisions = dictSubdivisions;
    }

    public Subdivision addDictSubdivision(Subdivision dictSubdivision) {
        getDictSubdivisions().add(dictSubdivision);
        dictSubdivision.setDictSubdivision(this);

        return dictSubdivision;
    }

    public Subdivision removeDictSubdivision(Subdivision dictSubdivision) {
        getDictSubdivisions().remove(dictSubdivision);
        dictSubdivision.setDictSubdivision(null);

        return dictSubdivision;
    }

    public List<Campaign> getDocCampaigns() {
        return this.docCampaigns;
    }

    public void setDocCampaigns(List<Campaign> docCampaigns) {
        this.docCampaigns = docCampaigns;
    }

    public Campaign addDocCampaign(Campaign docCampaign) {
        getDocCampaigns().add(docCampaign);
        docCampaign.setDictSubdivision(this);

        return docCampaign;
    }

    public Campaign removeDocCampaign(Campaign docCampaign) {
        getDocCampaigns().remove(docCampaign);
        docCampaign.setDictSubdivision(null);

        return docCampaign;
    }

    public List<CompetencePosition> getLnkCompetencePositions() {
        return this.lnkCompetencePositions;
    }

    public void setLnkCompetencePositions(List<CompetencePosition> lnkCompetencePositions) {
        this.lnkCompetencePositions = lnkCompetencePositions;
    }

    public CompetencePosition addLnkCompetencePosition(CompetencePosition lnkCompetencePosition) {
        getLnkCompetencePositions().add(lnkCompetencePosition);
        lnkCompetencePosition.setDictSubdivision(this);

        return lnkCompetencePosition;
    }

    public CompetencePosition removeLnkCompetencePosition(CompetencePosition lnkCompetencePosition) {
        getLnkCompetencePositions().remove(lnkCompetencePosition);
        lnkCompetencePosition.setDictSubdivision(null);

        return lnkCompetencePosition;
    }

    public List<SubdivisionExecutive> getLnkSubdivisionExecutives() {
        return this.lnkSubdivisionExecutives;
    }

    public void setLnkSubdivisionExecutives(List<SubdivisionExecutive> lnkSubdivisionExecutives) {
        this.lnkSubdivisionExecutives = lnkSubdivisionExecutives;
    }

    public SubdivisionExecutive addLnkSubdivisionExecutive(SubdivisionExecutive lnkSubdivisionExecutive) {
        getLnkSubdivisionExecutives().add(lnkSubdivisionExecutive);
        lnkSubdivisionExecutive.setDictSubdivision(this);

        return lnkSubdivisionExecutive;
    }

    public SubdivisionExecutive removeLnkSubdivisionExecutive(SubdivisionExecutive lnkSubdivisionExecutive) {
        getLnkSubdivisionExecutives().remove(lnkSubdivisionExecutive);
        lnkSubdivisionExecutive.setDictSubdivision(null);

        return lnkSubdivisionExecutive;
    }

    public List<User> getSysUsers() {
        return this.sysUsers;
    }

    public void setSysUsers(List<User> sysUsers) {
        this.sysUsers = sysUsers;
    }

    public User addSysUser(User sysUser) {
        getSysUsers().add(sysUser);
        sysUser.setDictSubdivision(this);

        return sysUser;
    }

    public User removeSysUser(User sysUser) {
        getSysUsers().remove(sysUser);
        sysUser.setDictSubdivision(null);

        return sysUser;
    }

}