package com.project.movie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Table(name = "RESERVE")
public class Reserve {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVE_ID")
    private Long reserve_id; //pk

    private LocalDateTime reserveDate; //예매날짜

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    private  User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SCREEN_ID")
    private Screen screen_id;

    private Integer price;

    @JsonIgnore
    @OneToMany(mappedBy = "review_id")
    List<Review> review = new ArrayList<>();

}