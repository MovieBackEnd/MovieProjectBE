package com.project.movie.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QScreenTheater is a Querydsl query type for ScreenTheater
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QScreenTheater extends EntityPathBase<ScreenTheater> {

    private static final long serialVersionUID = -1326478694L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QScreenTheater screenTheater = new QScreenTheater("screenTheater");

    public final ListPath<Screen, QScreen> screen = this.<Screen, QScreen>createList("screen", Screen.class, QScreen.class, PathInits.DIRECT2);

    public final NumberPath<Long> screenTheater_id = createNumber("screenTheater_id", Long.class);

    public final EnumPath<ScreenTheaterName> screenTheaterName = createEnum("screenTheaterName", ScreenTheaterName.class);

    public final QTheater theater;

    public QScreenTheater(String variable) {
        this(ScreenTheater.class, forVariable(variable), INITS);
    }

    public QScreenTheater(Path<? extends ScreenTheater> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QScreenTheater(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QScreenTheater(PathMetadata metadata, PathInits inits) {
        this(ScreenTheater.class, metadata, inits);
    }

    public QScreenTheater(Class<? extends ScreenTheater> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.theater = inits.isInitialized("theater") ? new QTheater(forProperty("theater")) : null;
    }

}

