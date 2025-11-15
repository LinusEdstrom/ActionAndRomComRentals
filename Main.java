package com.Linus;

import com.Linus.database.Inventory;
import com.Linus.entity.*;
import com.Linus.service.MembershipService;
import com.Linus.database.MemberRegistry;
import com.Linus.service.RentalService;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class Main {
    static void main(String[] args) {

        MemberRegistry memberRegistry = new MemberRegistry();
        MembershipService membershipService = new MembershipService(memberRegistry);
        Inventory inventory = new Inventory();
        RentalService rentalService = new RentalService(inventory);
        fillMemberList(membershipService);
        fillActionList(rentalService);
        fillRomComList(rentalService);

        Scanner scanner = new Scanner(System.in);
        boolean toMeny = true;

        while (toMeny) {
            System.out.println("");
            System.out.println("Menu choices");
            System.out.println("");
            System.out.println("1. Add new member");
            System.out.println("2. Search member");
            System.out.println("3. Change status level");
            System.out.println("4. List all members");
            System.out.println("");
            System.out.println("5. List all movies");
            System.out.println("6. List all action movies");
            System.out.println("7. List all romCom movies");
            System.out.println("");
            System.out.println("8. Add new action movie");
            System.out.println("9. Add new romCom movie");
            System.out.println("");
            System.out.println("10.Rent a movie");
            System.out.println("11.Return a movie");
            System.out.println("");
            System.out.println("12. Exit menu");
            System.out.println("13. Rental history");
            System.out.println("14. Sum revenues");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1: newMember(scanner, membershipService);
                    break;
                case 2: searchMember(scanner, membershipService);
                    break;
                case 3: changeStatusLevel(scanner, membershipService);
                    break;
                case 4: listAllMembers(membershipService);
                    break;
                case 5: listAllDvds(rentalService);
                    break;
                case 6: listAllAction(rentalService);
                    break;
                case 7: listAllRomCom(rentalService);
                    break;
                case 8: addNewAction(scanner, rentalService);
                    break;
                case 9: addNewRomCom(scanner, rentalService);
                    break;
                case 10:
                    rentDvd(scanner, memberRegistry, rentalService);
                    break;
                case 11:
                    returnDvd(scanner, rentalService);
                    break;
                case 12:
                    toMeny = false;
                    break;
                case 13:
                    rentalHistory(scanner, membershipService, rentalService);
                    break;
                    case 14:
                    totalRevenues(rentalService);
            }
            System.out.println("\nPress Enter for main menu");
            scanner.nextLine();
        }
    }

    private static void rentDvd(Scanner scanner, MemberRegistry memberRegistry, RentalService rentalService) {
        System.out.println("Member Id: ");
        long memberId = scanner.nextLong();
        scanner.nextLine();

        Member rentMember = memberRegistry.findById(memberId);

        System.out.println("Title to rent: ");
        String title = scanner.nextLine();

        System.out.println("How many days: ");
        int days = scanner.nextInt();
        scanner.nextLine();

        Rental tryRental = rentalService.rentItem(rentMember, title, days);
        if (tryRental != null) {
            System.out.println(tryRental);
        }
    }

    private static void returnDvd(Scanner scanner, RentalService rentalService) {
        scanner.nextLine();
        System.out.println("Titel: ");
        rentalService.returnItem(scanner.nextLine().trim());
    }

    private static void newMember(Scanner scanner, MembershipService membershipService) {
        System.out.println("member Name");
        String name = scanner.next();
        System.out.println("member Status");
        String status = scanner.next();
        membershipService.registerMember(name, status);
    }

        private static void listAllMembers(MembershipService membershipService) {
        for (Member allMembers : membershipService.listAllMembers())
            System.out.println(allMembers.getId() + " - " + allMembers.getName() + " - " + allMembers.getStatusLevel());

    }

    private static void searchMember(Scanner scanner, MembershipService membershipService) {
        System.out.println("member Name");
        String name = scanner.next();
        boolean exist = membershipService.lookForMember(name);
        if (exist) {
            System.out.println("Member exists");
        } else {
            System.out.println("Member does not exist");
        }
    }

    private static void changeStatusLevel(Scanner scanner, MembershipService membershipService) {
        System.out.println("member name");
        String name = (scanner.nextLine());
        System.out.println("New statuslevel");
        String newStatusLevel = scanner.nextLine();
        membershipService.changeStatus(name, newStatusLevel);
    }

    private static void rentalHistory(Scanner scanner, MembershipService membershipService, RentalService rentalService) {
        System.out.println("member name");
        String name = scanner.nextLine();
        Member historyMember = membershipService.findByName(name);
        rentalService.printHistory(historyMember);
    }



        private static void totalRevenues(RentalService rentalService) {
        System.out.println("the total revenues are " + rentalService.totalRevenue());
    }

    private static void addNewAction(Scanner scanner, RentalService rentalService) {

    System.out.println("Item title");
    String title = scanner.nextLine();
    System.out.println("Item pricePerDay");
    double price = Double.parseDouble(scanner.nextLine());
    System.out.println("Item length");
    int length = Integer.parseInt(scanner.nextLine());
    System.out.println("Item explosions");
    int explosions = Integer.parseInt(scanner.nextLine());
    System.out.println("Item coolOneliners");
    int coolOneliners = Integer.parseInt(scanner.nextLine());
    rentalService.addAction(title, price, length, explosions, coolOneliners);
}
    private static void fillActionList(RentalService rentalService) {
    rentalService.addAction ("WarZone", 38, 120, 18, 13);
    rentalService.addAction("BloodAndMoney", 28, 105, 4, 6);
    rentalService.addAction("Kablamoh", 38, 140, 28, 22);
}

    private static void addNewRomCom(Scanner scanner, RentalService rentalService) {
    System.out.println("Item title");
    String title = scanner.nextLine();
    System.out.println("Item pricePerDay");
    double price = Double.parseDouble(scanner.nextLine());
    System.out.println("Item length");
    int length = Integer.parseInt(scanner.nextLine());
    System.out.println("Item explosions");
    int cheeziness = Integer.parseInt(scanner.nextLine());
    System.out.println("Item coolOneliners");
    int hunks = Integer.parseInt(scanner.nextLine());
    rentalService.addRomCom(title, price, length, cheeziness, hunks);
}
    private static void fillRomComList(RentalService rentalService) {
    rentalService.addRomCom("mr.Gingerbread", 48, 162, 42, 1);
    rentalService.addRomCom("Paris in spring", 58, 205, 68, 3);
    rentalService.addRomCom("Two boys in red", 48, 184, 32, 2);
}

    private static void fillMemberList(MembershipService membershipService) {
        membershipService.registerMember("Ofelia", "standard");
        membershipService.registerMember("Lisa", "premium");
        membershipService.registerMember("Thor", "student");
        membershipService.registerMember("KentJesus", "student");
        membershipService.registerMember("Majken", "standard");
    }

    private static void listAllDvds(RentalService rentalService){
        rentalService.listDvds();
        for (Dvd dvds : rentalService.listDvds())
            System.out.println(dvds.getTitle());
    }
    private static void listAllAction(RentalService rentalService){
        rentalService.listAction();
        for(Action action : rentalService.listAction())
            System.out.println(action.getTitle());
    }
    private static void listAllRomCom(RentalService rentalService){
        rentalService.listRomCom();
        for(RomCom romCom : rentalService.listRomCom())
            System.out.println(romCom.getTitle());
    }



}

