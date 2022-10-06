package ucb.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ucb.app.model.Rating;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
    public Integer findAverageByIdBranch(Integer idBranch);
}
