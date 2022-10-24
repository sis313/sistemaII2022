package ucb.app.dto;

import java.util.Date;

public class LogDayCountDto {
    private Integer idBusiness;
    private Integer idBranch;
    private Date date;
    private Integer count;

    public LogDayCountDto(Integer idBusiness, Integer idBranch, Date date, Integer count) {
        this.idBusiness = idBusiness;
        this.idBranch = idBranch;
        this.date = date;
        this.count = count;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "LogDayCountDto [idBusiness=" + idBusiness + ", idBranch=" + idBranch + ", date=" + date + ", count="
                + count + "]";
    }
}
