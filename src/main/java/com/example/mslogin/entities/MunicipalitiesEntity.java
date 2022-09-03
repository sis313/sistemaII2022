package com.example.mslogin.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "municipalities", schema = "service_maps", catalog = "")
public class MunicipalitiesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_municipalities", nullable = false)
    private int idMunicipalities;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "id_city", nullable = false)
    private int idCity;

    public int getIdMunicipalities() {
        return idMunicipalities;
    }

    public void setIdMunicipalities(int idMunicipalities) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MunicipalitiesEntity that = (MunicipalitiesEntity) o;
        return idMunicipalities == that.idMunicipalities && idCity == that.idCity && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idMunicipalities, name, idCity);
    }
}
