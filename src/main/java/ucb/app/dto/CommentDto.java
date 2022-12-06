package ucb.app.dto;

public class CommentDto {
    private Integer idComment;
    private String message;
    private int idUser;
    private int idBusiness;
    private int status;

    public CommentDto(Integer idComment, String message, int idUser, int idBusiness, int status) {
        this.idComment = idComment;
        this.message = message;
        this.idUser = idUser;
        this.idBusiness = idBusiness;
        this.status = status;
    }

    public Integer getIdComment() {
        return idComment;
    }

    public void setIdComment(Integer idComment) {
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
    public String toString() {
        return "CommentDto [idBusiness=" + idBusiness + ", idComment=" + idComment + ", idUser=" + idUser + ", message="
                + message + ", status=" + status + "]";
    }
}
