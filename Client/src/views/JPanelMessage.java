package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controllers.Events;

public class JPanelMessage extends JPanel {

	public static final String ACCEPT_TEXT = "Accept";
	private static final long serialVersionUID = 1L;
	private JTextArea jTextArea;
	private JButton jbtnAccept;

	public JPanelMessage(ActionListener actionListener) {
		setLayout(new FlowLayout());
		setBackground(Color.WHITE);
		jTextArea = new JTextArea();
		jTextArea.setPreferredSize(new Dimension(600, 300));
		jTextArea.setBorder(BorderFactory.createTitledBorder("Ingrese su mensaje"));
		add(jTextArea);
		jbtnAccept = new JButton(ACCEPT_TEXT);
		jbtnAccept.setActionCommand(Events.SEND.toString());
		jbtnAccept.addActionListener(actionListener);
		jbtnAccept.setPreferredSize(new Dimension(300, 50));
		add(jbtnAccept);
	}
	
	public String getMessage(){
		return jTextArea.getText();
	}
}