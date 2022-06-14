package com.project.movie.service;

import org.springframework.stereotype.Repository;

@Repository
public class RegularPolicyImpl implements DiscountPolicy{

    private Integer regular_percent = 1;

    @Override
    public void setPolicyCondition(Integer percent) {
        this.regular_percent = percent;
    }

    @Override
    public Integer getFee(Integer people_num) {
        double percent = regular_percent * 0.01;
        double sale = (DiscountPolicy.origin_price * people_num) * percent;
        System.out.println(sale);
        int total_price = (DiscountPolicy.origin_price * people_num) - (int)sale;
        return (Integer)total_price;
    }
}