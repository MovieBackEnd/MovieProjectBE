package com.project.movie.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMovie is a Querydsl query type for Movie
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMovie extends EntityPathBase<Movie> {

    private static final long serialVersionUID = -366055227L;

    public static final QMovie movie = new QMovie("movie");

    public final StringPath actor = createString("actor");

    public final EnumPath<Genre> genre = createEnum("genre", Genre.class);

    public final NumberPath<Long> movieId = createNumber("movieId", Long.class);

    public final StringPath movieName = createString("movieName");

    public final DateTimePath<java.util.Date> release_date = createDateTime("release_date", java.util.Date.class);

    public final NumberPath<Integer> runtime = createNumber("runtime", Integer.class);

    public final ListPath<Screen, QScreen> screen = this.<Screen, QScreen>createList("screen", Screen.class, QScreen.class, PathInits.DIRECT2);

    public final EnumPath<ScreenGrade> screenGrade = createEnum("screenGrade", ScreenGrade.class);

    public final StringPath url = createString("url");

    public QMovie(String variable) {
        super(Movie.class, forVariable(variable));
    }

    public QMovie(Path<? extends Movie> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMovie(PathMetadata metadata) {
        super(Movie.class, metadata);
    }

}

