
class EmptyStackException extends RuntimeException{
	public EmptyStackException(String err){
		super(err);
	}
}

class FullStackException extends RuntimeException{
	public FullStackException(String err){
		super(err);
	}
}

interface Stack<E> {
	public int size();

	public boolean isEmpty();

	public E top() throws EmptyStackException;

	public void push(E element);

	public E pop() throws EmptyStackException;
}

class ArrayStack<E> implements Stack<E> {
	protected int capacity;
	public static final int CAP = 1000;
	protected E S[]; 			//generic array used to implement the stack
	protected int top = -1;		//index for top of the stack
	public ArrayStack(int cap){
		capacity = cap;
		S = (E[]) new Object[capacity];
	}
	public int size(){
		return (top+1);
	}
	public boolean isEmpty(){
		return (top<0);
	}
	public E top() throws EmptyStackException{
		if (isEmpty()) {
			throw new EmptyStackException("Stack is empty");
		}
		return S[top];
	}
	public void push(E element){
		if (size() == capacity){
			throw new FullStackException("Stack is full");
		}
		S[++top] = element;
	}
	public E pop() throws EmptyStackException{
		if(top<0){
			throw new EmptyStackException("Stack is empty. cannot pop.");
		}
		E element;
		element = S[top];
		S[top--] = null;	//dereference top for garbage collection
		return element;
	}
	public void printStack(){
		int i=0;
		while(i<size()){
			System.out.print(S[i]+" , ");
			i++;
		}
		System.out.println("\nthe stack contains "+size()+" elements.");
	}
}

class Node<E> {
	private E element;
	private Node<E> next;

	public Node(){
		this(null,null);
	}
	public Node(E e,Node<E> n){
		element = e;
		next = n;
	}
	//Accessor methods
	public E getElement(){
		return element;
	}
	public void setElement(E e){
		element = e;
	}
	public Node<E> getNext(){
		return next;
	}
	public void setNext(Node<E> n){
		next = n;
	}
}

class NodeStack<E> implements Stack<E>{
	protected Node<E> top;
	protected int size;

	public NodeStack(){
		top = null;
		size = 0;
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return (top == null);
	}
	public E top() throws EmptyStackException{
		if (top == null) {
			throw new EmptyStackException("list is empty.");
		}
		return top.getElement();
	}
	public void push(E ele){
		Node<E> n = new Node<E>(ele,top);
		top = n;
		size++;
	}
	public E pop() throws EmptyStackException{
		if(top == null) throw new EmptyStackException("list is empty.");
		E temp = top.getElement();
		top = top.getNext();
		size--;
		return temp;
	}
	public void printStack(){
		Node<E> temp = top;
		while (temp != null){
			System.out.print(temp.getElement()+"-> ");
			temp = temp.getNext();
		}
		System.out.println("\nthis list has "+size+" elements.");
	}
}

public class Stacks{

	protected static void checkArrayImp(){
		Object O;
		ArrayStack<Integer> A = new ArrayStack<Integer>(10);
		// O = A.pop();
		A.push(7);
		A.printStack();
		A.push(5);
		A.push(21);
		A.push(8);
		A.printStack();
		O = A.top();
		System.out.println("top element : "+O);
		O = A.pop();
		A.printStack();
		System.out.println("popped element : "+O);
	}

	protected static void checkNodeImp(){
		Object O;
		NodeStack<Integer> A = new NodeStack<Integer>();
		// O = A.pop();
		A.push(7);
		A.printStack();
		A.push(5);
		A.push(21);
		A.push(8);
		A.printStack();
		O = A.top();
		System.out.println("top element : "+O);
		O = A.pop();
		A.printStack();
		System.out.println("popped element : "+O);
	}

	public static void main(String[] args) {
		// checkArrayImp();
		checkNodeImp();
	}
}