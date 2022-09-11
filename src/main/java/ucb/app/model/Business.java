package ucb.app.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ronaldorojasayala
 */
@Entity
@Table(name = "business")
@NamedQueries({
        @NamedQuery(name = "Business.findAll", query = "SELECT b FROM Business b"),
        @NamedQuery(name = "Business.findByIdBusiness", query = "SELECT b FROM Business b WHERE b.idBusiness = :idBusiness"),
        @NamedQuery(name = "Business.findByName", query = "SELECT b FROM Business b WHERE b.name = :name"),
        @NamedQuery(name = "Business.findByDescription", query = "SELECT b FROM Business b WHERE b.description = :description"),
        @NamedQuery(name = "Business.findByIdTypeBusiness", query = "SELECT b FROM Business b WHERE b.idTypeBusiness = :idTypeBusiness"),
        @NamedQuery(name = "Business.findByCreateDate", query = "SELECT b FROM Business b WHERE b.createDate = :createDate"),
        @NamedQuery(name = "Business.findByUpdateDate", query = "SELECT b FROM Business b WHERE b.updateDate = :updateDate"),
        @NamedQuery(name = "Business.findByStatus", query = "SELECT b FROM Business b WHERE b.status = :status"),
        @NamedQuery(name = "Business.findByUserIdUser", query = "SELECT b FROM Business b WHERE b.userIdUser = :userIdUser") })
public class Business implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_business")
    private Integer idBusiness;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @Column(name = "id_type_business")
    private int idTypeBusiness;
    @Basic(optional = false)
    @Column(name = "create_date")
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Basic(optional = false)
    @Column(name = "update_date")
    @Temporal(TemporalType.DATE)
    private Date updateDate;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "user_id_user")
    private int userIdUser;

    public Business() {
    }

    public Business(Integer idBusiness) {
        this.idBusiness = idBusiness;
    }

    public Business(Integer idBusiness, String name, String description, int idTypeBusiness, Date createDate,
            Date updateDate, int status, int userIdUser) {
        this.idBusiness = idBusiness;
        this.name = name;
        this.description = description;
        this.idTypeBusiness = idTypeBusiness;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
        this.userIdUser = userIdUser;
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
    public int hashCode() {
        int hash = 0;
        hash += (idBusiness != null ? idBusiness.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Business)) {
            return false;
        }
        Business other = (Business) object;
        if ((this.idBusiness == null && other.idBusiness != null)
                || (this.idBusiness != null && !this.idBusiness.equals(other.idBusiness))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.serviceproject.Business[ idBusiness=" + idBusiness + " ]";
    }

}
