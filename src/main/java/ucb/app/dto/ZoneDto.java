package ucb.app.dto;

public class ZoneDto {
    private Integer idZone;
    private String name;
    private int idMunicipalities;

    public ZoneDto(Integer idZone, String name, int idMunicipalities) {
        this.idZone = idZone;
        this.name = name;
        this.idMunicipalities = idMunicipalities;
    }

    public Integer getIdZone() {
        return idZone;
    }

    public void setIdZone(Integer idZone) {
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
    public String toString() {
        return "ZoneDto [idMunicipalities=" + idMunicipalities + ", idZone=" + idZone + ", name=" + name + "]";
    }
}
