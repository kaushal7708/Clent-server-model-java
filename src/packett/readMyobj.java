package packett;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;

public class readMyobj {

    public static void main(String[] args) {
        try {
           // BufferedReader bfReader = null;
            FileInputStream f = new FileInputStream("/Users/harmeshrana/Desktop/objoute.txt");
            ObjectInputStream i = new ObjectInputStream(f);


            format fs[] = (format[]) i.readObject();
            System.out.println(fs[1].payload[0]);
           // File ff=new File();
//            InputStream inputStream = new FileInputStream("/Users/harmeshrana/Desktop/objoute.txt");
//            InputStreamReader isReader = new InputStreamReader(inputStream);
//           BufferedReader reader = new BufferedReader(isReader);
//            StringBuffer sb = new StringBuffer();
//      String str;
//      while((str = reader.readLine())!= null){
//         sb.append(str);
//      }
//      System.out.println(sb.toString());
            
            
            
            
        } catch (Exception e) {
        }

    }

}
