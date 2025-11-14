package com.Linus.entity;

import java.time.LocalDate;
// Tillfällig tidtagare
import java.time.temporal.ChronoUnit;

public class Rental {

    // Attribut som ska kopplas i rental i en tidsperiod.
    private Item item;
    private Member member;
    private LocalDate rentalDate;
    private LocalDate returnDate;
    private double totalPrice;

    // Man lägger in rentalDate som LocalDate.now, vilket är dagens datum
    public Rental(Member member, Item item, int days, double totalPrice){
        this.member = member;
        this.item = item;
        this.rentalDate = LocalDate.now();
        this.returnDate = rentalDate.plusDays(days);
        this.totalPrice = totalPrice;
    }
        public Item getItem(){return item;}
    public Member getMember(){return member;}
    public LocalDate getRentalDate(){return rentalDate;}
    public LocalDate getReturnDate(){return returnDate;}
    public double getTotalPrice(){return totalPrice;}

    public boolean isActive(){return LocalDate.now().isBefore(returnDate);}

    //Kolla det här
    @Override
    public String toString(){
        return member.getName() +" rents "+ item.getTitle() + " from " + rentalDate + " until " + returnDate;
    }

}
