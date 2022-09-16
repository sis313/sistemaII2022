package ucb.app.dto;

public class MunicipalitiesDto {
    private Integer idMunicipalities;
    private String name;
    private int idCity;

    public MunicipalitiesDto(Integer idMunicipalities, String name, int idCity) {
        this.idMunicipalities = idMunicipalities;
        this.name = name;
        this.idCity = idCity;
    }

    public Integer getIdMunicipalities() {
        return idMunicipalities;
    }

    public void setIdMunicipalities(Integer idMunicipalities) {
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
    public String toString() {
        return "MunicipalitiesDto [idCity=" + idCity + ", idMunicipalities=" + idMunicipalities + ", name=" + name
                + "]";
    }
}
