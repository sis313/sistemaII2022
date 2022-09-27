package ucb.edu.bo.demo.dto;

import java.util.Date;

public class Date {
    private int id_type_business;
    private String name;

    public Type() { }

    public Type(int id_type_business, String name) {
        this.id_type_business = id_type_business;
        this.name = name;
    }

    public int getId_type_business() {
        return id_type_business;
    }

    public void setId_type_business(int id_type_business) {
        this.id_type_business = id_type_business;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
