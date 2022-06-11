package com.project.movie.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PaginationResult<T> {
    private T data;
    private Integer totalPages;
    private Integer totalElements;
    private Integer size;
}
