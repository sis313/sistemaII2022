package com.example.mslogin.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "user", schema = "service_maps", catalog = "")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_user")
    private int idUser;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "nickname")
    private String nickname;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "id_type_user")
    private int idTypeUser;
    @Basic
    @Column(name = "create_date")
    private Date createDate;
    @Basic
    @Column(name = "update_date")
    private Date updateDate;
    @Basic
    @Column(name = "status")
    private String status;
    @OneToMany(mappedBy = "userByIdUser")
    private Collection<BookingEntity> bookingsByIdUser;
    @OneToMany(mappedBy = "userByUserIdUser")
    private Collection<BusinessEntity> businessesByIdUser;
    @OneToMany(mappedBy = "userByIdUser")
    private Collection<CommentEntity> commentsByIdUser;
    @ManyToOne
    @JoinColumn(name = "id_type_user", referencedColumnName = "id_type_user", nullable = false)
    private TypeUserEntity typeUserByIdTypeUser;

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

        if (idUser != that.idUser) return false;
        if (idTypeUser != that.idTypeUser) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (nickname != null ? !nickname.equals(that.nickname) : that.nickname != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idUser;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (nickname != null ? nickname.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + idTypeUser;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    public Collection<BookingEntity> getBookingsByIdUser() {
        return bookingsByIdUser;
    }

    public void setBookingsByIdUser(Collection<BookingEntity> bookingsByIdUser) {
        this.bookingsByIdUser = bookingsByIdUser;
    }

    public Collection<BusinessEntity> getBusinessesByIdUser() {
        return businessesByIdUser;
    }

    public void setBusinessesByIdUser(Collection<BusinessEntity> businessesByIdUser) {
        this.businessesByIdUser = businessesByIdUser;
    }

    public Collection<CommentEntity> getCommentsByIdUser() {
        return commentsByIdUser;
    }

    public void setCommentsByIdUser(Collection<CommentEntity> commentsByIdUser) {
        this.commentsByIdUser = commentsByIdUser;
    }

    public TypeUserEntity getTypeUserByIdTypeUser() {
        return typeUserByIdTypeUser;
    }

    public void setTypeUserByIdTypeUser(TypeUserEntity typeUserByIdTypeUser) {
        this.typeUserByIdTypeUser = typeUserByIdTypeUser;
    }
}
