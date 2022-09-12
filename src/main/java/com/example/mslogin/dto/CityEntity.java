package com.example.mslogin.dto;

import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "city", schema = "service_maps", catalog = "")
public class CityEntity {
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id
    @javax.persistence.Column(name = "id_city")
    private int idCity;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "name")
    private String name;

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
        return idCity == that.idCity && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCity, name);
    }
}
