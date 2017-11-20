package br.ufop.distribuidos.server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import br.ufop.distribuidos.util.PostalCodeManager;
import br.ufop.distribuidos.util.ThreadVerifier;

public class Server implements Runnable{
	
	private int connectionPort;
	private ServerSocket serverSocket;
	private Socket clientSocket;
	private PostalCodeManager postalCodeManager;
	private ThreadVerifier threadVerifier;
	
	public Server(int connectionPort){
		this.setConnectionPort(connectionPort);
		postalCodeManager = new PostalCodeManager();
		postalCodeManager.ReadCsvFromFile();
		threadVerifier = new ThreadVerifier();
	}
	
	private void Service() throws InterruptedException{
		try {
			while(true){
				clientSocket = serverSocket.accept();
				System.out.println("Server : " + serverSocket.getLocalPort() + " New Connection with Client: " + clientSocket.getPort());
				threadVerifier.AddThread((new Thread(new ServerWorkerThread(clientSocket, postalCodeManager))));
				threadVerifier.FinishingThread();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int getConnectionPort() {
		return connectionPort;
	}

	public void setConnectionPort(int connectionPort) {
		this.connectionPort = connectionPort;
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			serverSocket = new ServerSocket(connectionPort);
			System.out.println("Server Running!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Service();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return;
	}
	
	
}
