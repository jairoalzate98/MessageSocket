package models;

public class Node {

	private String info;
	private Node nextNode;
	
	public Node(String info) {
		this.info = info;
	}
	
	public String getInfo() {
		return info;
	}
	public Node getNextNode() {
		return nextNode;
	}

	public void setNextNode(Node nextNode) {
		this.nextNode = nextNode;
	}

	@Override
	public String toString() {
		return info;
	}
}