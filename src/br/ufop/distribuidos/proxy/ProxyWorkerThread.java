package br.ufop.distribuidos.proxy;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import br.ufop.distribuidos.util.ServerRequestToProxy;
import br.ufop.distribuidos.util.WorkerThreadForServer;

public class ProxyWorkerThread  extends WorkerThreadForServer{

	private ObjectInputStream inputServer;
	private ObjectOutputStream outputServer;
	private Socket serverSocket;
	private ServerRequestToProxy serverRequestToProxy;
	
	public ProxyWorkerThread(Socket clientSocket, ServerRequestToProxy serverRequestToProxy){
		this.clientSocket = clientSocket;
		this.serverRequestToProxy = serverRequestToProxy;
		try{
			this.serverSocket = new Socket(serverRequestToProxy.getIpServer(), serverRequestToProxy.getConnectionPort());
			outputClient = new ObjectOutputStream(clientSocket.getOutputStream());
			inputClient = new ObjectInputStream(clientSocket.getInputStream());
			inputServer = new ObjectInputStream(serverSocket.getInputStream());
			outputServer = new ObjectOutputStream(serverSocket.getOutputStream());
		}catch(Exception e){
			
		}
	}
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			outputServer.writeObject(inputClient.readObject());
			outputClient.writeObject(inputServer.readObject());
			outputClient.close();
			outputServer.close();
			return;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
