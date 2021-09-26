package packett;



import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {

    format obj[];

    public Client(format[] obj) {
        this.obj = obj;
    }

  
    

    public void start() throws IOException  {
       
        Socket socket = new Socket("localhost", 7777);
        System.out.println("Connected!");
         OutputStream outputStream = socket.getOutputStream();
         ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(obj);
        
          
          
       //System.out.println("Closing socket and terminating program.");
       // socket.close();
      
    }

    public static void main(String[] args) throws UnknownHostException,
            IOException, ClassNotFoundException {
        

    }
}
