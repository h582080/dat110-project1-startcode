package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class DisplayStub extends RPCLocalStub {
		
	private byte RPCIDDISPLAY = 2;
	
	public DisplayStub(RPCClient rpcclient) {
		super(rpcclient);
	}
	
	public void write (String message) {
				
		byte[] msgString = RPCUtils.marshallString(message);
		rpcclient.call(RPCIDDISPLAY, msgString);
		RPCUtils.unmarshallString(msgString);		
		
	}
}
