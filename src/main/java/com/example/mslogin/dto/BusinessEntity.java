package com.example.mslogin.dto;

import java.sql.Date;
import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "business", schema = "service_maps", catalog = "")
public class BusinessEntity {
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id
    @javax.persistence.Column(name = "id_business")
    private int idBusiness;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "name")
    private String name;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "description")
    private String description;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "id_type_business")
    private int idTypeBusiness;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "id_user")
    private int idUser;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "create_date")
    private Date createDate;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "update_date")
    private Date updateDate;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "status")
    private int status;

    public int getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(int idBusiness) {
        this.idBusiness = idBusiness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdTypeBusiness() {
        return idTypeBusiness;
    }

    public void setIdTypeBusiness(int idTypeBusiness) {
        this.idTypeBusiness = idTypeBusiness;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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
        BusinessEntity that = (BusinessEntity) o;
        return idBusiness == that.idBusiness && idTypeBusiness == that.idTypeBusiness && idUser == that.idUser && status == that.status && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(createDate, that.createDate) && Objects.equals(updateDate, that.updateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBusiness, name, description, idTypeBusiness, idUser, createDate, updateDate, status);
    }
}
