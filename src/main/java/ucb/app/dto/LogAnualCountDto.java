package ucb.app.dto;

public class LogAnualCountDto {
    private Integer idBusiness;
    private Integer idBranch;
    private Integer year;
    private Integer count;

    public LogAnualCountDto(Integer idBusiness, Integer idBranch, Integer year, Integer count) {
        this.idBusiness = idBusiness;
        this.idBranch = idBranch;
        this.year = year;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "LogAnualCountDto [idBusiness=" + idBusiness + ", idBranch=" + idBranch + ", year=" + year + ", count="
                + count + "]";
    }
}
