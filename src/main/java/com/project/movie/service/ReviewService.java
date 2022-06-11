package com.project.movie.service;

import com.project.movie.dto.ReviewDTO;
import com.project.movie.dto.ReviewForm;
import com.project.movie.entity.Reserve;
import com.project.movie.entity.Review;
import com.project.movie.repository.ReserveRepository;
import com.project.movie.repository.ReviewRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReserveRepository reserveRepository;

    @Transactional
    public ReviewDTO join(ReviewForm reviewForm) {
        Reserve reserve = reserveRepository.findById(reviewForm.getReserve_id()).get();

        Review review = new Review();
        review.setReview_id(reviewForm.getReview_id());
        review.setGpa(reviewForm.getGpa());
        review.setReview_post(reviewForm.getReview_post());
        review.setLike_num(reviewForm.isLike_num());
        review.setReserve_id(reserve);

        ReviewDTO saveReview = new ReviewDTO(reviewRepository.save(review));
        return saveReview;
    }

    @Transactional
    public ReviewDTO updateReview(Long review_id, ReviewForm reviewForm) {
        Review findReview = reviewRepository.findById(review_id).get();

        Reserve reserve = reserveRepository.findById(reviewForm.getReserve_id()).get();

        if (findReview != null) {
            findReview.setReview_id(review_id);
            findReview.setGpa(reviewForm.getGpa());
            findReview.setReview_post(reviewForm.getReview_post());
            findReview.setLike_num(reviewForm.isLike_num());
            findReview.setReserve_id(reserve);
        }

        ReviewDTO updateReview = new ReviewDTO(reviewRepository.save(findReview));
        return updateReview;
    }

    @Transactional
    public void deleteReview(Long review_id) {
        reviewRepository.deleteById(review_id);
    }

    public List<ReviewDTO> findAllReview() {
        List<Review> reviews = reviewRepository.findAll();
        List<ReviewDTO> ReviewDTOList = reviews.stream().map(review -> {
            return new ReviewDTO(review);
        }).collect(Collectors.toList());
        return ReviewDTOList;
    }

}