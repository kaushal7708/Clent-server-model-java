package packett;
import packett.format;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;


public class Client1 
{
     format obj[];

    public Client1(format[] obj) {
        this.obj = obj;
    }
	public static void main(String[] args) 
	{
		try 
		{
			String rec_msg;
			String send_msg;
			
			Socket socket = new Socket("127.0.0.1", 4000);
			
			BufferedReader clientBuffer = new BufferedReader(new InputStreamReader(System.in));
			
			OutputStream out = socket.getOutputStream();
			
			PrintWriter writer = new PrintWriter(out, true);
			
			InputStream in = socket.getInputStream();
			
			BufferedReader serverBuffer = new BufferedReader(new InputStreamReader(in));
			
			while(true)
			{
			System.out.println("You : ");
			send_msg=clientBuffer.readLine();

			writer.println(send_msg);

			if((rec_msg=serverBuffer.readLine())!=null)
			{
				System.out.println("From Server : " +rec_msg);
			}
			}
//			socket.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}
