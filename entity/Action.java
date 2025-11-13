package com.Linus.entity;

public class Action extends Dvd {

    //attribute

    private int explosions;
    private int coolOneliners;

        public Action() {}

        public Action(String title, double basePrice, int length, int explosions, int coolOneliners){
        super(title, basePrice, length);
        this.explosions = explosions;
        this.coolOneliners = coolOneliners;
    }
    // Den här ska nog bort

        public double getPrice (){
        return basePrice;
    }
    public int getLength(){return length;}
    public void setLength(int length){this.length = length;}
    public int getExplosions() {return explosions;}
    public void setExplosions(int explosions) {this.explosions = explosions;}
    public int getCoolOneliners() {return coolOneliners;}
    public void setCoolOneliners(int coolOneliners) {this.coolOneliners = coolOneliners;}
}
