package ucb.edu.bo.tallersoftware.dto;

public class StoreRequest {
    private String name;
    private Long numberBusiness;

        public StoreRequest(String name, Long numberBusiness) {
        this.name = name;
        this.numberBusiness = numberBusiness;
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

    @Override
    public String toString() {
        return "StoreRequest{" +
                "name='" + name + '\'' +
                ", id_zone=" + numberBusiness +
                '}';
    }
}
