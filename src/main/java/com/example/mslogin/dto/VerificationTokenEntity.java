package com.example.mslogin.dto;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

@javax.persistence.Entity
@javax.persistence.Table(name = "verification_token", schema = "service_maps", catalog = "")
public class VerificationTokenEntity {
    private static final int EXPIRATION = 60 * 24;
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id
    @javax.persistence.Column(name = "id_verification_token")
    private int idVerificationToken;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "token")
    private String token;
    @Temporal(TemporalType.TIMESTAMP)
    @javax.persistence.Basic
    @javax.persistence.Column(name = "created_date")
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    @javax.persistence.Basic
    @javax.persistence.Column(name = "expiry_date")
    private Date expiryDate;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "id_user")
    private int idUser;

    public VerificationTokenEntity() {
    }
    public VerificationTokenEntity(int idUser) {
        this.token = UUID.randomUUID().toString();
        this.idUser = idUser;
        this.createdDate = new Date();
        this.expiryDate = calculateExpiryDate(EXPIRATION);
    }

    public int getIdVerificationToken() {
        return idVerificationToken;
    }

    public void setIdVerificationToken(int idVerificationToken) {
        this.idVerificationToken = idVerificationToken;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
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
        VerificationTokenEntity that = (VerificationTokenEntity) o;
        return idVerificationToken == that.idVerificationToken && idUser == that.idUser && Objects.equals(token, that.token) && Objects.equals(createdDate, that.createdDate) && Objects.equals(expiryDate, that.expiryDate);
    }

    @Override
    public int hashCode() {

        return Objects.hash(idVerificationToken, token, createdDate, expiryDate, idUser);
    }

    private Date calculateExpiryDate(final int expiryTimeInMinutes) {
        final Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(new Date().getTime());
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }
}
