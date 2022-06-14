package com.project.movie.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFeePolicy is a Querydsl query type for FeePolicy
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QFeePolicy extends BeanPath<FeePolicy> {

    private static final long serialVersionUID = -1905246355L;

    public static final QFeePolicy feePolicy = new QFeePolicy("feePolicy");

    public final EnumPath<FeePolicyStatus> feePolicyStatus = createEnum("feePolicyStatus", FeePolicyStatus.class);

    public final NumberPath<Integer> flatRate = createNumber("flatRate", Integer.class);

    public final NumberPath<Integer> regular = createNumber("regular", Integer.class);

    public QFeePolicy(String variable) {
        super(FeePolicy.class, forVariable(variable));
    }

    public QFeePolicy(Path<? extends FeePolicy> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFeePolicy(PathMetadata metadata) {
        super(FeePolicy.class, metadata);
    }

}

