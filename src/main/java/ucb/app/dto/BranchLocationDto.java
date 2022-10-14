package ucb.app.dto;

import java.util.Date;

public class BranchLocationDto {
    private Integer idBranch;
    private String address;
    private Date openHour;
    private Date closeHour;
    private String attentionDays;
    private String image;
    private int idZone;
    private int idLocation;
    private int idBusiness;
    private Date createDate;
    private Date updateDate;
    private int status;
    private LocationDto locationDto;
    private String businessName;

    public BranchLocationDto(Integer idBranch, String address, Date openHour, Date closeHour, String attentionDays,
            String image, int idZone, int idLocation, int idBusiness, Date createDate, Date updateDate, int status,
            LocationDto locationDto, String businessName) {
        this.idBranch = idBranch;
        this.address = address;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.attentionDays = attentionDays;
        this.image = image;
        this.idZone = idZone;
        this.idLocation = idLocation;
        this.idBusiness = idBusiness;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
        this.locationDto = locationDto;
        this.businessName = businessName;
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

    public Date getOpenHour() {
        return openHour;
    }

    public void setOpenHour(Date openHour) {
        this.openHour = openHour;
    }

    public Date getCloseHour() {
        return closeHour;
    }

    public void setCloseHour(Date closeHour) {
        this.closeHour = closeHour;
    }

    public String getAttentionDays() {
        return attentionDays;
    }

    public void setAttentionDays(String attentionDays) {
        this.attentionDays = attentionDays;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getIdZone() {
        return idZone;
    }

    public void setIdZone(int idZone) {
        this.idZone = idZone;
    }

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public int getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(int idBusiness) {
        this.idBusiness = idBusiness;
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

    public LocationDto getLocationDto() {
        return locationDto;
    }

    public void setLocationDto(LocationDto locationDto) {
        this.locationDto = locationDto;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    @Override
    public String toString() {
        return "BranchLocationDto [idBranch=" + idBranch + ", address=" + address + ", openHour=" + openHour
                + ", closeHour=" + closeHour + ", attentionDays=" + attentionDays + ", image=" + image + ", idZone="
                + idZone + ", idLocation=" + idLocation + ", idBusiness=" + idBusiness + ", createDate=" + createDate
                + ", updateDate=" + updateDate + ", status=" + status + ", locationDto=" + locationDto
                + ", businessName=" + businessName + "]";
    }
}
