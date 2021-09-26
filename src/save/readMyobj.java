/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package save;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import org.omg.CORBA_2_3.portable.InputStream;

/**
 *
 * @author harmeshrana
 */
public class readMyobj {
    public static void main(String[] args) {
        try {
            FileInputStream f = new FileInputStream("/Users/harmeshrana/Desktop/objout.txt");
            ObjectInputStream i = new ObjectInputStream(f);
            Student s= (Student) i.readObject();
            System.out.println(s.getFirstName());
            System.out.println(s.getLastName());
            System.out.println(s.getAge());
        } catch (Exception e) {
        }

    }
    
}
