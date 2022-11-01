package ucb.app.dto;

public class BranchRatingCountDto {
    private Integer idBusiness;
    private String name;
    private Integer idBranch;
    private String address;
    private Double averageScore;
    private Integer countIdRating;

    public BranchRatingCountDto(Integer idBusiness, String name, Integer idBranch, String address, Double averageScore,
            Integer countIdRating) {
        this.idBusiness = idBusiness;
        this.name = name;
        this.idBranch = idBranch;
        this.address = address;
        this.averageScore = averageScore;
        this.countIdRating = countIdRating;
    }

    public Integer getIdBusiness() {
        return idBusiness;
    }

    public void setIdBusiness(Integer idBusiness) {
        this.idBusiness = idBusiness;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIdBranch() {
        return idBranch;
    }

    public void setIdBranch(Integer idBranch) {
        this.idBranch = idBranch;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return "BranchRatingCountDto [idBusiness=" + idBusiness + ", name=" + name + ", idBranch=" + idBranch
                + ", address=" + address + ", averageScore=" + averageScore + ", countIdRating=" + countIdRating + "]";
    }
}
