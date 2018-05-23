package run;

import java.io.IOException;

import comunication.Server;

public class Run {

	public static void main(String[] args) {
		try {
			new Server(9000);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
