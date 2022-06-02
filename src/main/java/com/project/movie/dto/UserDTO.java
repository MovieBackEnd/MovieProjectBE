package com.project.movie.dto;


import com.project.movie.entity.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String name;
    private String login_id;
    private String password;
    private boolean isAdmin;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.login_id = user.getLogin_id();
        this.password = user.getPassword();
        this.isAdmin = user.isAdmin();
    }

    public User toEntity(){
        return new User(id,name,login_id,password,isAdmin);
    }
}
