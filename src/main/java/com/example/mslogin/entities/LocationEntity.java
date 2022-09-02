package com.example.mslogin.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "location", schema = "service_maps", catalog = "")
public class LocationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_location")
    private int idLocation;
    @Basic
    @Column(name = "latitude")
    private double latitude;
    @Basic
    @Column(name = "longitude")
    private double longitude;
    @OneToMany(mappedBy = "locationByIdLocation")
    private Collection<BranchEntity> branchesByIdLocation;

    public int getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(int idLocation) {
        this.idLocation = idLocation;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationEntity that = (LocationEntity) o;

        if (idLocation != that.idLocation) return false;
        if (Double.compare(that.latitude, latitude) != 0) return false;
        if (Double.compare(that.longitude, longitude) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = idLocation;
        temp = Double.doubleToLongBits(latitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(longitude);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Collection<BranchEntity> getBranchesByIdLocation() {
        return branchesByIdLocation;
    }

    public void setBranchesByIdLocation(Collection<BranchEntity> branchesByIdLocation) {
        this.branchesByIdLocation = branchesByIdLocation;
    }
}
