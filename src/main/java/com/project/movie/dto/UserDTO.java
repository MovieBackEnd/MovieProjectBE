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
    private Long user_id;
    private String name;
    private String loginid;
    private String password;
    private Integer age;
    private boolean isAdmin;

    public UserDTO(User user) {
        this.user_id = user.getUser_id();
        this.name = user.getName();
        this.loginid = user.getLoginid();
        this.password = user.getPassword();
        this.age = user.getAge();
        this.isAdmin = user.isAdmin();
    }

    public User toEntity() {
        return new User(user_id, name, loginid, password, age, isAdmin,null);
    }
}
