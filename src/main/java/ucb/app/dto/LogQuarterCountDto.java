package ucb.app.dto;

public class LogQuarterCountDto {
    private Integer idBusiness;
    private String name;
    private Integer idBranch;
    private String address;
    private Integer year;
    private Integer quarter;
    private Integer count;

    public LogQuarterCountDto(Integer idBusiness, String name, Integer idBranch, String address, Integer year,
            Integer quarter, Integer count) {
        this.idBusiness = idBusiness;
        this.name = name;
        this.idBranch = idBranch;
        this.address = address;
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
        return "LogQuarterCountDto [idBusiness=" + idBusiness + ", name=" + name + ", idBranch=" + idBranch
                + ", address=" + address + ", year=" + year + ", quarter=" + quarter + ", count=" + count + "]";
    }
}
