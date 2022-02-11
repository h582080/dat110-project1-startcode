package no.hvl.dat110.system.controller;

import no.hvl.dat110.TODO;
import no.hvl.dat110.rpc.*;

public class SensorStub extends RPCLocalStub {

	private byte RPCIDREAD = 1;
	
	public SensorStub(RPCClient rpcclient) {
		super(rpcclient);
	}
	
	public int read() {
		
		int temp = 0;
		
		
		byte[] tempInt = RPCUtils.marshallInteger(temp);
		
		rpcclient.call(RPCIDREAD, tempInt);
		
		temp = RPCUtils.unmarshallInteger(tempInt);
		
		return temp;
	}
	
}
