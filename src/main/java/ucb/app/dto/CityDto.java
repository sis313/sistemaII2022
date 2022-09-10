package ucb.app.dto;

public class CityDto {
    private Integer id_city;
    private int name;

    public CityDto(Integer id_city, int name) {
        this.id_city = id_city;
        this.name = name;
    }

    public Integer getId_city() {
        return id_city;
    }

    public void setId_city(Integer id_city) {
        this.id_city = id_city;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CityDto [id_city=" + id_city + ", name=" + name + "]";
    }

}
