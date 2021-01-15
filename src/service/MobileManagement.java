package service;

import model.Iphone;
import model.Mobile;
import model.Samsung;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MobileManagement {
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

    public void removeMobileBySerialNumber(String serialNumber) {
        boolean notFound = true;
        for (int i = 0; i < mobileList.size(); i++) {
            if (mobileList.get(i).getSerialNumber().equalsIgnoreCase(serialNumber)) {
                notFound = false;
                mobileList.remove(i);
            }
        }
        if (notFound) {
            System.err.println("Not found mobile in list");
        }
    }

    public void sortMobileListByPriceUP() {
        Collections.sort(mobileList, ((o1, o2) -> {
            if (o1.getPrice() > o2.getPrice()) return 1;
            else if (o1.getPrice() < o2.getPrice()) return -1;
            else return 0;
        }));
        showAllList();
    }

    public void sortMobileListByPriceDOWN() {
        Collections.sort(mobileList, ((o1, o2) -> {
            if (o1.getPrice() > o2.getPrice()) return -1;
            else if (o1.getPrice() < o2.getPrice()) return 1;
            else return 0;
        }));
        showAllList();
    }

    public void purchaseMobileAndCreateBill(String serialNumber){
        boolean notFound = true;
        for (Mobile mobile : mobileList) {
            if (mobile.getSerialNumber().equalsIgnoreCase(serialNumber)) {
                System.out.println(mobile);
                notFound = false;
                if (mobile instanceof Iphone) {
                    Iphone objIP = (Iphone) mobile;
                    double totalBillIphone = objIP.countBill();
                    System.out.println(totalBillIphone);
                } else if (mobile instanceof Samsung) {
                    Samsung objSS = (Samsung) mobile;
                    double totalBillSamsung = objSS.countBill();
                    System.out.println("Total bill is "+totalBillSamsung);
                }
            }
        }
        if(notFound){
            System.err.println("Not found this product in list");
        }

    }

}
