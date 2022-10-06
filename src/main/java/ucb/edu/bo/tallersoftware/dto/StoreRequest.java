package ucb.edu.bo.tallersoftware.dto;

import java.util.List;

public class StoreRequest {
    private String name;
    private Long numberBusiness;
    private Integer idZone;

    public StoreRequest(String name, Long numberBusiness, Integer idZone) {
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

    public Long getNumberBusiness() {
        return numberBusiness;
    }

    public void setNumberBusiness(Long numberBusiness) {
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
        return "StoreRequest{" +
                "name='" + name + '\'' +
                ", id_zone=" + numberBusiness +
                '}';
    }
}
