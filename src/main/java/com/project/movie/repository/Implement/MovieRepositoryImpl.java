package com.project.movie.repository.Implement;

import com.project.movie.dto.MovieSearch;
import com.project.movie.entity.Movie;
import com.project.movie.entity.QMovie;
import com.project.movie.repository.MovieRepositoryCustom;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class MovieRepositoryImpl implements MovieRepositoryCustom {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Movie> findAllMovie(MovieSearch movieSearch) {
        QMovie movie = QMovie.movie;
        JPAQueryFactory query = new JPAQueryFactory(em);

        return query
                .select(movie)
                .from(movie)
                .where(nameLike(movieSearch),actorLike(movieSearch))
                .limit(100)
                .fetch();
    }

    private BooleanExpression nameLike(MovieSearch movieSearch) {
        if (!StringUtils.hasText(movieSearch.getMovieName())) {
            return null;
        }
        return QMovie.movie.movieName.like(movieSearch.getMovieName());
    }

    private BooleanExpression actorLike(MovieSearch movieSearch) {
        if (!StringUtils.hasText(movieSearch.getActor())) {
            return null;
        }
        return QMovie.movie.actor.like(movieSearch.getActor());
    }
}
