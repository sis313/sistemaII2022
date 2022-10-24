package ucb.app.dto;

public class LogMonthCountDto {
    private Integer idBusiness;
    private Integer idBranch;
    private Integer year;
    private Integer month;
    private Integer count;

    public LogMonthCountDto(Integer idBusiness, Integer idBranch, Integer year, Integer month, Integer count) {
        this.idBusiness = idBusiness;
        this.idBranch = idBranch;
        this.year = year;
        this.month = month;
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

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "LogMonthCountDto [idBusiness=" + idBusiness + ", idBranch=" + idBranch + ", year=" + year + ", month="
                + month + ", count=" + count + "]";
    }
}
