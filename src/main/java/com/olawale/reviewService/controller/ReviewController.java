package com.olawale.reviewService.controller;

import com.olawale.reviewService.model.Review;
import com.olawale.reviewService.service.ReviewService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/reviews")
@CrossOrigin(origins = "http://localhost:5173")
public class ReviewController {

    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @PostMapping
    public Review createReview(@RequestBody Review review) {
        return service.createReview(review);
    }

    @GetMapping("/book/{bookId}")
    public List<Review> getReviewsByBookId(@PathVariable String bookId) {
        return service.getReviewsByBookId(bookId);
    }

    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable String id) {
        service.deleteReview(id);
    }
}
