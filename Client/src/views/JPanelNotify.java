package views;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;

import models.Node;

public class JPanelNotify extends JPanel{

	private static final long serialVersionUID = 1L;
	private JList<Node> nodeList;
	private DefaultListModel<Node> nodeModel;

	public JPanelNotify() {
		setBackground(Color.WHITE);
		setBorder(BorderFactory.createTitledBorder("Notificaciones"));
		nodeModel = new DefaultListModel<>();
		nodeList = new JList<>(nodeModel);
		add(nodeList);
	}
	
	public void setModel(Node nodeHead){
		nodeModel.clear();
		Node actual = nodeHead;
		while (actual != null) {
			nodeModel.addElement(actual);
			actual = actual.getNextNode();
		}
	}
}