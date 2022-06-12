package com.project.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReviewForm {
    private Long review_id; //pk
    @Range(min = 0, max = 5)
    private Double gpa; //평점
    private String review_post; //후기
    private boolean isLike_num; //좋아요
    private Long reserve_id;
}
