class EmptyQueueException extends RuntimeException{
	public EmptyQueueException(String err){
		super(err);
	}
}

class FullQueueException extends RuntimeException{
	public FullQueueException(String err){
		super(err);
	}
}

class Node<E>{
	private E value;
	private Node<E> next;
	public Node(){
		value = null;
		next = null;
	}
	public Node(E val, Node<E> n){
		value = val;
		next = n;
	}
	public Node(E val){
		value = val;
		next = null;
	}
	public E getElement(){return value;}
	public Node<E> getNext(){return next;}
	public void setElement(E e){value = e;}
	public void setNext(Node<E> n){next = n;}
}

interface Queue<E> {
	public int size();
	public boolean isEmpty();
	public E front() throws EmptyQueueException;
	public void enqueue(E e);
	public E dequeue() throws EmptyQueueException;
}

class NodeQueue<E> implements Queue<E>{
	protected Node<E> f;
	protected Node<E> r;
	protected int size;
	public NodeQueue(){
		f = r = null;
		size = 0;
	}
	public int size(){return size;}
	public boolean isEmpty(){ return (r == null);}
	public E front() throws EmptyQueueException{
		if(isEmpty()) throw new EmptyQueueException("queue is empty");
		return f.getElement();
	}
	public void enqueue(E e){
		Node<E> newNode = new Node<E>(e);
		if (size == 0) f = newNode;
		else
			r.setNext(newNode);
		r = newNode;
		size++;
	}
	public E dequeue() throws EmptyQueueException{
		if (size == 0) throw new EmptyQueueException("queue empty.");
		E temp = f.getElement();
		f = f.getNext();
		size--;
		if (size == 0) r = null;
		return temp;
	}
	public void printQueue(){
		Node<E> temp = f;
		while(temp != null){
			System.out.print(temp.getElement()+" ->");
			temp = temp.getNext();
		}
		System.out.println();
	}
}
class ArrayQueue<E> implements Queue<E>{
	protected int capacity;
	public static final int CAP = 1000; //upper limit on capacity
	protected E S[];				// array used to store queue
	// protected int size = 0;
	protected int front = 0;
	protected int rear = 0 ;

	public ArrayQueue(int cap){
		capacity = cap;
		front = rear = 0;
		S = (E[]) new Object[capacity];
	}

	public int size(){
		return ((capacity - front + rear)%capacity);
	}

	public boolean isEmpty(){
		return (front == rear);
	}

	public E front() throws EmptyQueueException{
		if (isEmpty()) throw new EmptyQueueException("queue is empty");
		return S[front];
	}

	public void enqueue(E e) throws FullQueueException{
		if(size() == capacity-1) throw new FullQueueException("queue is full");
		S[rear] = e;
		rear = (rear+1)%capacity;
	}

	public E dequeue() throws EmptyQueueException{
		if (isEmpty()) throw new EmptyQueueException("queue is empty");
		E temp = S[front];
		S[front] = null;
		front = (front+1)%capacity;
		return temp;
	}

	public void printQueue(){
		int temp = front;
		while(temp != rear){
			System.out.print(S[temp]+" , ");
			temp = (temp+1)%capacity;
		}
		System.out.println();
	}
}

public class Queues{
	public static void checkArrayImp(){
		Object O;
		ArrayQueue<String> Countries = new ArrayQueue<String>(10);
		System.out.println("size : "+Countries.size());
		Countries.enqueue("Russia");
		Countries.printQueue();
		Countries.enqueue("Canada");
		Countries.enqueue("China");
		Countries.enqueue("USA");
		Countries.enqueue("Brazil");
		Countries.enqueue("India");
		Countries.printQueue();
		System.out.println("size : "+Countries.size());
		O = Countries.dequeue();
		System.out.println("dequeued obj. : "+O);
		Countries.printQueue();
		System.out.println("size : "+Countries.size());
		O = Countries.dequeue();
		System.out.println("dequeued obj. : "+O);
		Countries.printQueue();
		System.out.println("size : "+Countries.size());

	}
	public static void checkNodeImp(){
		Object O;
		NodeQueue<String> Countries = new NodeQueue<String>();
		System.out.println("size : "+Countries.size());
		Countries.enqueue("Russia");
		Countries.printQueue();
		Countries.enqueue("Canada");
		Countries.enqueue("China");
		Countries.enqueue("USA");
		Countries.enqueue("Brazil");
		Countries.enqueue("India");
		Countries.printQueue();
		System.out.println("size : "+Countries.size());
		O = Countries.dequeue();
		System.out.println("dequeued obj. : "+O);
		Countries.printQueue();
		System.out.println("size : "+Countries.size());
		O = Countries.dequeue();
		System.out.println("dequeued obj. : "+O);
		Countries.printQueue();
		System.out.println("size : "+Countries.size());

	}
	public static <E> NodeQueue<E> buildQueue(E s[]){
		NodeQueue<E> q = new NodeQueue();
		for (int i=0;i<s.length ;i++ ) {
			q.enqueue(s[i]);
		}
		return q;
	}

	public static void josephus(String s[], int k){
		NodeQueue<String> jose = buildQueue(s);
		while(jose.size() > 1){
			for (int i=0;i<k ;i++ ) {
				jose.enqueue(jose.dequeue());
			}
			String kicked = jose.dequeue();
			System.out.println(kicked+" got kicked out.");
		}
		System.out.println(jose.dequeue()+" is the winner.");
	}
	public static void main(String[] args) {
		// checkNodeImp();
		String s[] = {"ram","shyam","jodhu","modhu"};
		josephus(s,6);
	}
}
