package com.example.mslogin.dto;

import java.util.Objects;

@javax.persistence.Entity
@javax.persistence.Table(name = "rating", schema = "service_maps", catalog = "")
public class RatingEntity {
    @javax.persistence.GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
    @javax.persistence.Id
    @javax.persistence.Column(name = "id_rating")
    private int idRating;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "score")
    private int score;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "favorite_status")
    private byte favoriteStatus;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "id_branch")
    private int idBranch;
    @javax.persistence.Basic
    @javax.persistence.Column(name = "id_user")
    private int idUser;

    public int getIdRating() {
        return idRating;
    }

    public void setIdRating(int idRating) {
        this.idRating = idRating;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public byte getFavoriteStatus() {
        return favoriteStatus;
    }

    public void setFavoriteStatus(byte favoriteStatus) {
        this.favoriteStatus = favoriteStatus;
    }

    public int getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(int idBranch) {
        this.idBranch = idBranch;
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
        RatingEntity that = (RatingEntity) o;
        return idRating == that.idRating && score == that.score && favoriteStatus == that.favoriteStatus && idBranch == that.idBranch && idUser == that.idUser;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idRating, score, favoriteStatus, idBranch, idUser);
    }
}
