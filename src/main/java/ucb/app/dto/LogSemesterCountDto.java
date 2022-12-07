package ucb.app.dto;

public class LogSemesterCountDto {
    private Integer idBusiness;
    private String name;
    private Integer idBranch;
    private String address;
    private Integer year;
    private Integer count;
    private Integer semester;
    private Integer yearSemeter;

    public LogSemesterCountDto(Integer idBusiness, String name, Integer idBranch, String address, Integer year,
            Integer count, Integer semester, Integer yearSemeter) {
        this.idBusiness = idBusiness;
        this.name = name;
        this.idBranch = idBranch;
        this.address = address;
        this.year = year;
        this.count = count;
        this.semester = semester;
        this.yearSemeter = yearSemeter;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }

    public Integer getYearSemeter() {
        return yearSemeter;
    }

    public void setYearSemeter(Integer yearSemeter) {
        this.yearSemeter = yearSemeter;
    }

    @Override
    public String toString() {
        return "LogSemesterCountDto [idBusiness=" + idBusiness + ", name=" + name + ", idBranch=" + idBranch
                + ", address=" + address + ", year=" + year + ", count=" + count + ", semester=" + semester
                + ", yearSemeter=" + yearSemeter + "]";
    }
}
