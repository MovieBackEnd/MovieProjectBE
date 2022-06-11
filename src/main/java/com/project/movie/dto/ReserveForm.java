package com.project.movie.dto;

import com.project.movie.entity.Reserve;
import com.sun.istack.NotNull;
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
public class ReserveForm {
    private Long reserve_id;
    @NotNull
    private Long user_id;
    @NotNull
    private Long screen_id;
    @NotNull
    private Integer[] seat_arr;

//    public ReserveForm(Reserve reserve) {
//        this.reserve_id = reserve.getReserve_id();
//        this.user_id = reserve.getReserve_id();
//        this.screen_id = reserve.getScreen_id().getScreen_id();
//        this.reserve_date = reserve.getReserve_date();
//    }
//
//    public Reserve toEntity() {
//        return new Reserve(reserve_id, reserve_date, user_id, null, null);
//    }
}