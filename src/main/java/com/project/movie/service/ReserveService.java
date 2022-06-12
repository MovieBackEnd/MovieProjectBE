package com.project.movie.service;

import com.project.movie.dto.ReserveDTO;
import com.project.movie.dto.ReserveForm;
import com.project.movie.dto.ReviewDTO;
import com.project.movie.entity.*;
import com.project.movie.repository.*;
import lombok.AllArgsConstructor;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ReserveService {

    private final ReserveRepository reserveRepository;
    private final UserRepository userRepository;
    private final ScreenRepository screenRepository;
    private final SeatRepository seatRepository;
    private final DiscountService discountService;

    @Transactional
    public ReserveDTO join(ReserveForm reserveForm) {
        User user = userRepository.findById(reserveForm.getUser_id()).get();
        Screen screen = screenRepository.findById(reserveForm.getScreen_id()).get();
        Integer[] seat_arr = reserveForm.getSeat_arr();
        List<Seat> seatList = screen.getSeat();


        Reserve reserve = new Reserve();
        reserve.setReserve_id(reserveForm.getReserve_id());
        reserve.setUserId(user);
        reserve.setScreen_id(screen);
        reserve.setReserveDate(LocalDateTime.now());
        if(screen.getFeePolicy().getFeePolicyStatus() == FeePolicyStatus.NONE){
            reserve.setPrice(seat_arr.length * discountService.getOrigin_price());
        }else{
            reserve.setPrice(discountService.getFee(seat_arr.length,screen.getFeePolicy()));
        }

        seatList.forEach(seat -> {
            for (int i = 0; i < seat_arr.length; i++) {
                if (seat_arr[i] == seat.getSeatNum()) {
                    seat.setReserve(false);
                    seatRepository.save(seat);
                }
            }
        });

        ReserveDTO saveReserve = new ReserveDTO(reserveRepository.save(reserve));
        return saveReserve;
    }

    @Transactional
    public ReserveDTO updateReserve(Long reserve_id, ReserveForm reserveForm) {
        Reserve findReserve = reserveRepository.findById(reserve_id).get();
        User findUser = userRepository.findById(reserveForm.getUser_id()).get();
        Screen findScreen = screenRepository.findById(reserveForm.getScreen_id()).get();


        if (findReserve != null) {
            findReserve.setReserve_id(reserve_id);
            findReserve.setUserId(findUser);
            findReserve.setScreen_id(findScreen);
            findReserve.setReserveDate(LocalDateTime.now());

            Integer[] seat_arr = reserveForm.getSeat_arr();
            List<Seat> seatList = findScreen.getSeat();
            seatList.forEach(seat -> {
                for (int i = 0; i < seat_arr.length; i++) {
                    if (seat_arr[i] == seat.getSeatNum()) {
                        seat.setReserve(false);
                        seatRepository.save(seat);
                    }
                }
            });
        }

        ReserveDTO updateReserve = new ReserveDTO(reserveRepository.save(findReserve));
        return updateReserve;
    }

    @Transactional
    public void deleteReserve(Long reserve_id) {
        reserveRepository.deleteById(reserve_id);
    }

    public List<ReserveDTO> findAllReserve() {
        List<Reserve> reserves = reserveRepository.findAll();
        List<ReserveDTO> ReserveDTOList = reserves.stream().map(reserve -> {
            return new ReserveDTO(reserve);
        }).collect(Collectors.toList());
        return ReserveDTOList;
    }

    public List<Reserve> findUserReservation(Long user_id) {
        User user = userRepository.findById(user_id).get();
        List<Reserve> reserveList = reserveRepository.findByUserIdOrderByReserveDateAsc(user);
        return reserveList;
    }

}