package run;

import java.io.IOException;

import comunication.Client;

public class Run {

	public static void main(String[] args) {
		try {
			Client c = new Client();
			c.requestMessage();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
