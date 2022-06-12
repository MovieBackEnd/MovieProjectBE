package com.project.movie.controller;

import com.project.movie.dto.ReviewDTO;
import com.project.movie.dto.ReviewForm;
import com.project.movie.service.ReviewService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService reviewService;

    @ApiOperation(value = "영화후기 생성", notes = "영화후기 정보를 입력받아 리뷰를 생성한다.")
    @PostMapping("/create")
    public ResponseEntity<ReviewDTO> createReview(@Validated @RequestBody ReviewForm reviewForm) {
        ReviewDTO review = reviewService.join(reviewForm);
        return ResponseEntity.ok().body(review);
    }

    @ApiOperation(value = "영화후기 수정", notes = "영화후기(DTO)와 id(PK)를 입력받아 영화리뷰를 수정한다.")
    @PutMapping("/{review_id}")
    public ResponseEntity<ReviewDTO> updateReview(@PathVariable Long review_id,@RequestBody ReviewForm reviewForm) {
        ReviewDTO review = reviewService.updateReview(review_id, reviewForm);
        return ResponseEntity.ok().body(review);
    }

    @ApiOperation(value = "영화후기 삭제", notes = "영화후기 id(PK)를 입력받아 영화리뷰를 삭제한다.")
    @DeleteMapping("/{review_id}")
    public ResponseEntity deleteReview(@PathVariable Long review_id) {
        reviewService.deleteReview(review_id);
        return ResponseEntity.ok().body(review_id);
    }

    @ApiOperation(value = "전체 영화후기 조회", notes = "전체 영화후기 정보를 반환한다.")
    @GetMapping("/all")
    public ResponseEntity<Result<List<ReviewDTO>>> findAllReview() {
        List<ReviewDTO> reviewDTOList = reviewService.findAllReview();
        return ResponseEntity.ok().body(new Result<>(reviewDTOList, reviewDTOList.size()));
    }
}