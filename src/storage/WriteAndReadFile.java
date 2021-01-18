package storage;

import model.Mobile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriteAndReadFile {
    public static void writeObjectToFile(List<Mobile> objectList, String filepath) {
        try {
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (int i = 0; i < objectList.size(); i++) {
                objectOut.writeObject(objectList.get(i));
            }
            objectOut.close();
            fileOut.close();
        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public static List<Mobile> readFromFile(String filepath) {
        List<Mobile> result=new ArrayList<>();
        Mobile obj = null;
        try {
            File file=new File(filepath);
            FileInputStream fileIn = new FileInputStream(filepath);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            while ((obj=(Mobile) objectIn.readObject())!=null){
                result.add(obj);
            }
            objectIn.close();
            fileIn.close();
        } catch (Exception ex) {
        }
        return result;
    }
}
