package com.project.movie.dto;

import com.project.movie.entity.User;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LoginDTO {
    @NotNull
    private String login_id;
    @NotNull
    private String password;


    public LoginDTO(User user) {
        this.login_id = user.getLoginid();
        this.password = user.getPassword();
    }

}