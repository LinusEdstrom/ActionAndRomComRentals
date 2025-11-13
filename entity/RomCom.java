package com.Linus.entity;

public class RomCom extends Dvd {

    // attribute

    private int cheeziness;
    private int hunks;

    //constructor

    public RomCom() {}

    public RomCom(String title, double price, int length, int cheeziness, int hunks) {
      super(title, price, length);
      this.cheeziness = cheeziness;
      this.hunks = hunks;
    }

    public int getLength(){return length;}

    public void setCheeziness(int cheeziness) {
        this.cheeziness = cheeziness;}
    public void setHunks(int hunks) {
        this.hunks = hunks;}

    public int getCheeziness(){return cheeziness;}
    public int getHunks(){return hunks;}


}
