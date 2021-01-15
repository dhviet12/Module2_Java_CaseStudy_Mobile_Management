package Manager;

import Model.Mobile;

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
        if(notFound){
            System.err.println("Not found mobile in list");
        }
    }
public List<Mobile> sortMobileListByPriceUP(){
    Collections.sort(mobileList,((o1, o2) -> {
        if(o1.getPrice() > o2.getPrice()) return 1;
        else if(o1.getPrice() < o2.getPrice()) return -1;
        else return 0;
    }));
    return mobileList;
}




}
