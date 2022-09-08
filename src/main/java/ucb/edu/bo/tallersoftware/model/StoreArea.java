package ucb.edu.bo.tallersoftware.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table (name = "business",schema = "Taller", catalog = "")

public class StoreArea {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_business")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof StoreArea)) {
            return false;
        }
        StoreArea storeArea = (StoreArea) o;
        return id == storeArea.id && Objects.equals(name, storeArea.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
