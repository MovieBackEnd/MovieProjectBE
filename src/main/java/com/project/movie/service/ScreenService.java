package com.project.movie.service;

import com.project.movie.dto.ScreenDTO;
import com.project.movie.dto.ScreenForm;
import com.project.movie.entity.Movie;
import com.project.movie.entity.Screen;
import com.project.movie.entity.ScreenTheater;
import com.project.movie.entity.Seat;
import com.project.movie.repository.MovieRepository;
import com.project.movie.repository.ScreenRepository;
import com.project.movie.repository.ScreenTheaterRepository;
import com.project.movie.repository.SeatRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ScreenService {

    private final ScreenRepository screenRepository;
    private final MovieRepository movieRepository;
    private final ScreenTheaterRepository screenTheaterRepository;
    private final SeatRepository seatRepository;

    @Transactional
    public ScreenDTO createScreen(ScreenForm screenForm) {
        Movie movie = movieRepository.findById(screenForm.getMovieId()).get();
        ScreenTheater screenTheater = screenTheaterRepository.findById(screenForm.getScreenTheaterId()).get();

        Screen screen = new Screen();
        screen.setScreen_id(screenForm.getScreen_id());
        screen.setScreenTime(screenForm.getScreenTime());
        screen.setMovie(movie);
        screen.setScreenTheater(screenTheater);

        for(int i=1; i<9; i++){
            Seat seat = new Seat();
            seat.setSeatNum(i);
            seat.setReserve(true);
            seat.setScreenId(screen);
            seatRepository.save(seat);
        }


        ScreenDTO save = new ScreenDTO(screenRepository.save(screen));
        return save;
    }

    @Transactional
    public ScreenDTO updateScreen(Long screen_id, ScreenForm screenForm) {
        Screen findScreen = screenRepository.findById(screen_id).get();
        if (findScreen != null) {
            Movie movie = movieRepository.findById(screenForm.getMovieId()).get();
            ScreenTheater screenTheater = screenTheaterRepository.findById(screenForm.getScreenTheaterId()).get();

            findScreen.setScreen_id(screen_id);
            findScreen.setScreenTime(screenForm.getScreenTime());
            findScreen.setMovie(movie);
            findScreen.setScreenTheater(screenTheater);
        }
        ScreenDTO updateScreen = new ScreenDTO(screenRepository.save(findScreen));
        return updateScreen;
    }

    @Transactional
    public void deleteScreen(Long screen_id) {
        screenRepository.deleteById(screen_id);
    }

    public List<ScreenDTO> findByMovieId(Long movieId) {
        List<Screen> screens = screenRepository.findByMovie_MovieId(movieId);
        List<ScreenDTO> screenDTOList = screens.stream().map((screen) -> {
            Long screen_id = screen.getScreen_id();
            LocalDateTime screenTime = screen.getScreenTime();
            Movie movie = screen.getMovie();
            ScreenTheater screenTheater = screen.getScreenTheater();
            return new ScreenDTO(screen_id, screenTime, movie, screenTheater);
        }).collect(Collectors.toList());

        return screenDTOList;
    }
}
