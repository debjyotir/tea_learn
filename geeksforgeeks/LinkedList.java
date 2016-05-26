class LinkedList{
	Node head;
	class Node{
		int data;
		Node next;
		Node(int d){data=d;next=null;}
	}
	void deleteNode(Node headP,Node node){
		if(headP==null){
			System.out.println("no nodes to delete");
			return;
		}
		if(headP==node){
			if(node.next==null){
				System.out.println("list has one node and it can't be made empty");
				return;
			}
			headP.data = headP.next.data;
			node=headP.next;
			headP.next = headP.next.next;
			System.gc();
			return;
		}

        // When not first node, follow the normal deletion process
        // find the previous node
        Node prev = node;
        while (prev.next != null && prev.next != node) {
            prev = prev.next;
        }
 
        // Check if node really exists in Linked List
        if (prev.next == null) {
            System.out.println("Given node is not present in Linked List");
            return;
        }
 
        // Remove node from Linked List
        prev.next = prev.next.next;
 
        // Free memory
        System.gc();
 
        return;
	}
	void sortedInsert(Node nNode){
		if(head==null || head.data >= nNode.data){
			nNode.next=head.next;
			head=nNode;
		}
		else{
			Node temp=head;
			while(temp.next!=null && temp.next.data < nNode.data){
				temp=temp.next;
			}
			nNode.next=temp.next;
			temp.next=nNode;
		}
	}
	Node newNode(int data){
		Node x = new Node(data);
		return x;
	}
	void printList(){
		Node temp = head;
		while(temp != null){
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		LinkedList llist = new LinkedList();
		Node newNode;
		newNode = llist.newNode(4);
		llist.head=newNode;
		llist.printList();
		newNode = llist.newNode(10);
		llist.sortedInsert(newNode);
		llist.printList();
		newNode = llist.newNode(2);
		llist.sortedInsert(newNode);
		llist.printList();
		newNode = llist.newNode(5);
		llist.sortedInsert(newNode);
		llist.printList();
		newNode = llist.newNode(20);
		llist.sortedInsert(newNode);
		llist.printList();
		newNode = llist.newNode(10);
		llist.sortedInsert(newNode);
		llist.printList();
	}
}