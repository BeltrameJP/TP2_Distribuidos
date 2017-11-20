package br.ufop.distribuidos.util;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public abstract class WorkerThreadForServer implements Runnable{

	protected Socket clientSocket;
	protected ObjectOutputStream outputClient;
	protected ObjectInputStream inputClient;

}
