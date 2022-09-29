package ucb.edu.bo.demo.dto;

import java.util.Date;

public class Comment {
    private int id_comment;
    private String message;
    private int id_user;
    private int id_business;
    private int status;

    public Comment() { }

    public Comment(int id_comment, String message, int id_user, int id_business, int status) {
        this.id_comment = id_comment;
        this.message = message;
        this.id_user = id_user;
        this.id_business = id_business;
        this.status = status;
    }

    public int getId_comment() {
        return id_comment;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getId_business() {
        return id_business;
    }

    public void setId_business(int id_business) {
        this.id_business = id_business;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
