package com.project.movie.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTheater is a Querydsl query type for Theater
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTheater extends EntityPathBase<Theater> {

    private static final long serialVersionUID = 2109479014L;

    public static final QTheater theater = new QTheater("theater");

    public final ListPath<ScreenTheater, QScreenTheater> screenTheater = this.<ScreenTheater, QScreenTheater>createList("screenTheater", ScreenTheater.class, QScreenTheater.class, PathInits.DIRECT2);

    public final NumberPath<Long> theater_id = createNumber("theater_id", Long.class);

    public final EnumPath<TheaterName> theaterName = createEnum("theaterName", TheaterName.class);

    public QTheater(String variable) {
        super(Theater.class, forVariable(variable));
    }

    public QTheater(Path<? extends Theater> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTheater(PathMetadata metadata) {
        super(Theater.class, metadata);
    }

}

