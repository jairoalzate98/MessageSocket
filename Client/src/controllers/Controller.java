package controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import comunication.Client;
import views.MainWindow;

public class Controller implements ActionListener{
	
	private Client client;
	private MainWindow mainWindow;
	
	public Controller() throws IOException {
		client = new Client();
		mainWindow = new MainWindow(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (Events.valueOf(e.getActionCommand())) {
		case SEND:
			try {
				send();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		}
	}

	private void send() throws IOException {
		client.requestMessage(mainWindow.getMessage());
	}
}