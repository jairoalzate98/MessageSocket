package comunication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;

public class ThreadSocket extends Thread{


	private Socket connection;
	private DataInputStream input;
	private DataOutputStream output;
	private boolean stop;
	private Server server;

	public ThreadSocket(Socket socket, Server server) throws IOException {
		this.connection = socket;
		this.server = server;
		input = new DataInputStream(socket.getInputStream());
		output = new DataOutputStream(socket.getOutputStream());
		start();
	}

	@Override
	public void run() {
		while (!stop) {
			String request;
			try {
				request = input.readUTF();
				System.out.println(request);
				if (request != null) {
					manageRequest(request);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void send(String message) throws IOException{
		output.writeUTF(message);
	}

	private void manageRequest(String request) throws IOException {
		Server.LOGGER.log(Level.INFO, "Request: " + connection.getInetAddress().getHostAddress() + " - " + request);
		server.sendMessages(request);
		Server.LOGGER.log(Level.INFO, "Conexion con: " + connection.getInetAddress().getHostAddress() + " cerrada.");
	}
	
	@Override
	public String toString() {
		return connection.getInetAddress().getHostAddress();
	}
}
