package com.project.movie.repository;

import com.project.movie.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByLoginidAndPassword(String loginid, String password);
}
