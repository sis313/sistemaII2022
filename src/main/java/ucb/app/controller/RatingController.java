package ucb.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ucb.app.dto.RatingAverageDto;
import ucb.app.dto.RatingDto;
import ucb.app.service.RatingService;

@RestController
@RequestMapping("api/rating")
public class RatingController {
    private RatingService ratingService;

    @Autowired
    public RatingController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @GetMapping
    public ResponseEntity<List<RatingDto>> getRatings() {
        List<RatingDto> ratings = ratingService.findAllDto();
        return new ResponseEntity<>(ratings, HttpStatus.OK);
    }

    @GetMapping(path = "/{ratingId}")
    public ResponseEntity<RatingDto> getRatingById(@PathVariable("ratingId") Integer ratingId) throws Exception {
        RatingDto rating = ratingService.findByIdDto(ratingId);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    @GetMapping(path = "/")
    public ResponseEntity<RatingAverageDto> getRatingByBranchId(@RequestParam("branchId") Integer branchId) {
        RatingAverageDto rating = ratingService.findByBranchIdDto(branchId);
        return new ResponseEntity<>(rating, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<RatingDto> postRating(@RequestBody RatingDto ratingDto) {
        RatingDto response = ratingService.saveDto(ratingDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping(path = "/{ratingId}")
    public ResponseEntity<RatingDto> putRating(@PathVariable("ratingId") Integer ratingId,
            @RequestBody RatingDto ratingDto) {
        RatingDto response = ratingService.updateDto(ratingId, ratingDto);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "/{ratingId}")
    public ResponseEntity<String> deleteRating(@PathVariable("ratingId") Integer ratingId) {
        String response = ratingService.deleteByIdDto(ratingId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
