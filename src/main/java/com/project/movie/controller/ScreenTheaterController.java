package com.project.movie.controller;

import com.project.movie.dto.ScreenTheaterDTO;
import com.project.movie.dto.ScreenTheaterForm;
import com.project.movie.service.ScreenTheaterService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/screenTheater")
public class ScreenTheaterController {

    private final ScreenTheaterService screenTheaterService;

    @ApiOperation(value = "상영관 생성", notes = "상영관 정보를 입력받아 상영관을 생성후, DB에 저장한다..")
    @PostMapping("/create")
    public ResponseEntity<ScreenTheaterDTO> createScreenTheater(@RequestBody ScreenTheaterForm screenTheaterForm){
        ScreenTheaterDTO save = screenTheaterService.createScreenTheater(screenTheaterForm);
        return ResponseEntity.ok().body(save);
    }

    @ApiOperation(value = "상영관 수정", notes = "상영관id(PK)를 입력받아 상영관 정보를 수정한다.")
    @PutMapping("/{screenTheater_id}")
    public ResponseEntity<ScreenTheaterDTO> updateScreenTheater(@PathVariable Long screenTheater_id, @RequestBody ScreenTheaterForm screenTheaterForm){
        ScreenTheaterDTO updateScreenTheater = screenTheaterService.updateScreenTheater(screenTheater_id, screenTheaterForm);
        return ResponseEntity.ok().body(updateScreenTheater);
    }

    @ApiOperation(value = "상영관 삭제", notes = "상영관id(PK)를 입력받아 상영관 정보를 삭제한다.")
    @DeleteMapping("/{screenTheater_id}")
    public void deleteScreenTheater(@PathVariable Long screenTheater_id){
        screenTheaterService.deleteScreenTheater(screenTheater_id);
    }


}
