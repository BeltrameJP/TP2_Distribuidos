package br.ufop.distribuidos.proxy;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.ufop.distribuidos.util.ServerRequestToProxy;
import br.ufop.distribuidos.util.ThreadVerifier;

public class Proxy {

	private int connectionPort;
	private ServerSocket proxySocket;
	private Socket clientSocket;
	private LinkedList<ServerRequestToProxy> serverList;
	private static Proxy proxyInstance;
	private ThreadVerifier threadVerifier;
	
	private Proxy(int connectionPort){
		serverList = new LinkedList<ServerRequestToProxy>();
		this.connectionPort = connectionPort;
		threadVerifier = new ThreadVerifier();
		try {
			proxySocket = new ServerSocket(connectionPort);
		} catch (IOException e) {
			// TODO Auto-generated catch blocks
			e.printStackTrace();
		}
	}
	
	public static Proxy getInstance(int inicialize){
		if(proxyInstance == null){
			proxyInstance = new Proxy(inicialize);
		}
		return proxyInstance;
	}
	
	public void ProxyService() throws InterruptedException{
		try {
			while(true){
				System.out.println("Proxy: Waiting for Client");
				clientSocket = proxySocket.accept();
				System.out.println("New Connection with Client: " + clientSocket.getPort());
				threadVerifier.AddThread(new Thread(new ProxyWorkerThread(clientSocket, serverList.get(0))));
				serverList.addLast(serverList.removeFirst());
				threadVerifier.FinishingThread();				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void AddToServerList(ServerRequestToProxy serverRequestToProxy){
		serverList.add(serverRequestToProxy);
	}
	
	
	
}
