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
@Table(name = "type_business")
@NamedQueries({
        @NamedQuery(name = "TypeBusiness.findAll", query = "SELECT t FROM TypeBusiness t"),
        @NamedQuery(name = "TypeBusiness.findByIdTypeBusiness", query = "SELECT t FROM TypeBusiness t WHERE t.idTypeBusiness = :idTypeBusiness"),
        @NamedQuery(name = "TypeBusiness.findByName", query = "SELECT t FROM TypeBusiness t WHERE t.name = :name") })
public class TypeBusiness implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_type_business")
    private Integer idTypeBusiness;
    @Basic(optional = false)
    @Column(name = "name")
    private String name;

    public TypeBusiness() {
    }

    public TypeBusiness(Integer idTypeBusiness) {
        this.idTypeBusiness = idTypeBusiness;
    }

    public TypeBusiness(Integer idTypeBusiness, String name) {
        this.idTypeBusiness = idTypeBusiness;
        this.name = name;
    }

    public Integer getIdTypeBusiness() {
        return idTypeBusiness;
    }

    public void setIdTypeBusiness(Integer idTypeBusiness) {
        this.idTypeBusiness = idTypeBusiness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTypeBusiness != null ? idTypeBusiness.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TypeBusiness)) {
            return false;
        }
        TypeBusiness other = (TypeBusiness) object;
        if ((this.idTypeBusiness == null && other.idTypeBusiness != null)
                || (this.idTypeBusiness != null && !this.idTypeBusiness.equals(other.idTypeBusiness))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.serviceproject.TypeBusiness[ idTypeBusiness=" + idTypeBusiness + " ]";
    }

}
