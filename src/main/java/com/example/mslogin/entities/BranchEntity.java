package com.example.mslogin.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;

@Entity
@Table(name = "branch", schema = "service_maps", catalog = "")
public class BranchEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_branch")
    private int idBranch;
    @Basic
    @Column(name = "direction")
    private String direction;
    @Basic
    @Column(name = "open_hour")
    private Time openHour;
    @Basic
    @Column(name = "close_hour")
    private Time closeHour;
    @Basic
    @Column(name = "attention_days")
    private String attentionDays;
    @Basic
    @Column(name = "image")
    private byte[] image;
    @Basic
    @Column(name = "id_zone")
    private int idZone;
    @Basic
    @Column(name = "id_location")
    private int idLocation;
    @Basic
    @Column(name = "id_business")
    private int idBusiness;
    @Basic
    @Column(name = "create_date")
    private Date createDate;
    @Basic
    @Column(name = "update_date")
    private Date updateDate;
    @Basic
    @Column(name = "status")
    private int status;
    @ManyToOne
    @JoinColumn(name = "id_zone", referencedColumnName = "id_zone", nullable = false)
    private ZoneEntity zoneByIdZone;
    @ManyToOne
    @JoinColumn(name = "id_location", referencedColumnName = "id_location", nullable = false)
    private LocationEntity locationByIdLocation;
    @ManyToOne
    @JoinColumn(name = "id_business", referencedColumnName = "id_business", nullable = false)
    private BusinessEntity businessByIdBusiness;

    public int getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(int idBranch) {
        this.idBranch = idBranch;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Time getOpenHour() {
        return openHour;
    }

    public void setOpenHour(Time openHour) {
        this.openHour = openHour;
    }

    public Time getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(Time closeHour) {
        this.closeHour = closeHour;
    }

    public String getAttentionDays() {
        return attentionDays;
    }

    public void setAttentionDays(String attentionDays) {
        this.attentionDays = attentionDays;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getIdZone() {
        return idZone;
    }

    public void setIdZone(int idZone) {
        this.idZone = idZone;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public int getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(int idBusiness) {
        this.idBusiness = idBusiness;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BranchEntity that = (BranchEntity) o;

        if (idBranch != that.idBranch) return false;
        if (idZone != that.idZone) return false;
        if (idLocation != that.idLocation) return false;
        if (idBusiness != that.idBusiness) return false;
        if (status != that.status) return false;
        if (direction != null ? !direction.equals(that.direction) : that.direction != null) return false;
        if (openHour != null ? !openHour.equals(that.openHour) : that.openHour != null) return false;
        if (closeHour != null ? !closeHour.equals(that.closeHour) : that.closeHour != null) return false;
        if (attentionDays != null ? !attentionDays.equals(that.attentionDays) : that.attentionDays != null)
            return false;
        if (!Arrays.equals(image, that.image)) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBranch;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        result = 31 * result + (openHour != null ? openHour.hashCode() : 0);
        result = 31 * result + (closeHour != null ? closeHour.hashCode() : 0);
        result = 31 * result + (attentionDays != null ? attentionDays.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(image);
        result = 31 * result + idZone;
        result = 31 * result + idLocation;
        result = 31 * result + idBusiness;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + status;
        return result;
    }

    public ZoneEntity getZoneByIdZone() {
        return zoneByIdZone;
    }

    public void setZoneByIdZone(ZoneEntity zoneByIdZone) {
        this.zoneByIdZone = zoneByIdZone;
    }

    public LocationEntity getLocationByIdLocation() {
        return locationByIdLocation;
    }

    public void setLocationByIdLocation(LocationEntity locationByIdLocation) {
        this.locationByIdLocation = locationByIdLocation;
    }

    public BusinessEntity getBusinessByIdBusiness() {
        return businessByIdBusiness;
    }

    public void setBusinessByIdBusiness(BusinessEntity businessByIdBusiness) {
        this.businessByIdBusiness = businessByIdBusiness;
    }
}
