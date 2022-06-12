package com.project.movie.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class FeePolicy {
    @Enumerated(EnumType.STRING)
    private FeePolicyStatus feePolicyStatus = FeePolicyStatus.NONE;
    private Integer regular;
    private Integer flatRate;
}
