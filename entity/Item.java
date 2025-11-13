package com.Linus.entity;

import java.util.UUID;

public abstract class Item {

    //attribute

    protected String id;
    protected String title;
    private boolean rented;

    public Item(){}


    public Item(String title) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.rented = false;
    }

    public String getId() {return id;}
    public void setId(String id) {this.id = id;}

    public String getTitle()
    {return title;}

    public boolean isRented() {return rented;}

    public void rentOut(){rented = true;}

    public void returnItem(){rented = false;}

    public abstract double getPricePerDay();

    @Override
    public String toString()
    {return title + " - " + (rented ? "Rented" : "Available");
    }
    }





