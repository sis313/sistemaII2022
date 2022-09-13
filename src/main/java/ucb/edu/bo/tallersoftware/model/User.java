package ucb.edu.bo.tallersoftware.model;

import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;

//import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "user")
@SQLDelete(sql = "UPDATE user SET status=0 WHERE id_user=?")
//@Where(clause = "status = 1")
public class User {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_user")
    private int id;
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
    private int typeUserId;
    @Basic
    @Column(name = "create_date")
    private String createDate;
    @Basic
    @Column(name = "update_date")
    private String updateDate;
    @Basic
    @Column(name = "status")
    private int status;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return this.nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTypeUserId() {
        return this.typeUserId;
    }

    public void setTypeUserId(int typeUserId) {
        this.typeUserId = typeUserId;
    }

    public String getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return id == user.id && Objects.equals(name, user.name) && Objects.equals(email, user.email) && Objects.equals(nickname, user.nickname) && Objects.equals(password, user.password) && typeUserId == user.typeUserId && Objects.equals(createDate, user.createDate) && Objects.equals(updateDate, user.updateDate) && status == user.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, nickname, password, typeUserId, createDate, updateDate, status);
    }


}
