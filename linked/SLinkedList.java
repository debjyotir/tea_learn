public class SLinkedList{
	protected Node head;
	protected long size;
	protected Node tail;

	public SLinkedList(){
		head = tail = null;
		size = 0;
	}

	public Node addFirst(String s){
		Node newNode = new Node(s,null);
		newNode.setNext(head);
		if(head == null){ head = tail = newNode; }
		else{ head = newNode; }
		size += 1;
		return head;
	}

	public Node addLast(String s){
		Node newNode = new Node(s,null);
		if (head == null) {	head = tail = newNode; }
		else{
			tail.setNext(newNode);
			tail = newNode;
		}
		size += 1;
		return tail;
	}

	protected void showList(){
		Node temp = head;
		int i = 0;
		while(temp != null) {
			if(temp.getNext() != null){ System.out.print(temp.getElement()+" -> "); }
			else{ System.out.println(temp.getElement()+" "); }
			temp = temp.getNext();
			i++;
		}
		System.out.println("Total "+i+" elements in the list");
	}

}