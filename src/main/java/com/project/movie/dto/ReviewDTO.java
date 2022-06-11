package com.project.movie.dto;


import com.project.movie.entity.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
    private Long review_id; //pk
    private Double gpa; //평점
    private String review_post; //후기
    private boolean isLike_num; //좋아요

    public ReviewDTO(Review review) {
        this.review_id = review.getReview_id();
        this.gpa = review.getGpa();
        this.review_post = review.getReview_post();
        this.isLike_num = review.isLike_num();
    }

    public Review toEntity() {
        return new Review(review_id, gpa, review_post, isLike_num, null);
    }
}