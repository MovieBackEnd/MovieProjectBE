package com.project.movie.repository;

import com.project.movie.entity.Screen;
import com.project.movie.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    List<Seat> findByScreenIdAndIsReserve(Screen screen, boolean isReserve);
}