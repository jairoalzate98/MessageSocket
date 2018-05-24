package comunication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import models.Node;

public class Client extends Thread {

	private Socket connection;
	private DataInputStream input;
	private DataOutputStream output;
	private boolean stop;
	private Node head;
	public final static Logger LOGGER = Logger.getGlobal();

	public Client() throws IOException {
		this.connection = new Socket("localhost", 9000);
		input = new DataInputStream(connection.getInputStream());
		output = new DataOutputStream(connection.getOutputStream());
		start();
	}

	@Override
	public void run() {
		while (!stop) {
			String response;
			try {
				response = input.readUTF();
				if (response != null) {
					manageResponse(response);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	private void manageResponse(String response) throws IOException {
		addNode(new Node(response));
		LOGGER.log(Level.INFO, "Mensaje Recibido" + response);
	}

	public Node getHead() {
		return head;
	}

	public void requestMessage(String message) throws IOException{
		output.writeUTF(message);
	}
	
	public void addNode(Node node){
		if (head != null) {
			node.setNextNode(head);
			head = node;
		}else{
			head = node;
		}
	}
	
}