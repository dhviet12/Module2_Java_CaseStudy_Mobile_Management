package service;

import model.Iphone;
import model.Mobile;
import model.Samsung;
import model.Vertu;
import storage.WriteAndReadFile;

import java.util.ArrayList;
import java.util.List;


public class MobileManagement {
    private static final String FILE_PATH = "manager.dat";
    private List<Mobile> mobileList = new ArrayList<>();

    public void addMobile(Mobile mobile) {
        mobileList.add(mobile);
    }

    public void showAllList() {
        for (Mobile mobile : mobileList) {
            System.out.println(mobile);
        }
    }

    public void findMobileBySerialNumber(String serialNumber) {
        boolean notFound = true;
        for (Mobile mobile : mobileList) {
            if (mobile.getSerialNumber().equalsIgnoreCase(serialNumber)) {
                notFound = false;
                System.out.println(mobile);
            }
        }
        if (notFound) {
            System.err.println("Not found mobile in list");
        }
    }
    public void editMobileBySerialNumber(String serialNumber, Mobile mobile){
        boolean notFound = true;
        for (int i = 0; i < mobileList.size(); i++) {
            if(mobileList.get(i).getSerialNumber().equalsIgnoreCase(serialNumber)){
                notFound = false;
                mobileList.set(i, mobile);
            }
        }
        if(notFound){
            System.err.println("Not found mobile in list");
        }
    }

    public void removeMobileBySerialNumber(String serialNumber) {
        boolean notFound = true;
        for (int i = 0; i < mobileList.size(); i++) {
            if (mobileList.get(i).getSerialNumber().equalsIgnoreCase(serialNumber)) {
                notFound = false;
                mobileList.remove(i);
                System.out.println("Successfully removed");
            }
        }
        if (notFound) {
            System.err.println("Not found mobile in list");
        }
        WriteAndReadFile.writeObjectToFile(mobileList, FILE_PATH);
    }

    public void sortMobileListByPriceUP() {
        mobileList.sort(((o1, o2) -> {
            if (o1.getSuggestedPrice() > o2.getSuggestedPrice()) return 1;
            else if (o1.getSuggestedPrice() < o2.getSuggestedPrice()) return -1;
            else return 0;
        }));
        showAllList();
    }

    public void sortMobileListByPriceDOWN() {
        mobileList.sort(((o1, o2) -> {
            if (o1.getSuggestedPrice() > o2.getSuggestedPrice()) return -1;
            else if (o1.getSuggestedPrice() < o2.getSuggestedPrice()) return 1;
            else return 0;
        }));
        showAllList();
    }

    public void purchaseMobileAndCreateBill(String serialNumber) {
        boolean notFound = true;
        for (Mobile mobile : mobileList) {
            if (mobile.getSerialNumber().equalsIgnoreCase(serialNumber)) {
                System.out.println(mobile);
                notFound = false;
                if (mobile instanceof Iphone) {
                    Iphone objIP = (Iphone) mobile;
                    double totalBillIphone = objIP.countBill();
                    System.out.println("Total bill for this product is " + totalBillIphone);
                } else if (mobile instanceof Samsung) {
                    Samsung objSS = (Samsung) mobile;
                    double totalBillSamsung = objSS.countBill();
                    System.out.println("Total bill for this product is " + totalBillSamsung);
                } else if(mobile instanceof Vertu){
                    Vertu objVertu = (Vertu) mobile;
                    double totalBillVertu = objVertu.countBill();
                    System.out.println("Total bill for this product is " + totalBillVertu);
                }
            }
        }
        if (notFound) {
            System.err.println("Not found this product in list");
        }
    }

    public void writeFile() {
        WriteAndReadFile.writeObjectToFile(mobileList, FILE_PATH);
    }

    public void readFile() {
        mobileList = (List<Mobile>) WriteAndReadFile.readFromFile(FILE_PATH);
    }
}
