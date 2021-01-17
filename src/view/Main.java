package view;

import model.Vertu;
import service.MobileManagement;
import model.Iphone;
import model.Samsung;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MobileManagement mobileManagement = new MobileManagement();
        int choice;
        do {
            listMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter number of mobile product you want to add");
                    int number = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < number; i++) {
                        addMobileProductToList(scanner, mobileManagement);
                    }
                    break;
                case 2:
                    System.out.println("Enter serial number of mobile product");
                    String serialNumber = scanner.nextLine();
                    mobileManagement.findMobileBySerialNumber(serialNumber);
                    break;
                case 3:
                    System.out.println("Enter serial number of mobile product");
                    serialNumber = scanner.nextLine();
                    mobileManagement.removeMobileBySerialNumber(serialNumber);
                    break;
                case 4:
                    mobileManagement.showAllList();
                    break;
                case 5:
                    mobileManagement.sortMobileListByPriceUP();
                    break;
                case 6:
                    mobileManagement.sortMobileListByPriceDOWN();
                    break;
                case 7:
                    System.out.println("Enter serial number of product you want to buy");
                    serialNumber = scanner.nextLine();
                    mobileManagement.purchaseMobileAndCreateBill(serialNumber);
                    break;
                case 8:
                    mobileManagement.writeFile();
                    break;
                case 9:
                    mobileManagement.readFile();
                    break;
                case 0:
                    System.exit(0);
            }
        } while (true);

    }

    private static void addMobileProductToList(Scanner scanner, MobileManagement mobileManagement) {
        System.out.println("Enter name of mobile");
        String name = scanner.nextLine();
        String serial;
        do {
            System.out.println("Enter serial number of mobile product");
            System.out.println("Start with IP/SS/VT and 3 or 4 randomly number from 0 to 9");
            serial = scanner.nextLine();
        } while (!serial.matches(REGEX_SERIAL_NUMBER));
        String color;
        do {
            System.out.println("Enter color of mobile product");
            color = scanner.nextLine();
        } while (!color.matches(REGEX_COLOR));
        String capacity;
        do {
            System.out.println("Enter capacity of mobile product (gb)");
            capacity = scanner.nextLine();
        } while (!capacity.matches(REGEX_CAPACITY));
        boolean invalidSuggestedPrice = true;
        double price;
        do {
            System.out.println("Enter suggested price of mobile product");
            price = Double.parseDouble(scanner.nextLine());
            if (price > 0) {
                invalidSuggestedPrice = false;
            }
            if (invalidSuggestedPrice) {
                System.err.println("Price must be greater than 0");
            }
        } while (invalidSuggestedPrice);
        boolean invalidQuantity = true;
        int quantity;
        do {
            System.out.println("Enter quantity of mobile product");
            quantity = Integer.parseInt(scanner.nextLine());
            if (quantity > 0) {
                invalidQuantity = false;
            }
            if (invalidQuantity) {
                System.err.println("Capacity must be greater than 0");
            }
        } while (invalidQuantity);
        boolean invalidKind = true;
        do {
            System.out.println("Enter model of mobile Iphone/Samsung/Vertu");
            String kind = scanner.nextLine();
            if (kind.equalsIgnoreCase("Iphone")) {
                invalidKind = false;
                System.out.println("Enter version of IOS");
                String versionIOS = scanner.nextLine();
                Iphone iphone = new Iphone(name, serial, color, capacity, price, quantity, versionIOS);
                mobileManagement.addMobile(iphone);
                System.err.println("Successfully added to list");
            } else if (kind.equalsIgnoreCase("Samsung")) {
                invalidKind = false;
                System.out.println("Enter version of Android");
                String versionAndroid = scanner.nextLine();
                Samsung samsung = new Samsung(name, serial, color, capacity, price, quantity, versionAndroid);
                mobileManagement.addMobile(samsung);
                System.err.println("Successfully added to list");
            } else if (kind.equalsIgnoreCase("Vertu")) {
                invalidKind = false;
                System.out.println("Enter material of Vertu");
                String material = scanner.nextLine();
                Vertu vertu = new Vertu(name, serial, color, capacity, price, quantity, material);
                mobileManagement.addMobile(vertu);
                System.err.println("Successfully added to list");
            }
            if (invalidKind) {
                System.err.println("Not support this product in list");
            }
        } while (invalidKind);
    }

    private static void listMenu() {
        System.out.println("Menu");
        System.out.println("1.Add new mobile product to list");
        System.out.println("2.Find mobile product by Serial number");
        System.out.println("3.Remove mobile product by Serial number");
        System.out.println("4.Show all mobile product in list ");
        System.out.println("5.Display mobile list by ordered price up");
        System.out.println("6.Display mobile list by ordered price down");
        System.out.println("7.Buy mobile");
        System.out.println("8.Write file");
        System.out.println("9.Read file");
        System.out.println("0.Exit");
        System.out.println("----------------------------");
        System.out.println("Enter your choice:");
    }

    private static final String REGEX_SERIAL_NUMBER = "^(IP|SS|VT)[\\d]{3,4}$";
    private static final String REGEX_COLOR = "^[A-Za-z]$";
    private static final String REGEX_CAPACITY = "^[\\d]{2,4}gb$";
}
