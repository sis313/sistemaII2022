package com.example.mslogin.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "service_maps", catalog = "")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_user", nullable = false)
    private int idUser;
    @Basic
    @Column(name = "name", nullable = false, length = 200)
    private String name;
    @Basic
    @Column(name = "email", nullable = false, length = 150)
    private String email;
    @Basic
    @Column(name = "nickname", nullable = false, length = 20)
    private String nickname;
    @Basic
    @Column(name = "password", nullable = false, length = 20)
    private String password;
    @Basic
    @Column(name = "id_type_user", nullable = false)
    private int idTypeUser;
    @Basic
    @Column(name = "create_date", nullable = false)
    private Date createDate;
    @Basic
    @Column(name = "update_date", nullable = false)
    private Date updateDate;
    @Basic
    @Column(name = "status", nullable = false, length = 10)
    private String status;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdTypeUser() {
        return idTypeUser;
    }

    public void setIdTypeUser(int idTypeUser) {
        this.idTypeUser = idTypeUser;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return idUser == that.idUser && idTypeUser == that.idTypeUser && Objects.equals(name, that.name) && Objects.equals(email, that.email) && Objects.equals(nickname, that.nickname) && Objects.equals(password, that.password) && Objects.equals(createDate, that.createDate) && Objects.equals(updateDate, that.updateDate) && Objects.equals(status, that.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idUser, name, email, nickname, password, idTypeUser, createDate, updateDate, status);
    }
}
