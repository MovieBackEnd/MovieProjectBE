package com.project.movie.service;

import com.project.movie.dto.ScreenTheaterDTO;
import com.project.movie.dto.ScreenTheaterForm;
import com.project.movie.entity.Screen;
import com.project.movie.entity.ScreenTheater;
import com.project.movie.entity.Theater;
import com.project.movie.repository.MovieRepository;
import com.project.movie.repository.ScreenTheaterRepository;
import com.project.movie.repository.TheaterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class ScreenTheaterService {

    private final ScreenTheaterRepository screenTheaterRepository;
    private final TheaterRepository theaterRepository;


    @Transactional
    public ScreenTheaterDTO createScreenTheater(ScreenTheaterForm screenTheaterForm) {
        Theater theater = theaterRepository.findById(screenTheaterForm.getTheater_id()).get();
        ScreenTheater screenTheater = new ScreenTheater(screenTheaterForm.getScreenTheater_id(), theater, screenTheaterForm.getScreenTheaterName(), null);
        ScreenTheaterDTO save = new ScreenTheaterDTO(screenTheaterRepository.save(screenTheater));
        return save;
    }

    @Transactional
    public ScreenTheaterDTO updateScreenTheater(Long screenTheater_id, ScreenTheaterForm screenTheaterForm) {
        ScreenTheater findScreenTheater = screenTheaterRepository.findById(screenTheater_id).get();
        Theater theater = theaterRepository.findById(screenTheaterForm.getTheater_id()).get();
        if (findScreenTheater != null) {
            findScreenTheater.setScreenTheater_id(screenTheater_id);
            findScreenTheater.setTheater(theater);
            findScreenTheater.setScreenTheaterName(screenTheaterForm.getScreenTheaterName());
        }
        ScreenTheaterDTO updateScreenTheater = new ScreenTheaterDTO(screenTheaterRepository.save(findScreenTheater));
        return updateScreenTheater;
    }

    @Transactional
    public void deleteScreenTheater(Long screenTheater_id) {
        screenTheaterRepository.deleteById(screenTheater_id);
    }
}
