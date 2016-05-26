import java.lang.*;
import java.util.*;

class EmptyStackException extends RuntimeException{
	public EmptyStackException(String s){
		super(s);
	}
}
class FullStackException extends RuntimeException{
	public FullStackException(String s){
		super(s);
	}
}

class Stack<E>{
	private static final int CAP = 400;
	protected int top;
	protected E[] stak;
	public Stack(){
		stak = (E[])new Object[CAP];
		top = -1;
	}
	public int getSize(){ return top+1; }
	public boolean isEmpty(){ return (top < 0);}
	public E getTop() throws EmptyStackException{ 
		if (top<0) throw new EmptyStackException("stack is empty.");
		return stak[top]; 
	}
	public void push(E e) throws FullStackException{
		if (getSize()==CAP) throw new FullStackException("stack is full.");
		stak[++top] = e;
	}
	public E pop() throws EmptyStackException{
		if (top<0) throw new EmptyStackException("stack is empty.");
		E temp = stak[top];
		stak[top--]=null;
		return temp;
	}
	public void printStack(){
		int t=0;
		while(t <= top){
			System.out.print(stak[t]+" ");
			t++;
		}
		System.out.println();
	}
}

public class Onp{
	public static void printReversePolishNotation(String exp){
		int pointer = 0;
		int max = exp.length();
		Stack<Character> stak = new Stack<Character>();
		while ( pointer < max ){
			switch(exp.charAt(pointer)){
				case ')':
					//do stack ops
					while(stak.getTop() != '('){
						// System.out.println(stak.getSize()+"<-size top -> : "+stak.getTop());
						System.out.print(stak.pop());
					}
					char removeopenbracket = stak.pop();
					break;
				case '(':
				case '+':
				case '-':
				case '*':
				case '/':
				case '^':
					stak.push(exp.charAt(pointer));
					break;
				default:
					System.out.print(exp.charAt(pointer));
					break;
			}
			// System.out.println("char being processed "+exp.charAt(pointer));
			// stak.printStack();
			pointer++;
		}
		while(stak.isEmpty() != true){
			char s = stak.pop();
			if(s != '(') System.out.print(s);
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws java.lang.Exception{
		java.io.BufferedReader buf = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int t = Integer.parseInt(buf.readLine());
		String exp;
		while ( t-- > 0 ){
			exp = buf.readLine();
			printReversePolishNotation(exp);
		}
	}
}