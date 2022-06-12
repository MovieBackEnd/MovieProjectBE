package com.project.movie.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Table(name = "USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long user_id; //pk
    private String name; //user 이름
    private String loginid; //login ID
    private String password; //pw
    private Integer age; //나이
    private boolean isAdmin; //관리자 구분

    @JsonIgnore
    @OneToMany(mappedBy = "userId") //mappedBy 값은 대상이 되는 변수명을 따라 지정
    List<Reserve> reserve = new ArrayList<>();

}
