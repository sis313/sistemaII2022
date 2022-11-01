package ucb.app.dto;

public class LogGlobalCountDto {
    private Integer idBusiness;
    private String name;
    private Integer idBranch;
    private String address;
    private Integer count;

    public LogGlobalCountDto(Integer idBusiness, String name, Integer idBranch, String address, Integer count) {
        this.idBusiness = idBusiness;
        this.name = name;
        this.idBranch = idBranch;
        this.address = address;
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "LogGlobalCountDto [idBusiness=" + idBusiness + ", name=" + name + ", idBranch=" + idBranch
                + ", address=" + address + ", count=" + count + "]";
    }
}
