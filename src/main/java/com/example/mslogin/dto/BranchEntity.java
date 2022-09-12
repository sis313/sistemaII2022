package com.example.mslogin.dto;

import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "branch", schema = "service_maps", catalog = "")
public class BranchEntity {
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id
    @javax.persistence.Column(name = "id_branch")
    private int idBranch;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "address")
    private String address;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "open_hour")
    private Time openHour;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "close_hour")
    private Time closeHour;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "attention_days")
    private String attentionDays;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "image")
    private byte[] image;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "id_zone")
    private int idZone;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "id_location")
    private int idLocation;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "id_business")
    private int idBusiness;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "create_date")
    private Date createDate;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "update_date")
    private Date updateDate;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "status")
    private int status;

    public int getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(int idBranch) {
        this.idBranch = idBranch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return idBranch == that.idBranch && idZone == that.idZone && idLocation == that.idLocation && idBusiness == that.idBusiness && status == that.status && Objects.equals(address, that.address) && Objects.equals(openHour, that.openHour) && Objects.equals(closeHour, that.closeHour) && Objects.equals(attentionDays, that.attentionDays) && Arrays.equals(image, that.image) && Objects.equals(createDate, that.createDate) && Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(idBranch, address, openHour, closeHour, attentionDays, idZone, idLocation, idBusiness, createDate, updateDate, status);
        result = 31 * result + Arrays.hashCode(image);
        return result;
    }
}
