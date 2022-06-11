package com.project.movie.controller;

import com.project.movie.dto.TheaterDTO;
import com.project.movie.service.TheaterService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/theater")
public class TheaterController {

    private final TheaterService theaterService;

    @ApiOperation(value = "극장 생성", notes = "극장 정보를 입력받아 극장을 생성한다.")
    @PostMapping("/create")
    public ResponseEntity<TheaterDTO> createTheater(@RequestBody TheaterDTO theaterDTO) {
        TheaterDTO theater = theaterService.join(theaterDTO);
        return ResponseEntity.ok().body(theater);
    }

    @ApiOperation(value = "극장 정보 수정", notes = "극장 정보(DTO)와 id(PK)를 입력받아 극장 정보를 수정한다.")
    @PutMapping("/{theater_id}")
    public ResponseEntity<TheaterDTO> updateTheater(@PathVariable Long theater_id, @RequestBody TheaterDTO theaterDTO) {
        TheaterDTO theater = theaterService.updateTheater(theater_id, theaterDTO);
        return ResponseEntity.ok().body(theater);
    }

    @ApiOperation(value = "극장 삭제", notes = "극장의 id(PK)를 입력받아 극장 정보를 삭제한다.")
    @DeleteMapping("/{theater_id}")
    public ResponseEntity deleteTheater(@PathVariable Long theater_id) {
        theaterService.deleteTheater(theater_id);
        return ResponseEntity.ok().body(theater_id);
    }

    @ApiOperation(value = "전체 극장 조회", notes = "전체 극장 정보를 반환한다.")
    @GetMapping("/all")
    public ResponseEntity<Result<List<TheaterDTO>>> findAllTheater() {
        List<TheaterDTO> theaterDTOList = theaterService.findAllTheater();
        return ResponseEntity.ok().body(new Result<>(theaterDTOList, theaterDTOList.size()));
    }
}