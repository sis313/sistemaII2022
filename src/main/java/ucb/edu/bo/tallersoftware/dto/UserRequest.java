package ucb.edu.bo.tallersoftware.dto;

import java.util.Date;

public class UserRequest {
    private String name;
    private String email;
    private String nickname;
    private String password;
    private String typeUser;
    private Date createDate;
    private Date updateDate;


    public UserRequest(String name, String email, String nickname, String password, String typeUser, Date createDate, Date updateDate) {
        this.name = name;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.typeUser = typeUser;
        this.createDate = createDate;
        this.updateDate = updateDate;
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

    public String getTypeUser() {
        return this.typeUser;
    }

    public void setTypeUser(String typeUser) {
        this.typeUser = typeUser;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
            " name='" + name + '\'' +
            ", email='" + email + '\'' +
            ", nickname='" + nickname + '\'' +
            ", password='" + password + '\'' +
            ", typeUser='" + typeUser + '\'' +
            ", createDate='" + createDate + '\'' +
            ", updateDate='" + updateDate + '\'' +
            "}";
    }

}
