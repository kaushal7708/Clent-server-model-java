
package packett;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;

public class data {
 
    private static final String filepath="/Users/harmeshrana/Desktop/objoute.txt";
    BufferedReader bfReader = null;
 
    public static void main(String args[]) {
 
      
    }
 
    public void WriteObjectToFile(Object serObj) {
        
        try {
 
            FileOutputStream fileOut = new FileOutputStream(filepath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
//            FileOutputStream

             //FileInputStream f = new FileInputStream("/Users/harmeshrana/Desktop/objoute.txt");
//                File file = new File("/Users/harmeshrana/Desktop/objoute.txt");
//                     FileWriter   fileWriter=new FileWriter(file);
//			BufferedWriter bufferedWriter =new BufferedWriter(fileWriter); 
//                        bfReader = new BufferedReader(new InputStreamReader(f));
                     //  BufferedReader b=new BufferedReader(filepath);  
            objectOut.close();
            System.out.println("The Object  was succesfully written to a file");

           
 
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}