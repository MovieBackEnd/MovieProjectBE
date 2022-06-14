package com.project.movie.controller;

import com.project.movie.dto.LoginDTO;
import com.project.movie.dto.LoginResponseDTO;
import com.project.movie.dto.UserDTO;
import com.project.movie.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "유저 생성", notes = "유저 정보를 입력받아 유저를 생성한다.")
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        UserDTO user = userService.join(userDTO);
        return ResponseEntity.ok().body(user);
    }

    @ApiOperation(value = "유저 정보 수정", notes = "유저 정보(DTO)와 id(PK)를 입력받아 유저 정보를 수정한다.")
    @PutMapping("/{user_id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long user_id, @RequestBody UserDTO userDTO) {
        UserDTO user = userService.updateUser(user_id, userDTO);
        return ResponseEntity.ok().body(user);
    }

    @ApiOperation(value = "유저 삭제", notes = "유저의 id(PK)를 입력받아 유저 정보를 삭제한다.")
    @DeleteMapping("/{user_id}")
    public ResponseEntity deleteUser(@PathVariable Long user_id) {
        userService.deleteUser(user_id);
        return ResponseEntity.ok().body(user_id);
    }

    @ApiOperation(value = "전체 유저 조회", notes = "전체 유저의 수와 각 유저정보를 반환한다.")
    @GetMapping("/all")
    public ResponseEntity<Result<List<UserDTO>>> findAllUser() {
        List<UserDTO> userDTOList = userService.findAllUser();
        return ResponseEntity.ok().body(new Result<>(userDTOList, userDTOList.size()));
    }

    @ApiOperation(value = "유저 로그인 생성", notes = "유저 정보를 입력받아 로그인 정보를 생성한다.")
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@RequestBody LoginDTO loginDTO) {
        LoginResponseDTO l = userService.loginUser(loginDTO);
        return ResponseEntity.ok().body(l);
    }

    @ApiOperation(value = "유저 상세정보 조회", notes = "유저id(PK)를 입력받아 유저를 조회한다.")
    @GetMapping("/{user_id}/detail")
    public ResponseEntity<UserDTO> findByUserID(@PathVariable Long user_id) {
        UserDTO userDTO = userService.findByUserId(user_id);
        return ResponseEntity.ok().body(userDTO);
    }

}
