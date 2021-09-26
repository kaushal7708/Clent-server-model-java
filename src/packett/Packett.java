package packett;

import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;
import java.lang.Math;
import java.io.IOException;
import packett.Client;

public class Packett {

    format oo[];
    int y;
static String str ="/Users/harmeshrana/Desktop/mainn.txt";
    public void packetlen(int x) {
        y = x;

        System.out.println(y);
        oo = new format[y];
    }

    void cpy(format t, int n) {

        for (int i = n; i < n + 1; i++) {
            oo[i] = new format(str);
            oo[i].packetid = t.packetid;
            oo[i].packetcount = t.packetcount;
            oo[i].destinationip = t.destinationip;
            oo[i].sourceip = t.sourceip;
            oo[i].payload = t.payload;
            oo[i].active = 1;
        }

    }

    void prnt(int i) {

        System.out.println("Packet :-");
        System.out.println("Packet Count : " + oo[i].packetcount);
        try {

            String ip1;
            ip1 = new String(oo[i].sourceip, "UTF-8");
            System.out.println("Source ip : " + ip1.trim());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();

        }
        try {
            String ip2;
            ip2 = new String(oo[i].destinationip, "UTF-8");
            System.out.println("Destination ip : " + ip2.trim());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("Payload : " + oo[i].payload[i]);
        System.out.println("Packet id : " + oo[i].packetid);
    }

    public static void main(String[] args) throws IOException {
        try {
            Packett p = new Packett();
            
            RandomAccessFile ff = new RandomAccessFile(str, "r");
            byte[] b = new byte[(int) ff.length()];
            p.packetlen(b.length);
            ff.readFully(b);

            double a = Math.random() * 30;
            byte by = (byte) a;
            format f = new format(str);
            f.packetid = by;

            Scanner sc = new Scanner(System.in);

            System.out.println("Enter Source ip");
            String sip = sc.next();

            boolean sipmt = f.isValidInet4Address(sip);
            if (sipmt == true) {
                byte sid[] = sip.getBytes("UTF-8");
                for (int i = 0; i < sid.length; i++) {
                    f.sourceip[i] = sid[i];
                }

            } else {
                System.out.println("enter valid ip");
            }

            System.out.println("Enter destination ip");

            String dip = sc.next();
            boolean dipmt = f.isValidInet4Address(dip);
            if (dipmt == true) {
                byte did[] = dip.getBytes("UTF-8");
                for (int i = 0; i < did.length; i++) {

                    f.destinationip[i] = did[i];
                }
            } else {
                System.out.println("enter valid ip");
            }

            System.out.println("Reading the data from file");

            for (int i = 0; i < b.length; i++) {
                f.packetcount = (byte) i;
                f.payload[i] = b[i];
                p.cpy(f, i);
            }
            //  p.prnt(0);

            Client c = new Client(p.oo);
            c.start();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
