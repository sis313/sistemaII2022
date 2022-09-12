package ucb.app.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "branch")
@NamedQueries({
        @NamedQuery(name = "Branch.findAll", query = "SELECT b FROM Branch b"),
        @NamedQuery(name = "Branch.findByIdBranch", query = "SELECT b FROM Branch b WHERE b.idBranch = :idBranch"),
        @NamedQuery(name = "Branch.findByDirection", query = "SELECT b FROM Branch b WHERE b.direction = :direction"),
        @NamedQuery(name = "Branch.findByOpenHour", query = "SELECT b FROM Branch b WHERE b.openHour = :openHour"),
        @NamedQuery(name = "Branch.findByCloseHour", query = "SELECT b FROM Branch b WHERE b.closeHour = :closeHour"),
        @NamedQuery(name = "Branch.findByAttentionDays", query = "SELECT b FROM Branch b WHERE b.attentionDays = :attentionDays"),
        @NamedQuery(name = "Branch.findByIdZone", query = "SELECT b FROM Branch b WHERE b.idZone = :idZone"),
        @NamedQuery(name = "Branch.findByIdLocation", query = "SELECT b FROM Branch b WHERE b.idLocation = :idLocation"),
        @NamedQuery(name = "Branch.findByIdBusiness", query = "SELECT b FROM Branch b WHERE b.idBusiness = :idBusiness"),
        @NamedQuery(name = "Branch.findByCreateDate", query = "SELECT b FROM Branch b WHERE b.createDate = :createDate"),
        @NamedQuery(name = "Branch.findByUpdateDate", query = "SELECT b FROM Branch b WHERE b.updateDate = :updateDate"),
        @NamedQuery(name = "Branch.findByStatus", query = "SELECT b FROM Branch b WHERE b.status = :status") })
public class Branch implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_branch")
    private Integer idBranch;
    @Basic(optional = false)
    @Column(name = "direction")
    private String direction;
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
    @Basic(optional = false)
    @Lob
    @Column(name = "image")
    private byte[] image;
    @Basic(optional = false)
    @Column(name = "id_zone")
    private int idZone;
    @Basic(optional = false)
    @Column(name = "id_location")
    private int idLocation;
    @Basic(optional = false)
    @Column(name = "id_business")
    private int idBusiness;
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

    public Branch() {
    }

    public Branch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    public Branch(Integer idBranch, String direction, Date openHour, Date closeHour, String attentionDays, byte[] image,
            int idZone, int idLocation, int idBusiness, Date createDate, Date updateDate, int status) {
        this.idBranch = idBranch;
        this.direction = direction;
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
    }

    public Integer getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
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
