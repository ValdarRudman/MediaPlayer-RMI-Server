package rmiConnection;

import java.io.File;
import java.io.IOException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

import monitor.FileShare;
import monitor.Monitor;

/**
 * RMI server
 * @author valdar
 *
 */
public class RMIServer {

	//port number for server
	private final int PORT_NUMBER = 5555;
	
	private FileShare monitor;
	
	/*
	 * Create a server socket that takes a monitor object
	 */
	public RMIServer(String path) {
		
		File f = new File(path);
		
		if(!f.exists())
			f.mkdirs();
		
		this.monitor = new Monitor(path);
		
	}
	
	/*
	 * Start server
	 */
	public void runServer() {
		
		try {
			
			FileShare stub = (FileShare) UnicastRemoteObject.exportObject(monitor, 0);
			
			//start server
			Registry reg = LocateRegistry.createRegistry(PORT_NUMBER);
			reg.rebind("Monitor", stub);
			
			System.out.println("Server Running on port: " + PORT_NUMBER);
			
		}
		catch(IOException e) {
			
			System.out.println(e.getMessage());
			
		}
		
		/*
		 * starts a thread that will check the servers folder and update observers
		 */
	/*	new Thread(new Runnable() {

			@Override
			public void run() {

				while(true) {

					if(!Arrays.equals(monitor.getFiles(), files)) {

						files = monitor.getFiles();
						setChanged();
						notifyObservers(files);

						try {
							
							Thread.sleep(500);
							
						} catch (InterruptedException e) {
			
							e.printStackTrace();
						}
						
					}
					
					
				}
				
			}
		
		}).start();*/
		
	}
	
}