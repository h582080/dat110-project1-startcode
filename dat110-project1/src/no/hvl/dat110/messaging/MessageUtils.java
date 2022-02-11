package no.hvl.dat110.messaging;

import no.hvl.dat110.TODO;

public class MessageUtils {

	public static final int SEGMENTSIZE = 128;

	public static final int MESSAGINGPORT = 8080;
	public static final String MESSAGINGHOST = "localhost";
	
	public static byte[] encapsulate(Message message) {
		
		byte[] data = message.getData();
		byte[] segment = new byte[data.length];
		
		
		for (int i = 0; i<data.length; i++) {
			segment[i] = data[i];
		}
		// TODO - START
		
		// encapulate/encode the payload data of the message and form a segment
		// according to the segment format for the messagin layer

		// TODO - END
		return segment;
		
	}

	public static Message decapsulate(byte[] segment) {

		Message message = new Message(segment);
		
		// TODO - START
		// decapsulate segment and put received data into a message
		// TODO - END
		
		return message;
		
	}
	
}
