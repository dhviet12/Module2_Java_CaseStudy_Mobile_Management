package service;

import model.Iphone;
import model.Mobile;
import model.Samsung;
import model.Vertu;
import storage.WriteAndReadFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class MobileManagement {
    private static final String FILE_PATH = "manager.dat";
    private List<Mobile> mobileList = new ArrayList<>();

    public void addMobile(Mobile mobile) {
        this.readFile();
        mobileList.add(mobile);
        this.writeFile();
    }


    public void showAllList() {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s"
                , "Name mobile"
                , "Serial number"
                , "Color"
                , "Capacity"
                , "Suggested Price"
                , "Quantity"
                , "IOS version"
                , "Android version"
                , "Material skin"
        );
        for (Mobile mobile : mobileList) {
            if (mobile instanceof Iphone) {
                Iphone objIP = (Iphone) mobile;
                System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s"
                        , objIP.getName()
                        , objIP.getSerialNumber()
                        , objIP.getColor()
                        , objIP.getCapacity()
                        , objIP.getSuggestedPrice()
                        , objIP.getQuantity()
                        , objIP.getIosVersion() + "\n");
            } else if (mobile instanceof Samsung) {
                Samsung objSS = (Samsung) mobile;
                System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s"
                        , objSS.getName()
                        , objSS.getSerialNumber()
                        , objSS.getColor()
                        , objSS.getCapacity()
                        , objSS.getSuggestedPrice()
                        , objSS.getQuantity()
                        ,""
                        , objSS.getAndroidVersion() + "\n");
            } else if (mobile instanceof Vertu) {
                Vertu objVT = (Vertu) mobile;
                System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s%-20s"
                        , objVT.getName()
                        , objVT.getSerialNumber()
                        , objVT.getColor()
                        , objVT.getCapacity()
                        , objVT.getSuggestedPrice()
                        , objVT.getQuantity()
                        ,""
                        ,""
                        , objVT.getMaterial() + "\n");
            }
        }
    }

    public void findMobileBySerialNumber(String serialNumber) {
        boolean notFound = true;
        for (Mobile mobile : mobileList) {
            if (mobile.getSerialNumber().equalsIgnoreCase(serialNumber)) {
                notFound = false;
                showAllList();
            }
        }
        if (notFound) {
            System.err.println("Not found mobile in list");
        }
    }

    public void editMobileBySerialNumber(String serialNumber, Mobile mobile) {
        boolean notFound = true;
        for (int i = 0; i < mobileList.size(); i++) {
            if (mobileList.get(i).getSerialNumber().equalsIgnoreCase(serialNumber)) {
                notFound = false;
                mobileList.set(i, mobile);
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
                System.out.println("Successfully removed");
            }
        }
        if (notFound) {
            System.err.println("Not found mobile in list");
        }
    }

    public void sortMobileListByPriceUP() {
        mobileList.sort(((o1, o2) -> {
            if (o1.getSuggestedPrice() > o2.getSuggestedPrice()) return 1;
            else if (o1.getSuggestedPrice() < o2.getSuggestedPrice()) return -1;
            else return 0;
        }));
    }

    public void sortMobileListByPriceDOWN() {
        Collections.sort(mobileList, new Comparator<Mobile>() {
            @Override
            public int compare(Mobile o1, Mobile o2) {
                if (o1.getSuggestedPrice() > o2.getSuggestedPrice()) {
                    return -1;
                } else if (o1.getSuggestedPrice() < o2.getSuggestedPrice()) {
                    return 1;
                } else return 0;
            }
        });
    }

    public void purchaseMobileAndCreateBill(String serialNumber) {
        boolean notFound = true;
        for (Mobile mobile : mobileList) {
            if (mobile.getSerialNumber().equalsIgnoreCase(serialNumber)) {
                notFound = false;
                if (mobile instanceof Iphone) {
                    Iphone objIP = (Iphone) mobile;
                    double totalBillIphone = objIP.countBill();
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s"
                            , "Name mobile"
                            , "Serial number"
                            , "Color"
                            , "Capacity"
                            , "Suggested Price"
                            , "Quantity"
                            , "Total bill");
                    System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s"
                            , objIP.getName()
                            , objIP.getSerialNumber()
                            , objIP.getColor()
                            , objIP.getCapacity()
                            , objIP.getSuggestedPrice()
                            , objIP.getQuantity()
                            , totalBillIphone);

                } else if (mobile instanceof Samsung) {
                    Samsung objSS = (Samsung) mobile;
                    double totalBillSamsung = objSS.countBill();
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s"
                            , "Name mobile"
                            , "Serial number"
                            , "Color"
                            , "Capacity"
                            , "Suggested Price"
                            , "Quantity"
                            , "Total bill");
                    System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s"
                            , objSS.getName()
                            , objSS.getSerialNumber()
                            , objSS.getColor()
                            , objSS.getCapacity()
                            , objSS.getSuggestedPrice()
                            , objSS.getQuantity()
                            , totalBillSamsung);

                } else if (mobile instanceof Vertu) {
                    Vertu objVertu = (Vertu) mobile;
                    double totalBillVertu = objVertu.countBill();
                    System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%-20s"
                            , "Name mobile"
                            , "Serial number"
                            , "Color"
                            , "Capacity"
                            , "Suggested Price"
                            , "Quantity"
                            , "Total bill");
                    System.out.printf("\n%-20s%-20s%-20s%-20s%-20s%-20s%-20s"
                            , objVertu.getName()
                            , objVertu.getSerialNumber()
                            , objVertu.getColor()
                            , objVertu.getCapacity()
                            , objVertu.getSuggestedPrice()
                            , objVertu.getQuantity()
                            , totalBillVertu);
                }
            }
        }
        if (notFound) {
            System.err.println("Not found this product in list");
        }
    }

    public void writeFile() {
        WriteAndReadFile.writeObjectToFile(FILE_PATH, mobileList);
    }

    public void readFile() {
        mobileList = (List<Mobile>) WriteAndReadFile.readObjectFromFile(FILE_PATH);
    }
}
