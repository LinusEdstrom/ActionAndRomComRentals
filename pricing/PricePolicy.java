package com.Linus.pricing;

import com.Linus.entity.Member;

public interface PricePolicy {

    double calculatePrice(Member member, double basePrice, int days);

}
