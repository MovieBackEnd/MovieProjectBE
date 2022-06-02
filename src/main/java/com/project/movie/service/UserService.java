package com.project.movie.service;

import com.project.movie.dto.UserDTO;
import com.project.movie.entity.User;
import com.project.movie.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserDTO join(UserDTO userDTO) {
        User user = userDTO.toEntity();
        UserDTO saveUser = new UserDTO(userRepository.save(user));
        return saveUser;
    }

    public List<UserDTO> findAllUser() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOList = users.stream().map(user -> {
            return new UserDTO(user);
        }).collect(Collectors.toList());
        return userDTOList;
    }
}
