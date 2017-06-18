package net.frank.cheer.demo.ch19;

import java.net.InetAddress;

public class InetAddressTest {
	
	public static void main(String[] args) throws Exception{
		
		InetAddress local = InetAddress.getLocalHost();
		
		System.out.println(local.getHostName());
		System.out.println(local.getHostAddress());
		
		InetAddress remoteLiujian = InetAddress.getByName("VA9SDNDJSUEZ1P6");
		System.out.println(remoteLiujian.getHostAddress());
		

	}

}
