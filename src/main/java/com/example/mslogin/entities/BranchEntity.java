package com.example.mslogin.entities;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.util.Arrays;
import java.util.Objects;

@Entity
@Table(name = "branch", schema = "service_maps", catalog = "")
public class BranchEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_branch", nullable = false)
    private int idBranch;
    @Basic
    @Column(name = "address", nullable = false, length = 200)
    private String address;
    @Basic
    @Column(name = "open_hour", nullable = false)
    private Time openHour;
    @Basic
    @Column(name = "close_hour", nullable = false)
    private Time closeHour;
    @Basic
    @Column(name = "attention_days", nullable = false, length = 100)
    private String attentionDays;
    @Basic
    @Column(name = "image", nullable = false)
    private byte[] image;
    @Basic
    @Column(name = "id_zone", nullable = false)
    private int idZone;
    @Basic
    @Column(name = "id_location", nullable = false)
    private int idLocation;
    @Basic
    @Column(name = "id_business", nullable = false)
    private int idBusiness;
    @Basic
    @Column(name = "create_date", nullable = false)
    private Date createDate;
    @Basic
    @Column(name = "update_date", nullable = false)
    private Date updateDate;
    @Basic
    @Column(name = "status", nullable = false)
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
