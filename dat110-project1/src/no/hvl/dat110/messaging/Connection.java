package no.hvl.dat110.messaging;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import no.hvl.dat110.TODO;


public class Connection {

	private DataOutputStream outStream; // for writing bytes to the TCP connection
	private DataInputStream inStream; // for reading bytes from the TCP connection
	private Socket socket; // socket for the underlying TCP connection
	
	public Connection(Socket socket) {

		try {

			this.socket = socket;

			outStream = new DataOutputStream(socket.getOutputStream());

			inStream = new DataInputStream (socket.getInputStream());

		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}

	public void send(Message message) {
			
			byte[] data = message.getData();
			
			try {				
	
				outStream.write(data);
				
				outStream.close();
				
				socket.close();
						
			} catch (IOException ex){
				System.out.println("TCP client: " + ex.getMessage());
				ex.printStackTrace();
				System.exit(1);
			}
			
			// TODO - START
			// encapsulate the data contained in the message and write to the output stream
			
		
			// TODO - END

	}



	public Message receive() {

		Message message = null;
		byte[] data = new byte[128];
		
		try {
			
			System.out.print("TCP Receiver starting");
			
		    System.out.println("TCP Receiver reading");
		    inStream.read(data);
		    
		    System.out.print("TCP Receiver received: ");
		    for (byte b : data) {
		    	System.out.print((byte) b);
		    }
		    System.out.println();
		    
		    inStream.close();
		    
		    socket.close();
		    	    
			
		} catch (IOException ex) {

			System.out.println("TCPServer: " + ex.getMessage());
			ex.printStackTrace();
			System.exit(1);

		}
		System.out.println("TCP Receiver stopping");
		
		// TODO - START
		// read a segment from the input stream and decapsulate into message
		

		// TODO - END
		
		return message;
		
	}

	// close the connection by closing streams and the underlying socket	
	public void close() {

		try {
			
			outStream.close();
			inStream.close();

			socket.close();
			
		} catch (IOException ex) {

			System.out.println("Connection: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
}