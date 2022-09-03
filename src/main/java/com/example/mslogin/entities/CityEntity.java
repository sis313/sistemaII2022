package com.example.mslogin.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "city", schema = "service_maps", catalog = "")
public class CityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_city", nullable = false)
    private int idCity;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
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
