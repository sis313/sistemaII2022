package com.example.mslogin.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "type_business", schema = "service_maps", catalog = "")
public class TypeBusinessEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_type_business")
    private int idTypeBusiness;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "typeBusinessByIdTypeBusiness")
    private Collection<BusinessEntity> businessesByIdTypeBusiness;

    public int getIdTypeBusiness() {
        return idTypeBusiness;
    }

    public void setIdTypeBusiness(int idTypeBusiness) {
        this.idTypeBusiness = idTypeBusiness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeBusinessEntity that = (TypeBusinessEntity) o;

        if (idTypeBusiness != that.idTypeBusiness) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTypeBusiness;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<BusinessEntity> getBusinessesByIdTypeBusiness() {
        return businessesByIdTypeBusiness;
    }

    public void setBusinessesByIdTypeBusiness(Collection<BusinessEntity> businessesByIdTypeBusiness) {
        this.businessesByIdTypeBusiness = businessesByIdTypeBusiness;
    }
}
