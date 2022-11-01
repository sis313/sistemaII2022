package ucb.app.dto;

public class LogMonthCountDto {
    private Integer idBusiness;
    private String name;
    private Integer idBranch;
    private String address;
    private Integer year;
    private Integer month;
    private Integer count;

    public LogMonthCountDto(Integer idBusiness, String name, Integer idBranch, String address, Integer year,
            Integer month, Integer count) {
        this.idBusiness = idBusiness;
        this.name = name;
        this.idBranch = idBranch;
        this.address = address;
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
        return "LogMonthCountDto [idBusiness=" + idBusiness + ", name=" + name + ", idBranch=" + idBranch + ", address="
                + address + ", year=" + year + ", month=" + month + ", count=" + count + "]";
    }
}
