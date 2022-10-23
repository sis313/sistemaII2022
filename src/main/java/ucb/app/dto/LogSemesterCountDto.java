package ucb.app.dto;

public class LogSemesterCountDto {
    private Integer idBusiness;
    private Integer idBranch;
    private Integer year;
    private Integer count;
    private Integer semester;
    private Integer yearSemeter;

    public LogSemesterCountDto(Integer idBusiness, Integer idBranch, Integer year, Integer count, Integer semester,
            Integer yearSemeter) {
        this.idBusiness = idBusiness;
        this.idBranch = idBranch;
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
        return "LogSemesterCountDto [idBusiness=" + idBusiness + ", idBranch=" + idBranch + ", year=" + year
                + ", count=" + count + ", semester=" + semester + ", yearSemeter=" + yearSemeter + "]";
    }
}
