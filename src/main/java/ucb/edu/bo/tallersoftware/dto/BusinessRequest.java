package ucb.edu.bo.tallersoftware.dto;

import java.util.Date;
import java.util.Objects;

public class BusinessRequest {
    private String name;
    private String description;
    private int id_type_business;
    private Date createDate;
    private Date updateDate;
    private int status;

    public BusinessRequest(String name, String description, int id_type_business, Date createDate, Date updateDate, int status) {
        this.name = name;
        this.description = description;
        this.id_type_business = id_type_business;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_type_business() {
        return this.id_type_business;
    }

    public void setId_type_business(int id_type_business) {
        this.id_type_business = id_type_business;
    }

    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public BusinessRequest name(String name) {
        setName(name);
        return this;
    }

    public BusinessRequest description(String description) {
        setDescription(description);
        return this;
    }

    public BusinessRequest id_type_business(int id_type_business) {
        setId_type_business(id_type_business);
        return this;
    }

    public BusinessRequest createDate(Date createDate) {
        setCreateDate(createDate);
        return this;
    }

    public BusinessRequest updateDate(Date updateDate) {
        setUpdateDate(updateDate);
        return this;
    }

    public BusinessRequest status(int status) {
        setStatus(status);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof BusinessRequest)) {
            return false;
        }
        BusinessRequest businessRequest = (BusinessRequest) o;
        return Objects.equals(name, businessRequest.name) && Objects.equals(description, businessRequest.description) && id_type_business == businessRequest.id_type_business && Objects.equals(createDate, businessRequest.createDate) && Objects.equals(updateDate, businessRequest.updateDate) && status == businessRequest.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, id_type_business, createDate, updateDate, status);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", description='" + getDescription() + "'" +
            ", id_type_business='" + getId_type_business() + "'" +
            ", createDate='" + getCreateDate() + "'" +
            ", updateDate='" + getUpdateDate() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }
    
    
}
