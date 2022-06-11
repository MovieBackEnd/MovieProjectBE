package com.project.movie.controller;

import com.project.movie.dto.MovieDTO;
import com.project.movie.entity.Movie;
import com.project.movie.service.MovieService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {

    private final MovieService movieService;

    @ApiOperation(value = "영화 생성", notes = "영화 정보를 입력받아 영화를 생성후, DB에 저장한다..")
    @PostMapping("/create")
    public ResponseEntity<MovieDTO> createMovie(@RequestBody MovieDTO movieDTO) {
        MovieDTO movie = movieService.createMovie(movieDTO);
        return ResponseEntity.ok().body(movie);
    }

    @ApiOperation(value = "영화 정보 수정", notes = "영화id(PK)를 입력받아 영화 정보를 수정한다.")
    @PutMapping("/{movie_id}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable Long movie_id, @RequestBody MovieDTO movieDTO) {
        MovieDTO movie = movieService.updateMovie(movie_id, movieDTO);
        return ResponseEntity.ok().body(movie);
    }

    @ApiOperation(value = "영화 정보 삭제", notes = "영화id(PK)를 입력받아 영화 정보를 삭제한다. ")
    @DeleteMapping("/{movie_id}")
    public void deleteMovie(@PathVariable Long movie_id) {
        movieService.deleteMovie(movie_id);
    }

    @ApiOperation(value = "전체 영화 정보 조회(페이지네이션 x)", notes = "전체 영화 정보를 조회한다.")
    @GetMapping("/all")
    public ResponseEntity<Result<List<MovieDTO>>> findAllMovie() {
        List<MovieDTO> movieDTOList = movieService.findAllMovie();
        return ResponseEntity.ok().body(new Result<>(movieDTOList, movieDTOList.size()));
    }

    @ApiOperation(value = "전체 영화 정보 조회(페이지네이션)",
            notes = "전체 영화 정보를 조회한다. " +
                    "QueryString : page / size")
    @GetMapping("/all/pagination")
    public ResponseEntity<PaginationResult<List<Movie>>> findAllMovie_PageNation(@PageableDefault(size = 5) Pageable pageable) {
        Page<Movie> page = movieService.findAllMovie_PageNation(pageable);
        List<Movie> movieList = page.getContent();
        Integer totalPages = page.getTotalPages();
        Integer totalElements = (int) page.getTotalElements();
        Integer size = page.getSize();
        return ResponseEntity.ok().body(new PaginationResult<>(movieList, totalPages, totalElements, size));
    }
}
