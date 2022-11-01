package ucb.app.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.ConstructorResult;
import javax.persistence.ColumnResult;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonBackReference;

import ucb.app.dto.BranchRatingCountDto;

/**
 *
 * @author ronaldorojasayala
 */
@Entity
@Table(name = "branch")
@NamedQueries({
        @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b"),
        @NamedQuery(name = "Branch.findByIdBranch", query = "SELECT b FROM Branch b WHERE b.idBranch = :idBranch"),
        @NamedQuery(name = "Branch.findByAddress", query = "SELECT b FROM Branch b WHERE b.address = :address"),
        @NamedQuery(name = "Branch.findByOpenHour", query = "SELECT b FROM Branch b WHERE b.openHour = :openHour"),
        @NamedQuery(name = "Branch.findByCloseHour", query = "SELECT b FROM Branch b WHERE b.closeHour = :closeHour"),
        @NamedQuery(name = "Branch.findByAttentionDays", query = "SELECT b FROM Branch b WHERE b.attentionDays = :attentionDays"),
        @NamedQuery(name = "Branch.findByImage", query = "SELECT b FROM Branch b WHERE b.image = :image"),
        @NamedQuery(name = "Branch.findByIdZone", query = "SELECT b FROM Branch b WHERE b.idZone = :idZone"),
        @NamedQuery(name = "Branch.findByIdLocation", query = "SELECT b FROM Branch b WHERE b.idLocation = :idLocation"),
        @NamedQuery(name = "Branch.findByIdBusiness", query = "SELECT b FROM Branch b WHERE b.idBusiness = :idBusiness"),
        @NamedQuery(name = "Branch.findByCreateDate", query = "SELECT b FROM Branch b WHERE b.createDate = :createDate"),
        @NamedQuery(name = "Branch.findByUpdateDate", query = "SELECT b FROM Branch b WHERE b.updateDate = :updateDate"),
        @NamedQuery(name = "Branch.findByStatus", query = "SELECT b FROM Branch b WHERE b.status = :status") })

@SqlResultSetMapping(name = "BranchRatingCount", classes = @ConstructorResult(targetClass = BranchRatingCountDto.class, columns = {
        @ColumnResult(name = "idBusiness", type = Integer.class),
        @ColumnResult(name = "name", type = String.class),
        @ColumnResult(name = "idBranch", type = Integer.class),
        @ColumnResult(name = "address", type = String.class),
        @ColumnResult(name = "averageScore", type = Double.class),
        @ColumnResult(name = "countIdRating", type = Integer.class) }))

public class Branch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_branch")
    private Integer idBranch;
    @Basic(optional = false)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @Column(name = "open_hour")
    @Temporal(TemporalType.TIME)
    private Date openHour;
    @Basic(optional = false)
    @Column(name = "close_hour")
    @Temporal(TemporalType.TIME)
    private Date closeHour;
    @Basic(optional = false)
    @Column(name = "attention_days")
    private String attentionDays;
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @Column(name = "id_zone")
    private int idZone;
    @Basic(optional = false)
    @Column(name = "id_location")
    private int idLocation;
    @Basic(optional = false)
    @Column(name = "id_business")
    private int idBusiness;
    @CreationTimestamp
    @Basic(optional = false)
    @Column(name = "create_date", updatable = false)
    @Temporal(TemporalType.DATE)
    private Date createDate;
    @Basic(optional = false)
    @UpdateTimestamp
    @Column(name = "update_date", updatable = true)
    @Temporal(TemporalType.DATE)
    private Date updateDate;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;

    // CODE CHANGE - START
    @JoinColumn(name = "id_location", referencedColumnName = "id_location", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Location location;

    @JoinColumn(name = "id_business", referencedColumnName = "id_business", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JsonBackReference
    private Business business;
    // CODE CHANGE - STOP

    public Branch() {
    }

    public Branch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    public Branch(Integer idBranch, String address, Date openHour, Date closeHour, String attentionDays, int idZone,
            int idLocation, int idBusiness, Date createDate, Date updateDate, int status) {
        this.idBranch = idBranch;
        this.address = address;
        this.openHour = openHour;
        this.closeHour = closeHour;
        this.attentionDays = attentionDays;
        this.idZone = idZone;
        this.idLocation = idLocation;
        this.idBusiness = idBusiness;
        this.createDate = createDate;
        this.updateDate = updateDate;
        this.status = status;
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

    // CODE CHANGE - START
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }
    // CODE CHANGE - STOP

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBranch != null ? idBranch.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Branch)) {
            return false;
        }
        Branch other = (Branch) object;
        if ((this.idBranch == null && other.idBranch != null)
                || (this.idBranch != null && !this.idBranch.equals(other.idBranch))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.serviceproject.Branch[ idBranch=" + idBranch + " ]";
    }

}
