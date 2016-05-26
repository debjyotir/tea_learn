public class Node{
	private String element;
	private Node next;

	public Node(){
		element = null;
		next = null;
	}
	public Node(String s){
		element = s;
		next = null;
	}
	public Node(String s,Node n){
		element = s;
		next = n;
	}

	public String getElement(){
		return element;
	}

	public Node getNext(){
		return next;
	}

	public void setElement(String s){
		element = s;
	}

	public void setNext(Node n){
		next = n;
	}
}