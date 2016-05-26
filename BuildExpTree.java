import java.io.*;

class RootAlreadyPresentException extends RuntimeException{
	public RootAlreadyPresentException(String s){
		super(s);
	}
}

class TNode<E>{
	E e;
	TNode<E> left,right;
	public Node(){
		e = null;
		left = right = null;
	}
	public Node(E ele){
		e = ele;
		left = right = null;
	}
	public E getElement(){return e;}
	public void setElement(E ele){e=ele;}
	public void setLeft(TNode<E> l){left=l;}
	public void setRight(TNode<E> r){right=r;}
	public TNode<E> getLeft(){return left;}
	public TNode<E> getRight(){return right;}
}

class Tree<E>{
	TNode<E> root;
	int size;
	public Tree(){
		root = null;
		size=0;
	}
	public Tree(TNode<E> ne){
		root = ne;
		size=1;
	}
	public void setRoot(TNode<E> ne) throws RootAlreadyPresentException{
		if(root != null) throw new RootAlreadyPresentException("Root already defined.");
		else root = ne;
	}
	public TNode<E> getRoot(){return root;}
	public TNode<E> getNode(E e){
		return getNodeHelper(e,root);
	}
	public TNode<E> getNodeHelper(E e,TNode<E> p){
		if (p == null) return null;
		if (p.getElement() == e) return p;

		TNode<E> temp = getNodeHelper(e,p.getLeft());
		if (temp != null) return temp;
		else return getNodeHelper(e,p.getRight());
	}
	public void PreOrderTrav(TNode<E> p){
		if(p == null) return;
		System.out.print(p.getElement()+",");
		PreOrderTrav(p.getLeft());
		PreOrderTrav(p.getRight());
	}
	public void PostOrderTrav(TNode<E> p){
		if( p==null ) return;
		PostOrderTrav(p.getLeft());
		PostOrderTrav(p.getRight());
		System.out.print(p.getElement()+",");
	}
	public void InOrderTrav(TNode<E> p){
		if(p==null) return;
		InOrderTrav(p.getLeft());
		System.out.print(p.getElement()+",");
		InOrderTrav(p.getRight());
	}
}

class BuildExpTree {
	public static Node<String> buildTree(String s){
		int i =0;
		while(i<s.length){

		}
	}
	public static void main(String[] args) throws java.lang.Exception{
		java.io.BufferedReader b = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		String s = b.readLine();
		while(s != "0"){
			Node<String> s = buildTree(s);
		}
	}
}