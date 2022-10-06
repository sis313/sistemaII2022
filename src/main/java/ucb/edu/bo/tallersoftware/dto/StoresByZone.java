package ucb.edu.bo.tallersoftware.dto;

public class StoresByZone {

    private String name;
    private Integer id_business;

    public StoresByZone(String name, Integer id_business) {
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

}
