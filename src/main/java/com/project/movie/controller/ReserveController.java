package com.project.movie.controller;

import com.project.movie.dto.ReserveDTO;
import com.project.movie.dto.ReserveForm;
import com.project.movie.dto.ReviewDTO;
import com.project.movie.service.ReserveService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reserve")
public class ReserveController {

    private final ReserveService reserveService;

    @ApiOperation(value = "예매 등록", notes = "예매 정보를 입력받아 예매를 생성한다.")
    @PostMapping("/create")
    public ResponseEntity<ReserveDTO> createReserve(@RequestBody ReserveForm reserveForm) {
        ReserveDTO reserve = reserveService.join(reserveForm);
        return ResponseEntity.ok().body(reserve);
    }

    @ApiOperation(value = "예매 수정", notes = "예매(DTO)와 id(PK)를 입력받아 예매내역을 수정한다.")
    @PutMapping("/{reserve_id}")
    public ResponseEntity<ReserveDTO> updateReserve(@PathVariable Long reserve_id, @RequestBody ReserveForm reserveForm) {
        ReserveDTO reserve = reserveService.updateReserve(reserve_id, reserveForm);
        return ResponseEntity.ok().body(reserve);
    }


    @ApiOperation(value = "예매 삭제", notes = "예매 id(PK)를 입력받아 예매내역을 삭제한다.")
    @DeleteMapping("/{reserve_id}")
    public ResponseEntity deleteReserve(@PathVariable Long reserve_id) {
        reserveService.deleteReserve(reserve_id);
        return ResponseEntity.ok().body(reserve_id);
    }

    @ApiOperation(value = "전체 예매 조회", notes = "전체 예매 정보를 반환한다.")
    @GetMapping("/all")
    public ResponseEntity<Result<List<ReserveDTO>>> findAllReserve() {
        List<ReserveDTO> reserveDTOList = reserveService.findAllReserve();
        return ResponseEntity.ok().body(new Result<>(reserveDTOList, reserveDTOList.size()));
    }
}