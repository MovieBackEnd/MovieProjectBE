package com.project.movie.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QReserve is a Querydsl query type for Reserve
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QReserve extends EntityPathBase<Reserve> {

    private static final long serialVersionUID = 261631249L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QReserve reserve = new QReserve("reserve");

    public final NumberPath<Integer> price = createNumber("price", Integer.class);

    public final DateTimePath<java.time.LocalDateTime> reserve_date = createDateTime("reserve_date", java.time.LocalDateTime.class);

    public final NumberPath<Long> reserve_id = createNumber("reserve_id", Long.class);

    public final ListPath<Review, QReview> review = this.<Review, QReview>createList("review", Review.class, QReview.class, PathInits.DIRECT2);

    public final QScreen screen_id;

    public final QUser user_id;

    public QReserve(String variable) {
        this(Reserve.class, forVariable(variable), INITS);
    }

    public QReserve(Path<? extends Reserve> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QReserve(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QReserve(PathMetadata metadata, PathInits inits) {
        this(Reserve.class, metadata, inits);
    }

    public QReserve(Class<? extends Reserve> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.screen_id = inits.isInitialized("screen_id") ? new QScreen(forProperty("screen_id"), inits.get("screen_id")) : null;
        this.user_id = inits.isInitialized("user_id") ? new QUser(forProperty("user_id")) : null;
    }

}

