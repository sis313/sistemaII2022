package ucb.app.model.loginModel;

import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "type_user", schema = "service_maps", catalog = "")
public class TypeUserEntity {
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id
    @javax.persistence.Column(name = "id_type_user")
    private int idTypeUser;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "name")
    private String name;

    public int getIdTypeUser() {
        return idTypeUser;
    }

    public void setIdTypeUser(int idTypeUser) {
        this.idTypeUser = idTypeUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        TypeUserEntity that = (TypeUserEntity) o;
        return idTypeUser == that.idTypeUser && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTypeUser, name);
    }
}
