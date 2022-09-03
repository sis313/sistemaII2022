package com.example.mslogin.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "product", schema = "service_maps", catalog = "")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_product", nullable = false)
    private int idProduct;
    @Basic
    @Column(name = "name", nullable = false, length = 50)
    private String name;
    @Basic
    @Column(name = "description", nullable = false, length = 150)
    private String description;
    @Basic
    @Column(name = "stock", nullable = false)
    private int stock;
    @Basic
    @Column(name = "price", nullable = false, precision = 2)
    private BigDecimal price;
    @Basic
    @Column(name = "discount", nullable = false, precision = 2)
    private BigDecimal discount;
    @Basic
    @Column(name = "id_business", nullable = false)
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
