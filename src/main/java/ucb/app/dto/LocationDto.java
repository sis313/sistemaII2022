package ucb.app.dto;

import java.math.BigDecimal;

public class LocationDto {
    private Integer idLocation;
    private BigDecimal latitude;
    private BigDecimal longitude;

    public LocationDto(Integer idLocation, BigDecimal latitude, BigDecimal longitude) {
        this.idLocation = idLocation;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getIdLocation() {
        return idLocation;
    }

    public void setIdLocation(Integer idLocation) {
        this.idLocation = idLocation;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "LocationDto [idLocation=" + idLocation + ", latitude=" + latitude + ", longitude=" + longitude + "]";
    }
}
