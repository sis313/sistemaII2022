package com.example.mslogin.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "type_business", schema = "service_maps", catalog = "")
public class TypeBusinessEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_type_business", nullable = false)
    private int idTypeBusiness;
    @Basic
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    public int getIdTypeBusiness() {
        return idTypeBusiness;
    }

    public void setIdTypeBusiness(int idTypeBusiness) {
        this.idTypeBusiness = idTypeBusiness;
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
        TypeBusinessEntity that = (TypeBusinessEntity) o;
        return idTypeBusiness == that.idTypeBusiness && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idTypeBusiness, name);
    }
}
