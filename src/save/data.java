/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package save;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
 
/**
 *
 * @author harmeshrana
 */
public class data {
 
    private static final String filepath="/Users/harmeshrana/Desktop/objout.txt";
 
    public static void main(String args[]) {
 
        data objectIO = new data();
 
        Student student = new Student("RAMAN","RANA",1337);
        objectIO.WriteObjectToFile(student);
    }
 
    public void WriteObjectToFile(Object serObj) {
 
        try {
 
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

