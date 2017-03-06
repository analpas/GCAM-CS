package exo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
	public static void main(String[] args) throws IOException {
		if( args.length != 1 ){
			System.err.println("Usage: java " + Server.class.getName() + " port");
			System.exit(1);
		}
		int port = Integer.parseInt(args[0]);
		String bufString = "";

		DatagramSocket datagramSocket = new DatagramSocket(port);
		int packetLength = 0;
		while(true){
			byte buf[] = new byte [1024];


			DatagramPacket datagramPacket = new DatagramPacket(buf, buf.length);
			datagramSocket.receive(datagramPacket);
			bufString = new String(buf);
			packetLength = datagramPacket.getLength();
			if (bufString.contains("serverquit") && packetLength == 10) {
				datagramSocket.close();
				System.exit(0);
			}
			//	System.out.println(bufString);
			//	renvoyer message au client 
			datagramSocket.send(datagramPacket);
			//	END: renvoyer message au client 		
		}
	}
}
