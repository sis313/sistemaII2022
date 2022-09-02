package ucb.edu.bo.tallersoftware.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "type_user", schema = "project", catalog = "")
public class TypeUser {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_type_user")
    private int id;
    @Basic
    @Column(name = "name")
    private String name;


    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TypeUser)) {
            return false;
        }
        TypeUser typeUser = (TypeUser) o;
        return id == typeUser.id && Objects.equals(name, typeUser.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

}
