package ucb.edu.bo.tallersoftware.dto;

//import java.util.Date;

public class UserRequest {
    private String name;
    private String email;
    private String nickname;
    private String password;
    private String typeUser;
    private String createDate;
    private String updateDate;
    private String status;

    public UserRequest(String name, String email, String nickname, String password, String typeUser, String createDate, String updateDate, String status) {
        this.name = name;
        this.email = email;
        this.nickname = nickname;
        this.password = password;
        this.typeUser = typeUser;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
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
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
            ", status='" + status + '\''+
            "}";
    }


}
