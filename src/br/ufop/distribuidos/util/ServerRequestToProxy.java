package br.ufop.distribuidos.util;

public class ServerRequestToProxy {
	private String ipServer;
	private int connectionPort;
	
	public ServerRequestToProxy(String ipServer, int connectionPort) {
		this.ipServer = ipServer;
		this.connectionPort = connectionPort;
	}

	public String getIpServer() {
		return ipServer;
	}

	public void setIpServer(String ipServer) {
		this.ipServer = ipServer;
	}

	public int getConnectionPort() {
		return connectionPort;
	}

	public void setConnectionPort(int connectionPort) {
		this.connectionPort = connectionPort;
	}	
}
