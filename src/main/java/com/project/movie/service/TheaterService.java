package com.project.movie.service;

import com.project.movie.dto.TheaterDTO;
import com.project.movie.entity.Theater;
import com.project.movie.repository.TheaterRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@AllArgsConstructor
public class TheaterService {

    private final TheaterRepository theaterRepository;

    @Transactional
    public TheaterDTO join(TheaterDTO theaterDTO) {
        Theater theater = theaterDTO.toEntity();
        TheaterDTO saveTheater = new TheaterDTO(theaterRepository.save(theater));
        return saveTheater;
    }

    @Transactional
    public TheaterDTO updateTheater(Long theater_id, TheaterDTO theaterDTO) {
        Theater findTheater = theaterRepository.findById(theater_id).get();
        if (findTheater != null) {
            findTheater.setTheater_id(theater_id);
            findTheater.setTheaterName(theaterDTO.getTheaterName());
        }
        TheaterDTO updateTheater = new TheaterDTO(theaterRepository.save(findTheater));
        return updateTheater;
    }

    @Transactional
    public void deleteTheater(Long theater_id) {
        theaterRepository.deleteById(theater_id);
    }

    public List<TheaterDTO> findAllTheater() {
        List<Theater> theaters = theaterRepository.findAll();
        List<TheaterDTO> TheaterDTOList = theaters.stream().map(theater -> {
            return new TheaterDTO(theater);
        }).collect(Collectors.toList());
        return TheaterDTOList;
    }

}