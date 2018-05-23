package comunication;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client extends Thread {

	private Socket connection;
	private DataInputStream input;
	private DataOutputStream output;
	private boolean stop;

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

	private void manageResponse(String response) {
		System.out.println(response);
	}

	public void requestMessage() throws IOException{
		output.writeUTF(Request.MESSAGE.toString());
	}
}