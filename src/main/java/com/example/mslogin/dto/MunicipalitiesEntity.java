package com.example.mslogin.dto;

import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "municipalities", schema = "service_maps", catalog = "")
public class MunicipalitiesEntity {
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id
    @javax.persistence.Column(name = "id_municipalities")
    private int idMunicipalities;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "name")
    private String name;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "id_city")
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
