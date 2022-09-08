package ucb.edu.bo.tallersoftware.dto;

import java.util.Objects;

public class StoreRequest {
    private String name;
    private int id_business;

    public StoreRequest(String name, int id_business) {
        this.name = name;
        this.id_business = id_business;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId_business() {
        return id_business;
    }

    public void setId_business(int id_business) {
        this.id_business = id_business;
    }
    public StoreRequest name(String name){
        setName(name);
        return this;
    }
    public StoreRequest id_business(int id_business){
        setId_business((id_business));
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StoreRequest)) {
            return false;
        }
        StoreRequest storeRequest = (StoreRequest) o;
        return Objects.equals(name, storeRequest.name) && Objects.equals(id_business, storeRequest.id_business);
    }

    @Override
    public String toString() {
        return "StoreRequest{" +
                "name='" + name + '\'' +
                ", id_business=" + id_business +
                '}';
    }
}
