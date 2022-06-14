package com.project.movie.service;

import com.project.movie.dto.LoginDTO;
import com.project.movie.dto.LoginResponseDTO;
import com.project.movie.dto.UserDTO;
import com.project.movie.entity.User;
import com.project.movie.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserDTO join(UserDTO userDTO) {
        User user = userDTO.toEntity();
        UserDTO saveUser = new UserDTO(userRepository.save(user));
        return saveUser;
    }

    @Transactional
    public UserDTO updateUser(Long user_id, UserDTO userDTO) {
        User findUser = userRepository.findById(user_id).get();
        if (findUser != null) {
            findUser.setUser_id(user_id);
            findUser.setLoginid(userDTO.getLoginid());
            findUser.setPassword(userDTO.getPassword());
            findUser.setAge(userDTO.getAge());
            findUser.setName(userDTO.getName());
            findUser.setAdmin(userDTO.isAdmin());
        }
        UserDTO updateUser = new UserDTO(userRepository.save(findUser));
        return updateUser;
    }

    @Transactional
    public void deleteUser(Long user_id) {
        userRepository.deleteById(user_id);
    }

    public List<UserDTO> findAllUser() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOList = users.stream().map(user -> {
            return new UserDTO(user);
        }).collect(Collectors.toList());
        return userDTOList;
    }

    @Transactional
    public LoginResponseDTO loginUser(LoginDTO loginDTO) {
        List<User> users = userRepository.findByLoginidAndPassword(loginDTO.getLogin_id(), loginDTO.getPassword());
        LoginResponseDTO l = new LoginResponseDTO();
        if(users.size() > 0) {
            User u = users.get(0);
            l.setLoginid(u.getLoginid());
            l.setUser_id(u.getUser_id());
            l.setAge(u.getAge());
            l.setPassword(u.getPassword());
            l.setAdmin(u.isAdmin());
            l.setSuccess(true);
            return l;
        } else {
            return l;
        }
    }

    public UserDTO findByUserId(Long user_id) {
        UserDTO user = new UserDTO(userRepository.findById(user_id).get());
        return user;
    }
}
