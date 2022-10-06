package ucb.app.dto;

public class TypeBusinessDto {
    private Integer idTypeBusiness;
    private String name;

    public TypeBusinessDto(Integer idTypeBusiness, String name) {
        this.idTypeBusiness = idTypeBusiness;
        this.name = name;
    }

    public Integer getIdTypeBusiness() {
        return idTypeBusiness;
    }

    public void setIdTypeBusiness(Integer idTypeBusiness) {
        this.idTypeBusiness = idTypeBusiness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TypeBusinessDto [idTypeBusiness=" + idTypeBusiness + ", name=" + name + "]";
    }
}
