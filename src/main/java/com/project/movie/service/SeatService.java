package com.project.movie.service;


import com.project.movie.dto.SeatDTO;
import com.project.movie.dto.SeatForm;
import com.project.movie.dto.SeatResponseDTO;
import com.project.movie.entity.FeePolicyStatus;
import com.project.movie.entity.Screen;
import com.project.movie.entity.Seat;
import com.project.movie.repository.ScreenRepository;
import com.project.movie.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class SeatService {

    private final SeatRepository seatRepository;
    private final ScreenRepository screenRepository;
    private final DiscountService discountService;

    @Transactional
    public SeatDTO join(SeatForm seatForm) {
        Screen screen = screenRepository.findById(seatForm.getScreenId()).get();

        Seat seat = new Seat();
        seat.setSeatId(seatForm.getSeat_id());
        seat.setSeatNum(seatForm.getSeat_num());
        seat.setReserve(seatForm.isReserve());
        seat.setScreenId(screen);

        SeatDTO saveSeat = new SeatDTO(seatRepository.save(seat));
        return saveSeat;
    }

    @Transactional
    public SeatDTO updateSeat(Long seat_id, SeatForm seatForm) {
        Seat findSeat = seatRepository.findById(seat_id).get();
        if (findSeat != null) {

            Screen screen = screenRepository.findById(seatForm.getScreenId()).get();

            findSeat.setSeatId(seat_id);
            findSeat.setSeatNum(seatForm.getSeat_num());
            findSeat.setReserve(seatForm.isReserve());
        }
        SeatDTO updateSeat = new SeatDTO(seatRepository.save(findSeat));
        return updateSeat;
    }

    public List<SeatResponseDTO> findSeatsByScreenId(Long screen_id) {
        Screen screen = screenRepository.findById(screen_id).get();
        Integer seatPrice = 0;

        if(screen.getFeePolicy().getFeePolicyStatus() ==FeePolicyStatus.REGULAR){
            double regular_percent = screen.getFeePolicy().getRegular();
            double percent = regular_percent * 0.01;
            double sale = discountService.getOrigin_price() * percent;
            seatPrice = discountService.getOrigin_price() - (int)sale;
        }else if(screen.getFeePolicy().getFeePolicyStatus() == FeePolicyStatus.FLAT_RATE){
            double discount = screen.getFeePolicy().getFlatRate();
            seatPrice = discountService.getOrigin_price() - (int)discount;
        }else{
            seatPrice = discountService.getOrigin_price();
        }

        final int finalSeatPrice = seatPrice;
        List<SeatResponseDTO> seatList = seatRepository.findByScreenId(screen).stream().map((seat) -> {
            return new SeatResponseDTO(seat, finalSeatPrice);
        }).collect(Collectors.toList());

        return seatList;
    }

    @Transactional
    public void deleteSeat(Long seat_id) {
        seatRepository.deleteById(seat_id);
    }

    public List<SeatDTO> findAllSeat() {
        List<Seat> seats = seatRepository.findAll();
        List<SeatDTO> SeatDTOList = seats.stream().map(seat -> {
            return new SeatDTO(seat);
        }).collect(Collectors.toList());
        return SeatDTOList;
    }

    public List<Seat> findSeat_Aval(Long screen_id) {
        Optional<Screen> screen = screenRepository.findById(screen_id);
        if (screen.isPresent()) {
            return seatRepository.findByScreenIdAndIsReserve(screen.get(), true);
        }
        return null;
    }
}