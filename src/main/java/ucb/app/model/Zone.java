package ucb.app.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author ronaldorojasayala
 */
@Entity
@Table(name = "zone")
@NamedQueries({
        @NamedQuery(name = "Zone.findAll", query = "SELECT z FROM Zone z"),
        @NamedQuery(name = "Zone.findByIdZone", query = "SELECT z FROM Zone z WHERE z.idZone = :idZone"),
        @NamedQuery(name = "Zone.findByName", query = "SELECT z FROM Zone z WHERE z.name = :name"),
        @NamedQuery(name = "Zone.findByIdMunicipalities", query = "SELECT z FROM Zone z WHERE z.idMunicipalities = :idMunicipalities") })
public class Zone implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_zone")
    private Integer idZone;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "id_municipalities")
    private int idMunicipalities;

    public Zone() {
    }

    public Zone(Integer idZone) {
        this.idZone = idZone;
    }

    public Zone(Integer idZone, String name, int idMunicipalities) {
        this.idZone = idZone;
        this.name = name;
        this.idMunicipalities = idMunicipalities;
    }

    public Integer getIdZone() {
        return idZone;
    }

    public void setIdZone(Integer idZone) {
        this.idZone = idZone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdMunicipalities() {
        return idMunicipalities;
    }

    public void setIdMunicipalities(int idMunicipalities) {
        this.idMunicipalities = idMunicipalities;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idZone != null ? idZone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Zone)) {
            return false;
        }
        Zone other = (Zone) object;
        if ((this.idZone == null && other.idZone != null)
                || (this.idZone != null && !this.idZone.equals(other.idZone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.serviceproject.Zone[ idZone=" + idZone + " ]";
    }

}
