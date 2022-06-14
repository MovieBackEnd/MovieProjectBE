package com.project.movie.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private Long user_id;
    private String name;
    private String loginid;
    private String password;
    private Integer age;
    private boolean isAdmin;
    private boolean isSuccess = false;
}
