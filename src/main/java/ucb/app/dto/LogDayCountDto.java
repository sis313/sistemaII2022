package ucb.app.dto;

import java.util.Date;

public class LogDayCountDto {
    private Integer idBusiness;
    private String name;
    private Integer idBranch;
    private String address;
    private Date date;
    private Integer count;

    public LogDayCountDto(Integer idBusiness, String name, Integer idBranch, String address, Date date, Integer count) {
        this.idBusiness = idBusiness;
        this.name = name;
        this.idBranch = idBranch;
        this.address = address;
        this.date = date;
        this.count = count;
    }

    public Integer getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(Integer idBusiness) {
        this.idBusiness = idBusiness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "LogDayCountDto [idBusiness=" + idBusiness + ", name=" + name + ", idBranch=" + idBranch + ", address="
                + address + ", date=" + date + ", count=" + count + "]";
    }
}
