package com.project.movie.service;

import com.project.movie.entity.FeePolicy;
import com.project.movie.entity.FeePolicyStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.Map;

@Service
public class DiscountService {
    private final Map<String, DiscountPolicy> policyMap;
    private final Integer origin_price = DiscountPolicy.origin_price;

    @Autowired
    public DiscountService(Map<String, DiscountPolicy> policyMap) {
        this.policyMap = policyMap;
    }

    public Integer getFee(Integer people_num, FeePolicy feePolicy) {
        Integer total_Price = 0;
        if (feePolicy.getFeePolicyStatus() == FeePolicyStatus.REGULAR) {
            policyMap.get("regularPolicyImpl").setPolicyCondition(feePolicy.getRegular());
            total_Price = policyMap.get("regularPolicyImpl").getFee(people_num);
        } else if (feePolicy.getFeePolicyStatus() == FeePolicyStatus.FLAT_RATE) {
            policyMap.get("flatRatePolicyImpl").setPolicyCondition(feePolicy.getFlatRate());
            total_Price = policyMap.get("flatRatePolicyImpl").getFee(people_num);
        }

        return total_Price;
    }

    public Integer getOrigin_price() {
        return this.origin_price;
    }

}
