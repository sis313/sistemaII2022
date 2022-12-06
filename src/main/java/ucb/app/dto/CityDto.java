package ucb.app.dto;

public class CityDto {
    private Integer idCity;
    private String name;

    public CityDto(Integer idCity, String name) {
        this.idCity = idCity;
        this.name = name;
    }

    public Integer getIdCity() {
        return idCity;
    }

    public void setIdCity(Integer idCity) {
        this.idCity = idCity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CityDto [idCity=" + idCity + ", name=" + name + "]";
    }
}
