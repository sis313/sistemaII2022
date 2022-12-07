package ucb.app.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 *
 * @author ronaldorojasayala
 */
@Entity
@Table(name = "location")
@NamedQueries({
        @NamedQuery(name = "Location.findAll", query = "SELECT l FROM Location l"),
        @NamedQuery(name = "Location.findByIdLocation", query = "SELECT l FROM Location l WHERE l.idLocation = :idLocation"),
        @NamedQuery(name = "Location.findByLatitude", query = "SELECT l FROM Location l WHERE l.latitude = :latitude"),
        @NamedQuery(name = "Location.findByLongitude", query = "SELECT l FROM Location l WHERE l.longitude = :longitude") })
public class Location implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_location")
    private Integer idLocation;
    // @Max(value=?) @Min(value=?)//if you know range of your decimal fields
    // consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "latitude")
    private BigDecimal latitude;
    @Basic(optional = false)
    @Column(name = "longitude")
    private BigDecimal longitude;

    // CODE CHANGE - START
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idLocation", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Branch> branchList;
    // CODE CHANGE - STOP

    public Location() {
    }

    public Location(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public Location(Integer idLocation, BigDecimal latitude, BigDecimal longitude) {
        this.idLocation = idLocation;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    // CODE CHANGE - START
    public List<Branch> getBranchList() {
        return branchList;
    }

    public void setBranchList(List<Branch> branchList) {
        this.branchList = branchList;
    }
    // CODE CHANGE - STOP

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLocation != null ? idLocation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Location)) {
            return false;
        }
        Location other = (Location) object;
        if ((this.idLocation == null && other.idLocation != null)
                || (this.idLocation != null && !this.idLocation.equals(other.idLocation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.serviceproject.Location[ idLocation=" + idLocation + " ]";
    }

}
