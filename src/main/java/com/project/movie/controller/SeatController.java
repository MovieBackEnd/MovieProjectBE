package com.project.movie.controller;

import com.project.movie.dto.SeatDTO;
import com.project.movie.dto.SeatForm;
import com.project.movie.entity.Seat;
import com.project.movie.service.SeatService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/seat")
public class SeatController {

    private final SeatService seatService;

    @ApiOperation(value = "좌석 생성", notes = "좌석 정보를 입력받아 극장을 생성한다.")
    @PostMapping("/create")
    public ResponseEntity<SeatDTO> createSeat(@RequestBody SeatForm seatForm) {
        SeatDTO seat = seatService.join(seatForm);
        return ResponseEntity.ok().body(seat);
    }

    @ApiOperation(value = "좌석 수정", notes = "좌석 정보(DTO)와 id(PK)를 입력받아 좌석 정보를 수정한다.")
    @PutMapping("/{seat_id}")
    public ResponseEntity<SeatDTO> updateSeat(@PathVariable Long seat_id, @RequestBody SeatForm seatForm) {
        SeatDTO seat = seatService.updateSeat(seat_id, seatForm);
        return ResponseEntity.ok().body(seat);
    }

    @ApiOperation(value = "좌석 삭제", notes = "좌석 id(PK)를 입력받아 좌석 정보를 삭제한다.")
    @DeleteMapping("/{seat_id}")
    public ResponseEntity deleteSeat(@PathVariable Long seat_id) {
        seatService.deleteSeat(seat_id);
        return ResponseEntity.ok().body(seat_id);
    }

    @ApiOperation(value = "전체 좌석 조회", notes = "전체 좌석 정보를 반환한다.")
    @GetMapping("/all")
    public ResponseEntity<Result<List<SeatDTO>>> findAllSeat() {
        List<SeatDTO> seatDTOList = seatService.findAllSeat();
        return ResponseEntity.ok().body(new Result<>(seatDTOList, seatDTOList.size()));
    }

    @ApiOperation(value = "잔여 좌석 조회", notes = "상영관id(PK)를 입력받아 해당 상영시간표의 잔여좌석을 조회한다.")
    @GetMapping("/{screen_id}/aval")
    public ResponseEntity<Result<List<Seat>>> findSeat_aval(@PathVariable Long screen_id){
        List<Seat> seatList = seatService.findSeat_Aval(screen_id);
        return ResponseEntity.ok().body(new Result<>(seatList,seatList.size()));
    }
}