package ucb.app.dto;

public class RatingDto {
    private Integer idRating;
    private int score;
    private boolean favoriteStatus;
    private int idBranch;
    private int idUser;

    public RatingDto(Integer idRating, int score, boolean favoriteStatus, int idBranch, int idUser) {
        this.idRating = idRating;
        this.score = score;
        this.favoriteStatus = favoriteStatus;
        this.idBranch = idBranch;
        this.idUser = idUser;
    }

    public Integer getIdRating() {
        return idRating;
    }

    public void setIdRating(Integer idRating) {
        this.idRating = idRating;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isFavoriteStatus() {
        return favoriteStatus;
    }

    public void setFavoriteStatus(boolean favoriteStatus) {
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
    public String toString() {
        return "RatingDto [favoriteStatus=" + favoriteStatus + ", idBranch=" + idBranch + ", idRating=" + idRating
                + ", idUser=" + idUser + ", score=" + score + "]";
    }
}
