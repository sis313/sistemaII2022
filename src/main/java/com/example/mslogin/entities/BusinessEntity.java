package com.example.mslogin.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "business", schema = "service_maps", catalog = "")
public class BusinessEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_business")
    private int idBusiness;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "id_type_business")
    private int idTypeBusiness;
    @Basic
    @Column(name = "create_date")
    private Date createDate;
    @Basic
    @Column(name = "update_date")
    private Date updateDate;
    @Basic
    @Column(name = "status")
    private int status;
    @Basic
    @Column(name = "user_id_user")
    private int userIdUser;
    @OneToMany(mappedBy = "businessByIdBusiness")
    private Collection<BranchEntity> branchesByIdBusiness;
    @ManyToOne
    @JoinColumn(name = "id_type_business", referencedColumnName = "id_type_business", nullable = false)
    private TypeBusinessEntity typeBusinessByIdTypeBusiness;
    @ManyToOne
    @JoinColumn(name = "user_id_user", referencedColumnName = "id_user", nullable = false)
    private UserEntity userByUserIdUser;
    @OneToMany(mappedBy = "businessByIdBusiness")
    private Collection<CommentEntity> commentsByIdBusiness;
    @OneToMany(mappedBy = "businessByIdBusiness")
    private Collection<ProductEntity> productsByIdBusiness;

    public int getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(int idBusiness) {
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

    public int getUserIdUser() {
        return userIdUser;
    }

    public void setUserIdUser(int userIdUser) {
        this.userIdUser = userIdUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BusinessEntity that = (BusinessEntity) o;

        if (idBusiness != that.idBusiness) return false;
        if (idTypeBusiness != that.idTypeBusiness) return false;
        if (status != that.status) return false;
        if (userIdUser != that.userIdUser) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (createDate != null ? !createDate.equals(that.createDate) : that.createDate != null) return false;
        if (updateDate != null ? !updateDate.equals(that.updateDate) : that.updateDate != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idBusiness;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + idTypeBusiness;
        result = 31 * result + (createDate != null ? createDate.hashCode() : 0);
        result = 31 * result + (updateDate != null ? updateDate.hashCode() : 0);
        result = 31 * result + status;
        result = 31 * result + userIdUser;
        return result;
    }

    public Collection<BranchEntity> getBranchesByIdBusiness() {
        return branchesByIdBusiness;
    }

    public void setBranchesByIdBusiness(Collection<BranchEntity> branchesByIdBusiness) {
        this.branchesByIdBusiness = branchesByIdBusiness;
    }

    public TypeBusinessEntity getTypeBusinessByIdTypeBusiness() {
        return typeBusinessByIdTypeBusiness;
    }

    public void setTypeBusinessByIdTypeBusiness(TypeBusinessEntity typeBusinessByIdTypeBusiness) {
        this.typeBusinessByIdTypeBusiness = typeBusinessByIdTypeBusiness;
    }

    public UserEntity getUserByUserIdUser() {
        return userByUserIdUser;
    }

    public void setUserByUserIdUser(UserEntity userByUserIdUser) {
        this.userByUserIdUser = userByUserIdUser;
    }

    public Collection<CommentEntity> getCommentsByIdBusiness() {
        return commentsByIdBusiness;
    }

    public void setCommentsByIdBusiness(Collection<CommentEntity> commentsByIdBusiness) {
        this.commentsByIdBusiness = commentsByIdBusiness;
    }

    public Collection<ProductEntity> getProductsByIdBusiness() {
        return productsByIdBusiness;
    }

    public void setProductsByIdBusiness(Collection<ProductEntity> productsByIdBusiness) {
        this.productsByIdBusiness = productsByIdBusiness;
    }
}
