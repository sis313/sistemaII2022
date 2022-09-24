package ucb.app.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ucb.app.dto.RatingDto;
import ucb.app.model.Rating;
import ucb.app.repository.RatingRepository;

@Service
public class RatingService {
    private RatingRepository ratingRepository;

    @Autowired
    public RatingService(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    public List<RatingDto> findAllDto() {
        return ratingRepository.findAll().stream().map(this::ratingToRatingDto).collect(Collectors.toList());
    }

    public RatingDto findByIdDto(Integer ratingId) throws Exception {
        return ratingRepository.findById(ratingId).stream().map(this::ratingToRatingDto).findFirst()
                .orElseThrow(() -> new Exception("Could not find rating"));
    }

    public RatingDto saveDto(Rating rating) {
        Rating response = ratingRepository.save(rating);
        return ratingToRatingDto(response);
    }

    public RatingDto updateDto(Integer ratingId, Rating rating) {
        Rating ratingFound = ratingRepository.getReferenceById(ratingId);
        ratingFound.setScore(rating.getScore());
        ratingFound.setFavoriteStatus(rating.getFavoriteStatus());
        ratingFound.setIdBranch(rating.getIdBranch());
        ratingFound.setIdUser(rating.getIdUser());
        Rating response = ratingRepository.save(ratingFound);
        return ratingToRatingDto(response);
    }

    public String deleteByIdDto(Integer ratingId) {
        ratingRepository.deleteById(ratingId);
        return "Rating deleted successfully";
    }

    private RatingDto ratingToRatingDto(Rating rating) {
        RatingDto ratingDto = new RatingDto(rating.getIdRating(), rating.getScore(), rating.getFavoriteStatus(),
                rating.getIdBranch(), rating.getIdUser());
        return ratingDto;
    }
}
