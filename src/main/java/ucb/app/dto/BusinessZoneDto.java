package ucb.app.dto;

public class BusinessZoneDto {
    private String name;
    private Integer id_business;

    public BusinessZoneDto(String name, Integer id_business) {
        this.name = name;
        this.id_business = id_business;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId_business() {
        return id_business;
    }

    public void setId_business(Integer id_business) {
        this.id_business = id_business;
    }

    @Override
    public String toString() {
        return "BusinessZoneDto [name=" + name + ", id_business=" + id_business + "]";
    }
}
