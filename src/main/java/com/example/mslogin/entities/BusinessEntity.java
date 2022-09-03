package com.example.mslogin.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "business", schema = "service_maps", catalog = "")
public class BusinessEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_business", nullable = false)
    private int idBusiness;
    @Basic
    @Column(name = "name", nullable = false, length = 150)
    private String name;
    @Basic
    @Column(name = "description", nullable = false, length = 250)
    private String description;
    @Basic
    @Column(name = "id_type_business", nullable = false)
    private int idTypeBusiness;
    @Basic
    @Column(name = "id_user", nullable = false)
    private int idUser;
    @Basic
    @Column(name = "create_date", nullable = false)
    private Date createDate;
    @Basic
    @Column(name = "update_date", nullable = false)
    private Date updateDate;
    @Basic
    @Column(name = "status", nullable = false)
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
