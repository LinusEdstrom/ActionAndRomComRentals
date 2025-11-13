package com.Linus.pricing;

import com.Linus.entity.*;

public class Standard implements PricePolicy {

    public Standard() {}

    @Override
    public double calculatePrice(Member member, double price, int days) {
        return price * days;
    }


}
