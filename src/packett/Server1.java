package packett;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 
{
	public static void main(String[] args) 
	{
		
		
		try 
		{
			String rec_msg;
			String send_msg;
			
			ServerSocket sSocket = new ServerSocket(4000);
			Socket socket = sSocket.accept();
			
			BufferedReader serverBuffer = new BufferedReader(new InputStreamReader(System.in));
			
			OutputStream out = socket.getOutputStream();
			
			PrintWriter writer = new PrintWriter(out, true);
			
			InputStream in = socket.getInputStream();
			
			BufferedReader clientBuffer = new BufferedReader(new InputStreamReader(in));
			
			while(true)
			{
			if((rec_msg=clientBuffer.readLine())!=null)
			{
				System.out.println("From Client : " +rec_msg);
				
				System.out.println("You : ");
				send_msg=serverBuffer.readLine();
				
				writer.println(send_msg);
			}
			}
//			socket.close();
//			sSocket.close();
		}
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
	}
}
