package exo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		if(args.length != 2){
			System.err.println("Usage: java " + Client.class.getName() + " host port");	
			System.exit(1);
		}

		int port = Integer.parseInt(args[1]);
		final InetAddress server = InetAddress.getByName(args[0]); 

		DatagramSocket datagramSocket = new DatagramSocket();

		Scanner sc = new Scanner(System.in);
		byte buf[] = new byte [1024];
		
		while(true){
			
			//envoie
			datagramSocket = new DatagramSocket();
			sc = new Scanner(System.in);
			System.out.print(">");
			buf = sc.nextLine().getBytes();
			if((new String(buf)).equals("clientquit")){
				System.exit(0);
			}
			datagramSocket.send(new DatagramPacket(buf, buf.length, server, port));
			
			//recevoir
			if(!(new String(buf)).equals("serverquit")){
				buf = new byte [1024];
				//DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
				//datagramSocket.receive(datagramPacket);
				datagramSocket.receive(new DatagramPacket(buf, buf.length));
				System.out.println(new String(buf));
			}			
		}
	}

}
