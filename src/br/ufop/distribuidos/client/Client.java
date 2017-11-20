package br.ufop.distribuidos.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import br.ufop.distribuidos.util.PostalCode;

public class Client implements Runnable {

	private Socket serverSocket;
	private ObjectOutputStream outputServer;
	private ObjectInputStream inputServer;
	private Object flagObj;
	private int idClient;
	
	public Client(String ipServer, int socketNumber, int idClient){
		this.setIdClient(idClient);
		try {
			serverSocket = new Socket(ipServer, socketNumber);
			inputServer = new ObjectInputStream(serverSocket.getInputStream());
			outputServer = new ObjectOutputStream(serverSocket.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PostalCode SendMessage(PostalCode pcObj){
		try {
			outputServer.writeObject(pcObj);
			return (PostalCode) inputServer.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void run() {
		// TODO Auto-generated method stub
		SendMessage(new PostalCode(-3.15, -19.34));
		return;
	}

	public Object getFlagObj() {
		return flagObj;
	}

	public void setFlagObj(Object flagObj) {
		this.flagObj = flagObj;
	}

	public int getIdClient() {
		return idClient;
	}

	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}
}
