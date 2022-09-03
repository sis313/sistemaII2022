package com.example.mslogin.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "zone", schema = "service_maps", catalog = "")
public class ZoneEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_zone", nullable = false)
    private int idZone;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;
    @Basic
    @Column(name = "id_municipalities", nullable = false)
    private int idMunicipalities;

    public int getIdZone() {
        return idZone;
    }

    public void setIdZone(int idZone) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ZoneEntity that = (ZoneEntity) o;
        return idZone == that.idZone && idMunicipalities == that.idMunicipalities && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idZone, name, idMunicipalities);
    }
}
