package ucb.app.dto;

public class BranchRatingCountDto {
    private Integer idBranch;
    private Double averageScore;
    private Integer countIdRating;

    public BranchRatingCountDto(Integer idBranch, Double averageScore, Integer countIdRating) {
        this.idBranch = idBranch;
        this.averageScore = averageScore;
        this.countIdRating = countIdRating;
    }

    public Integer getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    public Double getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Double averageScore) {
        this.averageScore = averageScore;
    }

    public Integer getCountIdRating() {
        return countIdRating;
    }

    public void setCountIdRating(Integer countIdRating) {
        this.countIdRating = countIdRating;
    }

    @Override
    public String toString() {
        return "BranchRatingCountDto [idBranch=" + idBranch + ", averageScore=" + averageScore + ", countIdRating="
                + countIdRating + "]";
    }
}
