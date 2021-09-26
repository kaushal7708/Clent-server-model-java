
package packett;


import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author harmeshrana
 */
public class format implements Serializable{

   public byte packetid;
   public byte[] sourceip = new byte[16];
   public byte[] destinationip = new byte[16];
   public byte packetcount;
   public byte active;
   public byte[] payload;
    
   public static final String ipregex
            = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
            + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
            + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
            + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";

    private static final Pattern ipregexpt = Pattern.compile(ipregex);

    public format(String file){
        RandomAccessFile ff;
        try {
            ff = new RandomAccessFile(file, "r");
         
        payload = new byte[ (int) ff.length()];
        } catch (Exception ex) {
            System.out.println(ex+"\t lenght problem"); Logger.getLogger(format.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    public static boolean isValidInet4Address(String ip) {
        if (ip == null) {
            return false;
        }

        Matcher mtch = ipregexpt.matcher(ip);

        return mtch.matches();
    }
}


