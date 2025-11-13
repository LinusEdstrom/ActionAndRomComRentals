package com.Linus.pricing;

import com.Linus.entity.Member;

public class Student implements PricePolicy {

    public Student(){}

    @Override
    public double calculatePrice(Member member, double price, int days){
        return price * days * 0.85;
    }


}
