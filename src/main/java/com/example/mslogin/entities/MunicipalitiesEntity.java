package com.example.mslogin.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "municipalities", schema = "service_maps", catalog = "")
public class MunicipalitiesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_municipalities")
    private int idMunicipalities;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "id_city")
    private int idCity;
    @ManyToOne
    @JoinColumn(name = "id_city", referencedColumnName = "id_city", nullable = false)
    private CityEntity cityByIdCity;
    @OneToMany(mappedBy = "municipalitiesByIdMunicipalities")
    private Collection<ZoneEntity> zonesByIdMunicipalities;

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

        if (idMunicipalities != that.idMunicipalities) return false;
        if (idCity != that.idCity) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idMunicipalities;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + idCity;
        return result;
    }

    public CityEntity getCityByIdCity() {
        return cityByIdCity;
    }

    public void setCityByIdCity(CityEntity cityByIdCity) {
        this.cityByIdCity = cityByIdCity;
    }

    public Collection<ZoneEntity> getZonesByIdMunicipalities() {
        return zonesByIdMunicipalities;
    }

    public void setZonesByIdMunicipalities(Collection<ZoneEntity> zonesByIdMunicipalities) {
        this.zonesByIdMunicipalities = zonesByIdMunicipalities;
    }
}
