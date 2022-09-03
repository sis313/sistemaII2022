package com.example.mslogin.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "comment", schema = "service_maps", catalog = "")
public class CommentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_comment", nullable = false)
    private int idComment;
    @Basic
    @Column(name = "message", nullable = false, length = 255)
    private String message;
    @Basic
    @Column(name = "id_user", nullable = false)
    private int idUser;
    @Basic
    @Column(name = "id_business", nullable = false)
    private int idBusiness;
    @Basic
    @Column(name = "status", nullable = false)
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
