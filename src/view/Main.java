package view;

import model.Mobile;
import model.Vertu;
import service.MobileManagement;
import model.Iphone;
import model.Samsung;

import java.util.Scanner;


public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static MobileManagement mobileManagement = new MobileManagement();

    public static void main(String[] args) {
        int choice;
        do {
            listMenu();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.out.println("Enter number of mobile product you want to add");
                    try {
                        int number = Integer.parseInt(scanner.nextLine());
                        for (int i = 0; i < number; i++) {
                            Mobile mobile = getInfoMobile();
                            mobileManagement.addMobile(mobile);
                            System.out.println("Successfully added");
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Incorrect format");
                    }
                    break;
                case 2:
                    System.out.println("Enter serial number of mobile product");
                    String serialNumber = scanner.nextLine();
                    mobileManagement.findMobileBySerialNumber(serialNumber);
                    break;
                case 3:
                    System.out.println("Enter serial number of product");
                    serialNumber = scanner.nextLine();
                    Mobile editedMobile = getInfoMobile();
                    mobileManagement.editMobileBySerialNumber(serialNumber, editedMobile);
                    break;
                case 4:
                    System.out.println("Enter serial number of mobile product");
                    serialNumber = scanner.nextLine();
                    mobileManagement.removeMobileBySerialNumber(serialNumber);
                    break;
                case 5:
                    mobileManagement.showAllList();
                    break;
                case 6:
                    mobileManagement.sortMobileListByPriceUP();
                    break;
                case 7:
                    mobileManagement.sortMobileListByPriceDOWN();
                    break;
                case 8:
                    System.out.println("Enter serial number of product you want to buy");
                    serialNumber = scanner.nextLine();
                    mobileManagement.purchaseMobileAndCreateBill(serialNumber);
                    break;
                case 9:
                    mobileManagement.writeFile();
                    break;
                case 10:
                    mobileManagement.readFile();
                    break;
                case 0:
                    System.exit(0);
            }
        } while (true);

    }

    private static Mobile getInfoMobile() {
        System.out.println("Enter name of mobile");
        String name = scanner.nextLine();
        String serial;
        do {
            System.out.println("Enter serial number of mobile product");
            System.out.println("Start with IP/SS/VT and 3 or 4 randomly number from 0 to 9");
            serial = scanner.nextLine();
            if(!serial.matches(REGEX_SERIAL_NUMBER)){
                System.out.println("Invalid serial number");
            }
        } while (!serial.matches(REGEX_SERIAL_NUMBER));
        String color;
        do {
            System.out.println("Enter color of mobile product");
            color = scanner.nextLine();
            if(!color.matches(REGEX_COLOR)){
                System.err.println("Color is not allowed digit");
            }
        } while (!color.matches(REGEX_COLOR));
        String capacity;
        do {
            System.out.println("Enter capacity of mobile product +(gb)");
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
                return new Iphone(name, serial, color, capacity, price, quantity, versionIOS);
            } else if (kind.equalsIgnoreCase("Samsung")) {
                invalidKind = false;
                System.out.println("Enter version of Android");
                String versionAndroid = scanner.nextLine();
                return new Samsung(name, serial, color, capacity, price, quantity, versionAndroid);

            } else if (kind.equalsIgnoreCase("Vertu")) {
                invalidKind = false;
                System.out.println("Enter material of Vertu");
                String material = scanner.nextLine();
                return new Vertu(name, serial, color, capacity, price, quantity, material);
            }
            if (invalidKind) {
                System.err.println("Not support this product in list");
            }
        } while (invalidKind);
        return null;
    }

    private static void listMenu() {
        System.out.println("----------------------------");
        System.out.println("Menu");
        System.out.println("1.Add new mobile product to list");
        System.out.println("2.Find mobile product by Serial number");
        System.out.println("3.Edit info of product");
        System.out.println("4.Remove mobile product by Serial number");
        System.out.println("5.Show all mobile product in list ");
        System.out.println("6.Display mobile list by ordered price up");
        System.out.println("7.Display mobile list by ordered price down");
        System.out.println("8.Buy mobile");
        System.out.println("9.Write file");
        System.out.println("10.Read file");
        System.out.println("0.Exit");
        System.out.println("----------------------------");
        System.out.println("Enter your choice:");
    }

    private static final String REGEX_SERIAL_NUMBER = "^(IP|SS|VT)[\\d]{3,4}$";
    private static final String REGEX_COLOR = "^[A-Za-z]+[A-za-z]$";
    private static final String REGEX_CAPACITY = "^[\\d]{2,4}gb$";
}
