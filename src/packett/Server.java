package packett;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
format serobj[];
//String ip1,ip2;
    public void  runServer() throws IOException, ClassNotFoundException{
         
      ServerSocket ss = new ServerSocket(7777);
      while(true){
      System.out.println("ServerSocket awaiting connections...");
        Socket socket = ss.accept();
        System.out.println("Connection from " + socket + "!");
        InputStream inputStream = socket.getInputStream();
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        serobj=(format[]) objectInputStream.readObject();
        System.out.println("obj len="+serobj.length);
        print();
        new data().WriteObjectToFile(serobj);
          System.out.println("wirte suu");

      }
      
     
        
    }
    public void print(){
    for(int i=0;i<serobj.length;i++){

System.out.println("Packet :-");
        System.out.println("Packet Count : "+serobj[i].packetcount);
        try {
            
            String ip1;
            ip1 = new String(serobj[i].sourceip, "UTF-8");
            System.out.println("Source ip : "+ip1.trim());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            
        }
        try {
            String ip2;
            ip2 = new String(serobj[i].destinationip, "UTF-8");
            System.out.println("Destination ip : "+ip2.trim());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println("Payload : " + serobj[i].payload[i]);
        System.out.println("Packet id : "+serobj[i].packetid);
    }
          
          System.out.println("NEW PACKET");
      }
    



    public static void main(String[] args) throws ClassNotFoundException, IOException {
        
    
       Server s=new Server();
       s.runServer();
       s.print();
      
    
    }
}
