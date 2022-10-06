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
@Table(name = "municipalities")
@NamedQueries({
        @NamedQuery(name = "Municipalities.findAll", query = "SELECT m FROM Municipalities m"),
        @NamedQuery(name = "Municipalities.findByIdMunicipalities", query = "SELECT m FROM Municipalities m WHERE m.idMunicipalities = :idMunicipalities"),
        @NamedQuery(name = "Municipalities.findByName", query = "SELECT m FROM Municipalities m WHERE m.name = :name"),
        @NamedQuery(name = "Municipalities.findByIdCity", query = "SELECT m FROM Municipalities m WHERE m.idCity = :idCity") })
public class Municipalities implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_municipalities")
    private Integer idMunicipalities;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "id_city")
    private int idCity;

    public Municipalities() {
    }

    public Municipalities(Integer idMunicipalities) {
        this.idMunicipalities = idMunicipalities;
    }

    public Municipalities(Integer idMunicipalities, String name, int idCity) {
        this.idMunicipalities = idMunicipalities;
        this.name = name;
        this.idCity = idCity;
    }

    public Integer getIdMunicipalities() {
        return idMunicipalities;
    }

    public void setIdMunicipalities(Integer idMunicipalities) {
        this.idMunicipalities = idMunicipalities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMunicipalities != null ? idMunicipalities.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Municipalities)) {
            return false;
        }
        Municipalities other = (Municipalities) object;
        if ((this.idMunicipalities == null && other.idMunicipalities != null)
                || (this.idMunicipalities != null && !this.idMunicipalities.equals(other.idMunicipalities))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.serviceproject.Municipalities[ idMunicipalities=" + idMunicipalities + " ]";
    }

}
