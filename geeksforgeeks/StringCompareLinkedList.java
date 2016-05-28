class Node{
	char data;
	Node next;
	Node(char d){data=d;next=null;}
}
class StringCompareLinkedList {

	Node stringToList(String s){
		Node head = new Node(s.charAt(0));
		Node temp = head;
		for (int i=1;i<s.length() ;i++ ) {
			Node t=new Node(s.charAt(i));
			temp.next = t;
			temp = t;
		}
		return head;
	}

	int compare(Node node1,Node node2){
		if(node1==null && node2 == null){
			return 0;
		}
		while(node1 != null && node2 != null && node1.data == node2.data){
			node1 = node1.next;
			node2 = node2.next;
		}
		if(node1 != null && node2 != null){
			return (node1.data > node2.data? 1:-1);
		}
		if(node1!= null && node2== null){
			return 1;
		}
		if(node1==null && node2!=null){
			return -1;
		}
		return 0;
	}
	public static void main(String[] args) {
		StringCompareLinkedList comp = new StringCompareLinkedList();
		String a="geeksa";
		String b="geeksb";
		Node list1 = comp.stringToList(a);
		Node list2 = comp.stringToList(b);
		Node list3 = comp.stringToList("geek");
		System.out.println(comp.compare(list1,list3));
	}
}