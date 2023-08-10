package hw4_ver3;

public class Node {
	private String name = "null"; 
	private Node parent = null; 
	private Node left = null; 
	private Node right = null;
	
	public Node(String name, Node parent, Node left, Node right) {
		this.name = name; 
		this.parent = parent; 
		this.left = left; 
		this.right = right; 
	}
	public Node(String name, Node parent) {
		this.name = name; 
		this.parent = parent; 	
		}
	public Node(String name) {
		this.name = name; 
	}
	public Node() {
	}
	
	///// insert
	public void insertLeft(Node insert) {
		insert.setParent(this);
		this.left = insert; 
	}
	public void insertRight(Node insert) {
		insert.setParent(this);
		this.right = insert; 
	}
	
	///// setter
	public void setParent(Node parent ) {
		this.parent = parent; 
	}
	
	///// getter
	public String getName() {
		return this.name; 
	}
	public Node left() {
		return this.left; 
	}
	public Node right() {
		return this.right; 
	}
	public Node parent() {
		return this.parent; 
	}

	

}
