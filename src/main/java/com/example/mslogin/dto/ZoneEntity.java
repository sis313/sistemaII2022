package com.example.mslogin.dto;

import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "zone", schema = "service_maps", catalog = "")
public class ZoneEntity {
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id
    @javax.persistence.Column(name = "id_zone")
    private int idZone;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "name")
    private String name;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "id_municipalities")
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
