package com.project.movie.entity;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Table(name = "REVIEW")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
    private Long review_id; //pk
    private double gpa; //평점
    private String review_post; //후기
    private boolean like_num; //좋아요

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESERVE_ID")
    private Reserve reserve_id;

}