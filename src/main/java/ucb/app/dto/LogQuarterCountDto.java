package ucb.app.dto;

public class LogQuarterCountDto {
    private Integer idBusiness;
    private Integer idBranch;
    private Integer year;
    private Integer quarter;
    private Integer count;

    public LogQuarterCountDto(Integer idBusiness, Integer idBranch, Integer year, Integer quarter, Integer count) {
        this.idBusiness = idBusiness;
        this.idBranch = idBranch;
        this.year = year;
        this.quarter = quarter;
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

    public Integer getQuarter() {
        return quarter;
    }

    public void setQuarter(Integer quarter) {
        this.quarter = quarter;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "LogQuarterCountDto [idBusiness=" + idBusiness + ", idBranch=" + idBranch + ", year=" + year
                + ", quarter=" + quarter + ", count=" + count + "]";
    }
}
