package com.project.movie.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.movie.dto.ScreenDTO;
import com.project.movie.dto.ScreenForm;
import com.project.movie.entity.Screen;
import com.project.movie.service.ScreenService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/screen")
public class ScreenController {

    private final ScreenService screenService;

    @ApiOperation(value = "상영 시간표 생성", notes = "상영 시간 정보를 입력받아 상영시간표를 생성후, DB에 저장한다..")
    @PostMapping("/create")
    public ResponseEntity<ScreenDTO> createScreen(@RequestBody ScreenForm screenForm){
        ScreenDTO save = screenService.createScreen(screenForm);
        return ResponseEntity.ok().body(save);
    }

    @ApiOperation(value = "상영 시간표 수정", notes = "상영 시간id(PK)를 입력받아 상영시간표를 수정한다.")
    @PutMapping("/{screen_id}")
    public ResponseEntity<ScreenDTO> updateScreen(@PathVariable Long screen_id, @RequestBody ScreenForm screenForm){
        ScreenDTO updateScreen = screenService.updateScreen(screen_id, screenForm);
        return ResponseEntity.ok().body(updateScreen);
    }

    @ApiOperation(value = "상영 시간표 삭제", notes = "상영 시간id(PK)를 입력받아 상영시간표를 삭제한다.")
    @DeleteMapping("/{screen_id}")
    public void updateScreen(@PathVariable Long screen_id){
        screenService.deleteScreen(screen_id);
    }

    @ApiOperation(value = "영화별 상영시간표 조회", notes = "영화별 상영시간표를 조회한다..")
    @GetMapping("/movie/{movie_id}")
    public ResponseEntity<Result<List<ScreenDTO>>> findByMovie(@PathVariable Long movie_id){
        List<ScreenDTO> screenDTOList = screenService.findByMovieId(movie_id);
        return ResponseEntity.ok().body(new Result<>(screenDTOList,screenDTOList.size()));
    }
}
