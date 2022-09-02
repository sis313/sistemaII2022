package com.example.mslogin.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "zone", schema = "service_maps", catalog = "")
public class ZoneEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_zone")
    private int idZone;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "id_municipalities")
    private int idMunicipalities;
    @OneToMany(mappedBy = "zoneByIdZone")
    private Collection<BranchEntity> branchesByIdZone;
    @ManyToOne
    @JoinColumn(name = "id_municipalities", referencedColumnName = "id_municipalities", nullable = false)
    private MunicipalitiesEntity municipalitiesByIdMunicipalities;

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

        if (idZone != that.idZone) return false;
        if (idMunicipalities != that.idMunicipalities) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idZone;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + idMunicipalities;
        return result;
    }

    public Collection<BranchEntity> getBranchesByIdZone() {
        return branchesByIdZone;
    }

    public void setBranchesByIdZone(Collection<BranchEntity> branchesByIdZone) {
        this.branchesByIdZone = branchesByIdZone;
    }

    public MunicipalitiesEntity getMunicipalitiesByIdMunicipalities() {
        return municipalitiesByIdMunicipalities;
    }

    public void setMunicipalitiesByIdMunicipalities(MunicipalitiesEntity municipalitiesByIdMunicipalities) {
        this.municipalitiesByIdMunicipalities = municipalitiesByIdMunicipalities;
    }
}
