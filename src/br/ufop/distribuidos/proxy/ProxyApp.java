package br.ufop.distribuidos.proxy;

import br.ufop.distribuidos.util.ServerRequestToProxy;

public class ProxyApp {
	public static void main(String[] args) throws InterruptedException{
		Proxy proxy = Proxy.getInstance(3366);
		proxy.AddToServerList(new ServerRequestToProxy("127.0.0.1", 6969));
		proxy.AddToServerList(new ServerRequestToProxy("127.0.0.1", 6970));
		proxy.AddToServerList(new ServerRequestToProxy("127.0.0.1", 6971));
		proxy.AddToServerList(new ServerRequestToProxy("127.0.0.1", 6972));
		proxy.AddToServerList(new ServerRequestToProxy("127.0.0.1", 6973));
		proxy.AddToServerList(new ServerRequestToProxy("127.0.0.1", 6974));
		proxy.ProxyService();
	}
}
