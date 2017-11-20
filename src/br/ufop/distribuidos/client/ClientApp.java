package br.ufop.distribuidos.client;

import java.util.concurrent.TimeUnit;

public class ClientApp {
	public static void main(String[] args) throws InterruptedException{
		long startTime = System.nanoTime();
		for(int i=0;i<10;i++){
			TimeUnit.MILLISECONDS.sleep(50);
			new Thread(new Client("127.0.0.1", 3366, i)).start();
		}

		long endTime = System.nanoTime();
		System.out.println("Took "+(endTime - startTime)/1000000 + "ms"); 
	}
}
