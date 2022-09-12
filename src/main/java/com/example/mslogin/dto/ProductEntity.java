package com.example.mslogin.dto;

import java.math.BigDecimal;
import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "product", schema = "service_maps", catalog = "")
public class ProductEntity {
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id
    @javax.persistence.Column(name = "id_product")
    private int idProduct;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "name")
    private String name;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "description")
    private String description;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "stock")
    private int stock;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "price")
    private BigDecimal price;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "discount")
    private BigDecimal discount;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "id_business")
    private int idBusiness;

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public int getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(int idBusiness) {
        this.idBusiness = idBusiness;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductEntity that = (ProductEntity) o;
        return idProduct == that.idProduct && stock == that.stock && idBusiness == that.idBusiness && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(price, that.price) && Objects.equals(discount, that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idProduct, name, description, stock, price, discount, idBusiness);
    }
}
