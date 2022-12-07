package ucb.app.dto;

public class RatingDetailDto {
    private Integer idRating;
    private int score;
    private boolean favoriteStatus;
    private int idBranch;
    private String businessName;
    private int idUser;

    public RatingDetailDto(Integer idRating, int score, boolean favoriteStatus, int idBranch, String businessName,
            int idUser) {
        this.idRating = idRating;
        this.score = score;
        this.favoriteStatus = favoriteStatus;
        this.idBranch = idBranch;
        this.businessName = businessName;
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

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return "RatingDetailDto [idRating=" + idRating + ", score=" + score + ", favoriteStatus=" + favoriteStatus
                + ", idBranch=" + idBranch + ", businessName=" + businessName + ", idUser=" + idUser + "]";
    }
}
