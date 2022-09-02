package com.example.mslogin.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "city", schema = "service_maps", catalog = "")
public class CityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_city")
    private int idCity;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "cityByIdCity")
    private Collection<MunicipalitiesEntity> municipalitiesByIdCity;

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
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

        CityEntity that = (CityEntity) o;

        if (idCity != that.idCity) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCity;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<MunicipalitiesEntity> getMunicipalitiesByIdCity() {
        return municipalitiesByIdCity;
    }

    public void setMunicipalitiesByIdCity(Collection<MunicipalitiesEntity> municipalitiesByIdCity) {
        this.municipalitiesByIdCity = municipalitiesByIdCity;
    }
}
