package com.Linus.database;

import com.Linus.entity.Action;
import com.Linus.entity.Dvd;
import com.Linus.entity.Item;
import com.Linus.entity.RomCom;

import java.util.ArrayList;

import java.util.List;

public class Inventory  {

    private final List<Item> inventoryList = new ArrayList<>();

        //constructors


        //Metoder

        public List<Item> listItems(){return new ArrayList<>(inventoryList);
        }
        // Funkar som Item item : invetoryList, for (item) if (!item.isRented) sout item.getTitle
        public List<Item> listRentables(){return inventoryList.stream().filter(i-> !i.isRented()).toList();}

        public Item findByTitle(String title){
            String search = title.trim();
            for(Item item : inventoryList) {
            if (item.getTitle().equalsIgnoreCase(title))
                return item;
        }
        return null;
        }

        public List<Item> findRentables(){
            return inventoryList.stream().filter(i-> !i.isRented()).toList();
        }

        public Action createAndAddAction(String title, double price, int length, int explosions, int coolOneliners){
        Action action = new Action(title, price, length, explosions, coolOneliners);
        inventoryList.add(action);
        return action;
    }
        public RomCom createAndAddRomCom(String title, double price, int length, int cheeziness, int hunks){
            RomCom romCom = new RomCom(title, price, length, cheeziness, hunks);
            inventoryList.add(romCom);
            return romCom;
        }

        public List<Item> getInventoryList() {
        return inventoryList;
    }
        public List<Dvd> dvdList() {
            List<Dvd> dvdList = new ArrayList<>();
            for (Item item : inventoryList) {
                if (item instanceof Dvd dvd) {
                    dvdList.add(dvd);   }
            }
            return dvdList;
        }
        public List<Action> actionList() {
            List<Action> actionList = new ArrayList<>();
            for (Item item : inventoryList) {
                if (item instanceof Action action) {
                    actionList.add(action);}
                }
            return actionList;
            }

        public List<RomCom> romComList() {
            List<RomCom> romComList = new ArrayList<>();
            for (Item item : inventoryList) {
                if (item instanceof RomCom romCom) {
                    romComList.add(romCom); }
                }
            return romComList;
            }



}








