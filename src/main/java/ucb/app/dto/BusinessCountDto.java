package ucb.app.dto;

public class BusinessCountDto {
    private String name;
    private Integer numberBusiness;
    private Integer idZone;

    public BusinessCountDto(String name, Integer numberBusiness, Integer idZone) {
        this.name = name;
        this.numberBusiness = numberBusiness;
        this.idZone = idZone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberBusiness() {
        return numberBusiness;
    }

    public void setNumberBusiness(Integer numberBusiness) {
        this.numberBusiness = numberBusiness;
    }

    public Integer getIdZone() {
        return idZone;
    }

    public void setIdZone(Integer idZone) {
        this.idZone = idZone;
    }

    @Override
    public String toString() {
        return "BusinessCountDto [name=" + name + ", numberBusiness=" + numberBusiness + ", idZone=" + idZone + "]";
    }
}
