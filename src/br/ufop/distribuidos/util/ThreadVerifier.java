package br.ufop.distribuidos.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import br.ufop.distribuidos.proxy.Proxy;

public class ThreadVerifier{
	private ArrayList<Thread> threadWorker = new ArrayList<Thread>();
	
	public void FinishingThread() throws InterruptedException{
		for(int i=0;i<threadWorker.size();i++){
			if(!threadWorker.get(i).isAlive()){
				threadWorker.get(i).interrupt();
				threadWorker.get(i).join();
				threadWorker.remove(i);
				i--;
			}
		}
	}
	
	public void AddThread(Thread thread){
		thread.start();
		threadWorker.add(thread);
	}
}
