package com.project.movie.service;

public interface DiscountPolicy {
    Integer origin_price = 5000;
    Integer getFee(Integer people_num);
    void setPolicyCondition(Integer condition);
}
