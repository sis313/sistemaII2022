package com.example.mslogin.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "type_user", schema = "service_maps", catalog = "")
public class TypeUserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_type_user", nullable = false)
    private int idTypeUser;
    @Basic
    @Column(name = "name", nullable = false, length = 25)
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypeUserEntity that = (TypeUserEntity) o;
        return idTypeUser == that.idTypeUser && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTypeUser, name);
    }
}
