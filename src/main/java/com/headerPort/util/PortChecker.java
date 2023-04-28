package com.headerPort.util;

import java.io.IOException;
import java.net.ServerSocket;


public class PortChecker {
	
	public static boolean checkPortIsAvailable(int portNumber) {
		
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(portNumber);
			serverSocket.setReuseAddress(true);
			
			return true;
		
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}

}
