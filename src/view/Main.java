package view;

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
        System.out.println("Enter serial number of mobile product");
        String serial = scanner.nextLine();
        System.out.println("Enter color of mobile product");
        String color = scanner.nextLine();
        System.out.println("Enter capacity of mobile product");
        String capacity = scanner.nextLine();
        System.out.println("Enter suggested price of mobile product");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Enter quantity of mobile product");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter model of mobile Iphone/Samsung");
        boolean invalidKind = true;
        do {
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
            } if(invalidKind){
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
}
