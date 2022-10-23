package ucb.app.dto;

public class LogGlobalCountDto {
    private Integer idBusiness;
    private Integer idBranch;
    private Integer count;

    public LogGlobalCountDto(Integer idBusiness, Integer idBranch, Integer count) {
        this.idBusiness = idBusiness;
        this.idBranch = idBranch;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "LogGlobalCountDto [idBusiness=" + idBusiness + ", idBranch=" + idBranch + ", count=" + count + "]";
    }
}
