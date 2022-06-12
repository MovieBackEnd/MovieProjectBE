package com.project.movie.service;

import org.springframework.stereotype.Repository;

@Repository
public class FlatRatePolicyImpl implements DiscountPolicy{

    private Integer flatRate;

    @Override
    public void setPolicyCondition(Integer condition) {
        this.flatRate = condition;
    }
    @Override
    public Integer getFee(Integer people_num) {
        return (DiscountPolicy.origin_price - flatRate) * people_num;
    }
}
