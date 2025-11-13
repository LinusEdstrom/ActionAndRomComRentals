package com.Linus.service;


import com.Linus.database.Inventory;
import com.Linus.entity.*;
import com.Linus.pricing.Premium;
import com.Linus.pricing.PricePolicy;
import com.Linus.pricing.Standard;
import com.Linus.pricing.Student;


import java.util.ArrayList;
import java.util.List;

public class RentalService {

    //Gör så att bara RentalService kan koppla till inventory. Med private final.
    private final Inventory inventory;
    private final List<Rental> rentals = new ArrayList<>();

    public RentalService(Inventory inventory) {
        this.inventory = inventory;
    }
        private PricePolicy getPolicy(Member member) {
         switch (member.getStatusLevel().toLowerCase()) {

            case "student":
                return new Student();

            case "premium":
                return new Premium();

            default:
                return new Standard();

        }
         }

        public Rental rentItem(Member member, String title, int days) {
            Item item = inventory.findByTitle(title);
            if (item == null || item.isRented()) {
                System.out.println("Item unavailable");
                return null;
            } else {
                PricePolicy policy = getPolicy(member);
                double totalPrice = policy.calculatePrice(member, item.getPricePerDay(), days);

                item.rentOut();

                Rental rental = new Rental(member, item, days, totalPrice);
                rentals.add(rental);
                member.addRentalToHistory(rental);
                System.out.println("Totalprice: " + totalPrice);
                return rental;
            }
        }
        public void returnItem(String title) {
        for (Rental rental : rentals) {

            Item item = rental.getItem();
            System.out.println("DEBUG -> Checking: " + item.getTitle() + ", rented=" + item.isRented());

            if (rental.getItem().getTitle().trim().equalsIgnoreCase(title.trim()) && rental.getItem().isRented()) {
                rental.getItem().returnItem();
                System.out.println("Item returned");
                return;
            }
        }
            System.out.println("U rented this elsewhere");
        }

            //Funkar som for (Rental r : rentals) total += r.getTotalPrice
            public double totalRevenue() {
            double total = 0.0;
            for (Rental rental : rentals) {
                total += rental.getTotalPrice();
            }
            return total;
        }

    public Action addAction(String title, double price, int length, int explosions, int coolOneliners) {
        return inventory.createAndAddAction(title, price, length, explosions, coolOneliners);
    }

    public RomCom addRomCom(String title, double price, int length, int cheeziness, int hunks) {
        return inventory.createAndAddRomCom(title, price, length, cheeziness, hunks);
    }

    public List<Item> listItems() {
        return new ArrayList<>(inventory.getInventoryList());
    }

    public List<Dvd> listDvds() {
        return inventory.dvdList();
    }

    public List<Action> listAction() {
        return inventory.actionList();
    }

    public List<RomCom> listRomCom() {
        return inventory.romComList();
    }

    }












