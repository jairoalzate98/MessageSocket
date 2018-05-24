package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import models.Node;

public class MainWindow extends JFrame {

	public static final String TITLE_FRAME = "Message";
	private static final long serialVersionUID = 1L;
	private JPanelMessage jPanelMessage;

	public MainWindow(ActionListener actionListener) {
		setTitle(TITLE_FRAME);
		getContentPane().setBackground(Color.WHITE);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 600);
		setLocationRelativeTo(null);
		jPanelMessage = new JPanelMessage(actionListener);
		add(jPanelMessage, BorderLayout.CENTER);
		setVisible(true);
	}
	
	public String getMessage(){
		return jPanelMessage.getMessage();
	}
	
	public void setModel(Node nodeHead){
		jPanelMessage.setModel(nodeHead);
		revalidate();
	}

	public void clearCamps() {
		jPanelMessage.clearCamps();
	}
}