package com.example.mslogin.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collection;

@Entity
@Table(name = "product", schema = "service_maps", catalog = "")
public class ProductEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_product")
    private int idProduct;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "stock")
    private int stock;
    @Basic
    @Column(name = "price")
    private BigDecimal price;
    @Basic
    @Column(name = "discount")
    private BigDecimal discount;
    @Basic
    @Column(name = "id_business")
    private int idBusiness;
    @OneToMany(mappedBy = "productByIdProduct")
    private Collection<BookingEntity> bookingsByIdProduct;
    @ManyToOne
    @JoinColumn(name = "id_business", referencedColumnName = "id_business", nullable = false)
    private BusinessEntity businessByIdBusiness;

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

        if (idProduct != that.idProduct) return false;
        if (stock != that.stock) return false;
        if (idBusiness != that.idBusiness) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (discount != null ? !discount.equals(that.discount) : that.discount != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idProduct;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + stock;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (discount != null ? discount.hashCode() : 0);
        result = 31 * result + idBusiness;
        return result;
    }

    public Collection<BookingEntity> getBookingsByIdProduct() {
        return bookingsByIdProduct;
    }

    public void setBookingsByIdProduct(Collection<BookingEntity> bookingsByIdProduct) {
        this.bookingsByIdProduct = bookingsByIdProduct;
    }

    public BusinessEntity getBusinessByIdBusiness() {
        return businessByIdBusiness;
    }

    public void setBusinessByIdBusiness(BusinessEntity businessByIdBusiness) {
        this.businessByIdBusiness = businessByIdBusiness;
    }
}
