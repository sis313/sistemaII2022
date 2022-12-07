package ucb.app.dto;

import java.util.Date;

public class BusinessBranchActiveCountDto {
    private Integer idBusiness;
    private String name;
    private String description;
    private int idTypeBusiness;
    private int idUser;
    private Date createDate;
    private Date updateDate;
    private int status;
    private int activeBranchCount;

    public BusinessBranchActiveCountDto(Integer idBusiness, String name, String description, int idTypeBusiness,
            int idUser, Date createDate, Date updateDate, int status, int activeBranchCount) {
        this.idBusiness = idBusiness;
        this.name = name;
        this.description = description;
        this.idTypeBusiness = idTypeBusiness;
        this.idUser = idUser;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
        this.activeBranchCount = activeBranchCount;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIdTypeBusiness() {
        return idTypeBusiness;
    }

    public void setIdTypeBusiness(int idTypeBusiness) {
        this.idTypeBusiness = idTypeBusiness;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getActiveBranchCount() {
        return activeBranchCount;
    }

    public void setActiveBranchCount(int activeBranchCount) {
        this.activeBranchCount = activeBranchCount;
    }

    @Override
    public String toString() {
        return "BusinessBranchActiveCountDto [idBusiness=" + idBusiness + ", name=" + name + ", description="
                + description + ", idTypeBusiness=" + idTypeBusiness + ", idUser=" + idUser + ", createDate="
                + createDate + ", updateDate=" + updateDate + ", status=" + status + ", activeBranchCount="
                + activeBranchCount + "]";
    }
}
