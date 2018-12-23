/*
 * Java Assessment Sockets
 * by: Valdar Rudman
 * Student ID: R00081134
 */

package main;

import rmiConnection.RMIServer;

/**
 * main method class
 * @author valdar
 *
 */
public class Main {
	
	private final static String path = "rmi/server";
	
	public static void main(String[] args) {
		
		// Starting our server
		RMIServer s = new RMIServer(path);
		s.runServer();
		
	}

}
