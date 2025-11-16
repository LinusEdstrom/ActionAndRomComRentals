package com.Linus.entity;

public class Dvd extends Item {

    //attribut

    protected double basePrice;
    protected int length;

    //constructor

    public Dvd() {}

    public Dvd(String title, double basePrice, int length){
            super(title);
            this.basePrice = basePrice;
            this.length = length;
        }
        @Override
        public double getPricePerDay () {
            return basePrice;
        }
    }
