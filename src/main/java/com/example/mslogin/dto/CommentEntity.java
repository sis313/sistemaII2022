package com.example.mslogin.dto;

import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "comment", schema = "service_maps", catalog = "")
public class CommentEntity {
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id
    @javax.persistence.Column(name = "id_comment")
    private int idComment;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "message")
    private String message;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "id_user")
    private int idUser;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "id_business")
    private int idBusiness;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "status")
    private int status;

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
        return idComment == that.idComment && idUser == that.idUser && idBusiness == that.idBusiness && status == that.status && Objects.equals(message, that.message);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idComment, message, idUser, idBusiness, status);
    }
}
