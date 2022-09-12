package ucb.app.dto;

public class LocationDto {
    private Integer idLocation;
    private float latitude;
    private float longitude;

    public LocationDto(Integer idLocation, float latitude, float longitude) {
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

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "LocationDto [idLocation=" + idLocation + ", latitude=" + latitude + ", longitude=" + longitude + "]";
    }
}
