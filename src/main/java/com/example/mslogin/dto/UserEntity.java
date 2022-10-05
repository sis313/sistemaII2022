package com.example.mslogin.dto;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.sql.Date;
import java.util.List;
import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "user", schema = "service_maps", catalog = "")
public class UserEntity {
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id
    @javax.persistence.Column(name = "id_user")
    private int idUser;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "name")
    private String name;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "email")
    private String email;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "nickname")
    private String nickname;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "password")
    private String password;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "id_type_user")
    private int idTypeUser;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "create_date")
    private Date createDate;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "update_date")
    private Date updateDate;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "status")
    private String status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name="users_roles",
            joinColumns={@JoinColumn(name="user_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private List<RoleEntity> roles;
    public UserEntity() {
    }

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

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
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

    @Override
    public String toString() {
        return "UserEntity{" +
                "idUser=" + idUser +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", idTypeUser=" + idTypeUser +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", status='" + status + '\'' +
                '}';
    }
}
