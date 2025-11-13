package com.Linus.pricing;

import com.Linus.entity.Member;

public class Premium implements PricePolicy {

    public Premium(){}

    @Override
    public double calculatePrice(Member member, double basePrice, int days) {
        return basePrice * days * 0.7;
    }

}
