package com.example.mslogin.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "type_user", schema = "service_maps", catalog = "")
public class TypeUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_type_user")
    private int idTypeUser;
    @Basic
    @Column(name = "name")
    private String name;
    @OneToMany(mappedBy = "typeUserByIdTypeUser")
    private Collection<UserEntity> usersByIdTypeUser;

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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TypeUserEntity that = (TypeUserEntity) o;

        if (idTypeUser != that.idTypeUser) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idTypeUser;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    public Collection<UserEntity> getUsersByIdTypeUser() {
        return usersByIdTypeUser;
    }

    public void setUsersByIdTypeUser(Collection<UserEntity> usersByIdTypeUser) {
        this.usersByIdTypeUser = usersByIdTypeUser;
    }
}
