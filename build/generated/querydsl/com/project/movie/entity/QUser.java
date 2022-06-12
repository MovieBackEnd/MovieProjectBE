package com.project.movie.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 404075414L;

    public static final QUser user = new QUser("user");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final BooleanPath isAdmin = createBoolean("isAdmin");

    public final StringPath loginid = createString("loginid");

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public final ListPath<Reserve, QReserve> reserve = this.<Reserve, QReserve>createList("reserve", Reserve.class, QReserve.class, PathInits.DIRECT2);

    public final NumberPath<Long> user_id = createNumber("user_id", Long.class);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

