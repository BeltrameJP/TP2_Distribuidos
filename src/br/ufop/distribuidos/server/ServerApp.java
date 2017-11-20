package br.ufop.distribuidos.server;

public class ServerApp {
	public static void main(String args[]){
		new Thread(new Server(6969)).start();
		new Thread(new Server(6970)).start();
		new Thread(new Server(6971)).start();
		new Thread(new Server(6972)).start();
		new Thread(new Server(6973)).start();
		new Thread(new Server(6974)).start();
	}
}
