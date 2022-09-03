package com.example.mslogin.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.Objects;

@Entity
@Table(name = "booking", schema = "service_maps", catalog = "")
public class BookingEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_booking", nullable = false)
    private int idBooking;
    @Basic
    @Column(name = "date", nullable = false)
    private Date date;
    @Basic
    @Column(name = "time", nullable = false)
    private Time time;
    @Basic
    @Column(name = "amount", nullable = false, precision = 2)
    private BigDecimal amount;
    @Basic
    @Column(name = "id_product", nullable = false)
    private int idProduct;
    @Basic
    @Column(name = "id_user", nullable = false)
    private int idUser;

    public int getIdBooking() {
        return idBooking;
    }

    public void setIdBooking(int idBooking) {
        this.idBooking = idBooking;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingEntity that = (BookingEntity) o;
        return idBooking == that.idBooking && idProduct == that.idProduct && idUser == that.idUser && Objects.equals(date, that.date) && Objects.equals(time, that.time) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBooking, date, time, amount, idProduct, idUser);
    }
}
