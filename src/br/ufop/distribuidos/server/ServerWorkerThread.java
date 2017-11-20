package br.ufop.distribuidos.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import br.ufop.distribuidos.util.PostalCode;
import br.ufop.distribuidos.util.PostalCodeManager;
import br.ufop.distribuidos.util.WorkerThreadForServer;

public class ServerWorkerThread extends WorkerThreadForServer{
	
	public PostalCodeManager postalCodeManager;
	
	public ServerWorkerThread(Socket clientSocket, PostalCodeManager postalCodeManager){
		this.clientSocket = clientSocket;
		this.postalCodeManager = postalCodeManager;
		try {
			outputClient = new ObjectOutputStream(clientSocket.getOutputStream());
			inputClient = new ObjectInputStream(clientSocket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		// TODO Auto-generated method stub
		try {
			PostalCode pc2 = (PostalCode) inputClient.readObject();
			if(!pc2.isPlaceNameInput()){
				pc2.setPostalCode(postalCodeManager.LatLongSearch(pc2.getLatitude(), pc2.getLongitude()));
			}else{
				pc2.setPostalCode(postalCodeManager.CitySearch(pc2.getPlaceName()));
			}
			outputClient.writeObject(pc2);
			outputClient.close();
			inputClient.close();
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
