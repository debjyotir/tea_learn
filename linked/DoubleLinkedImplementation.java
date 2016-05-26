class DNode{
		protected String element;
		protected DNode next, prev;

		public DNode(String e,DNode p,DNode n){
			element = e;
			next = n;
			prev = p;
		}

		public String getElement(){return element;}
		public DNode getNext(){return next;}
		public DNode getPrev(){return prev;}

		public void setElement(String s){element=s;}
		public void setNext(DNode n){next = n;}
		public void setPrev(DNode p){prev = p;}
}

class DList{
	protected int size;
	protected DNode header, trailer;
	/**Constructor that creates an empty list*/
	public DList(){
		size = 0;
		header = new DNode(null,null,null);
		trailer = new DNode(null,header,null);
		header.setNext(trailer);
	}
	public int size(){return size;}
	public boolean isEmpty(){return (size==0);}
	public DNode getFirst() throws IllegalStateException{
		if (isEmpty()) throw new IllegalStateException("list is empty");
		return header.getNext();
	}
	public DNode getLast() throws IllegalStateException{
		if (isEmpty()) throw new IllegalStateException("list is empty");
		return trailer.getPrev();
	}
	public DNode getPrev(DNode v) throws IllegalArgumentException{
		if (v == header) throw new IllegalArgumentException("cannot move past the header of the list");
		return v.getPrev();
	}
	public DNode getNext(DNode v) throws IllegalArgumentException{
		if (v == trailer) throw new IllegalArgumentException("cannot move beyond the trailer of the list");
		return v.getNext();
	}
	/**inserts node z before node v , throws error if v is header*/
	public void addBefore(DNode v,DNode z) throws IllegalArgumentException{
		DNode u = getPrev(v);		//may throw illegal argument exception
		u.setNext(z);
		z.setPrev(u);
		z.setNext(v);
		v.setPrev(z);
		size++;
	}
	/**inserts 	node z after node v, throws error if v is trailer*/
	public void addAfter(DNode v,DNode z) {
		DNode u = getNext(v);		//may throw illegal argument exception
		v.setNext(z);
		z.setPrev(v);
		z.setNext(u);
		u.setPrev(z);
		size++;
	}
	public void addFirst(DNode v){
		addAfter(header,v);
	}
	public void addLast(DNode v){
		addBefore(trailer,v);
	}
	/**removes the given node v from the list, error occurs if v is header or trailer*/
	public void remove(DNode v){
		DNode u = getPrev(v);	//may throw an illegal argument exception
		DNode w = getNext(v);	//may throw an illegal argument exception
		//unlink the node from the list
		u.setNext(w);
		w.setPrev(u);
		v.setPrev(null);
		v.setNext(null);
		size--;
	}
	public boolean hasPrev(DNode v){ return (v != header);}
	public boolean hasNext(DNode v){return (v != trailer);}
	/**returns a string representation of the list*/
	public String toString(){
		String s = "[";
		DNode v = header.getNext();
		while (v != trailer){
			s += v.getElement();
			v = v.getNext();
			if (v != trailer){ s += " , "; }
		}
		s += "]";
		return s;
	}
}

public class DoubleLinkedImplementation{
	public static void main(String[] args) {
		DNode d = new DNode("balle",null,null);
		System.out.println("bwahahahhahaha!! awesome " + d.getElement());

	}
}