package com.project.movie.controller;

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

    @ApiOperation(value = "전체 유저 조회", notes = "전체 유저의 수와 각 유저정보를 반환한다.")
    @GetMapping("/all")
    public ResponseEntity<Result<List<UserDTO>>> findAllUser() {
        List<UserDTO> userDTOList = userService.findAllUser();
        return ResponseEntity.ok().body(new Result<>(userDTOList, userDTOList.size()));
    }
}
