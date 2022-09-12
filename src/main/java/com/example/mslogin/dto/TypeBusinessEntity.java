package com.example.mslogin.dto;

import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "type_business", schema = "service_maps", catalog = "")
public class TypeBusinessEntity {
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id
    @javax.persistence.Column(name = "id_type_business")
    private int idTypeBusiness;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "name")
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
