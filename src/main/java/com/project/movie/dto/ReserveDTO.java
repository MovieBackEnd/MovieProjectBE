package com.project.movie.dto;

import com.project.movie.entity.Reserve;
import com.project.movie.entity.Screen;
import com.project.movie.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReserveDTO {
    private Long reserve_id; //pk
    private LocalDateTime reserve_date; //예매날짜
    private User user;
    private Screen screen;

    public ReserveDTO(Reserve reserve) {
        this.reserve_id = reserve.getReserve_id();
        this.reserve_date = reserve.getReserve_date();
        this.user = reserve.getUser_id();
        this.screen = reserve.getScreen_id();
    }

    public Reserve toEntity() {
        return new Reserve(reserve_id, reserve_date, user, screen, null);
    }
}