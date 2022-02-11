package no.hvl.dat110.rpc;

import no.hvl.dat110.TODO;
import no.hvl.dat110.messaging.*;

public class RPCClient {

	private MessagingClient msgclient;
	private Connection connection;
	
	public RPCClient(String server, int port) {
	
		msgclient = new MessagingClient(server,port);
	}
	
	public void connect() {
		
		msgclient.connect();
	}
	
	public void disconnect() {
		
		connection.close();
	}
	
	public byte[] call(byte rpcid, byte[] params) {
		
		byte[] returnval = new byte[params.length+1];
		
		returnval[0] = rpcid;
	    
		for(int i=0; i<=params.length; i++) {
			returnval[i+1] = params[i];
		}			
		
		return returnval;
		
	}

}
