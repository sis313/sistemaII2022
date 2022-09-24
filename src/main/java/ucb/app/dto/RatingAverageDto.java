package ucb.app.dto;

public class RatingAverageDto {
    private int averageScore;

    public RatingAverageDto(int averageScore) {
        this.averageScore = averageScore;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }

    @Override
    public String toString() {
        return "RatingAverageDto [averageScore=" + averageScore + "]";
    }
}
