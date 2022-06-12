package com.project.movie.repository;

import com.project.movie.entity.Reserve;
import com.project.movie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReserveRepository extends JpaRepository<Reserve, Long> {
    List<Reserve> findByUserIdOrderByReserveDateAsc(User user);
}