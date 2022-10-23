package ucb.app.dto;

import java.util.Date;

public class LogDto {
    private Integer idLog;
    private Date date;
    private Integer idBusiness;
    private Integer idBranch;
    private Integer idUser;

    public LogDto(Integer idLog, Date date, Integer idBusiness, Integer idBranch, Integer idUser) {
        this.idLog = idLog;
        this.date = date;
        this.idBusiness = idBusiness;
        this.idBranch = idBranch;
        this.idUser = idUser;
    }

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(Integer idBusiness) {
        this.idBusiness = idBusiness;
    }

    public Integer getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "LogDto [idLog=" + idLog + ", date=" + date + ", idBusiness=" + idBusiness + ", idBranch=" + idBranch
                + ", idUser=" + idUser + "]";
    }
}
