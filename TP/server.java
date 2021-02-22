	import java.io.ObjectInputStream;
	import java.io.ObjectOutputStream;
	import java.io.IOException;
	import java.net.ServerSocket;
	import java.net.Socket;
	import java.util.Scanner;
	import java.util.logging.Level;
	import java.util.logging.Logger;
	
	public class server 
	{
		public static void main(String args[])
		{
			try 
			{
				ServerSocket serverc = new ServerSocket(5050);
				System.out.println("Servidor iniciado na porta 5050");
				Socket cliente = serverc.accept();
				System.out.println("Cliente conectado do IP "+cliente.getInetAddress().
				getHostAddress());
				Scanner entrada = new Scanner(cliente.getInputStream());
				while(entrada.hasNextLine())
				{
					
					System.out.println(entrada.nextLine());
				}
				
				entrada.close();
				serverc.close();
			}
			catch (IOException ex)
			{
				Logger.getLogger(server.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}