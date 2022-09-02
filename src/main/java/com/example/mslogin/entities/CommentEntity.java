package com.example.mslogin.entities;

import javax.persistence.*;

@Entity
@Table(name = "comment", schema = "service_maps", catalog = "")
public class CommentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_comment")
    private int idComment;
    @Basic
    @Column(name = "message")
    private String message;
    @Basic
    @Column(name = "id_user")
    private int idUser;
    @Basic
    @Column(name = "id_business")
    private int idBusiness;
    @Basic
    @Column(name = "status")
    private int status;
    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user", nullable = false)
    private UserEntity userByIdUser;
    @ManyToOne
    @JoinColumn(name = "id_business", referencedColumnName = "id_business", nullable = false)
    private BusinessEntity businessByIdBusiness;

    public int getIdComment() {
        return idComment;
    }

    public void setIdComment(int idComment) {
        this.idComment = idComment;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(int idBusiness) {
        this.idBusiness = idBusiness;
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

        CommentEntity that = (CommentEntity) o;

        if (idComment != that.idComment) return false;
        if (idUser != that.idUser) return false;
        if (idBusiness != that.idBusiness) return false;
        if (status != that.status) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idComment;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        result = 31 * result + idUser;
        result = 31 * result + idBusiness;
        result = 31 * result + status;
        return result;
    }

    public UserEntity getUserByIdUser() {
        return userByIdUser;
    }

    public void setUserByIdUser(UserEntity userByIdUser) {
        this.userByIdUser = userByIdUser;
    }

    public BusinessEntity getBusinessByIdBusiness() {
        return businessByIdBusiness;
    }

    public void setBusinessByIdBusiness(BusinessEntity businessByIdBusiness) {
        this.businessByIdBusiness = businessByIdBusiness;
    }
}
