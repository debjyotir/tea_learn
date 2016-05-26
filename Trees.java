class InvalidPositionException extends RuntimeException{
	public InvalidPositionException(String err){
		super(err);
	}
}
class EmptyTreeException extends RuntimeException{
	public EmptyTreeException(String err){
		super(err);
	}
}
class BoundaryViolationException extends RuntimeException{
	public BoundaryViolationException(String err){
		super(err);
	}
}

class BTNode<E>{
	private E element;
	private BTNode<E> left,right,parent;
	public BTNode(){
		element = null;
		left = right = parent = null;
	}
	public BTNode(E e){
		element = e;
		left = right = parent = null;
	}
	public E getElement(){return element;}
	public BTNode<E> getLeft(){return left;}
	public BTNode<E> getRight(){return right;}
	public BTNode<E> getParent(){return parent;}
	public void setElement(E e){element=e;}
	public void setLeft(BTNode<E> n){left = n;}
	public void setRight(BTNode<E> n){right = n;}
	public void setParent(BTNode<E> p){parent=p;}
}

class BTree<E>{
	private BTNode<E> root;
	private int size;
	public BTree(){
		root = null;
		size = 0;
	}
	public BTree(E e){
		root = new BTNode<E>(e);
		size = 1;
	}
	public int getSize(){return size;}
	public boolean isEmpty(){return (root==null);}
	public BTNode<E> getRoot(){return root;}
	public void setRoot(E e) throws InvalidPositionException{
		if(root==null) root = new BTNode<E>(e);
		else throw new InvalidPositionException("root already present.");
	}
	public void insertLeft(BTNode<E> p,E c) throws InvalidPositionException{
		if( p.getLeft() == null ){
			BTNode<E> temp = new BTNode<E>(c);
			p.setLeft(temp);
			size++;
		}
		else throw new InvalidPositionException("left child already present");
	}
	public void insertRight(BTNode<E> p,E c) throws InvalidPositionException{
		if( p.getRight() == null ){
			BTNode<E> temp = new BTNode<E>(c);
			p.setRight(temp);
			size++;
		}
		else throw new InvalidPositionException("left child already present");
	}
	public BTNode<E> getNode(E e){
		return getNodeHelper(e,root);
	}
	public BTNode<E> getNodeHelper(E e,BTNode<E> p){
		if (p == null) return null;
		if (p.getElement() == e) return p;

		BTNode<E> temp = getNodeHelper(e,p.getLeft());
		if (temp != null) return temp;
		else return getNodeHelper(e,p.getRight());
	}
	public void PreOrderTrav(BTNode<E> p){
		if(p == null) return;
		System.out.print(p.getElement()+",");
		PreOrderTrav(p.getLeft());
		PreOrderTrav(p.getRight());
	}
	public void PostOrderTrav(BTNode<E> p){
		if( p==null ) return;
		PostOrderTrav(p.getLeft());
		PostOrderTrav(p.getRight());
		System.out.print(p.getElement()+",");
	}
	public void InOrderTrav(BTNode<E> p){
		if(p==null) return;
		InOrderTrav(p.getLeft());
		System.out.print(p.getElement()+",");
		InOrderTrav(p.getRight());
	}


}

public class Trees {
	public static void treeTester(){
		BTNode<Integer> O;
		BTree<Integer> tree1 = new BTree<Integer>();
		tree1.setRoot(1);
		O = tree1.getRoot();
		tree1.insertLeft(O,2);
		tree1.insertRight(O,3);
		tree1.PreOrderTrav(tree1.getRoot());
		System.out.println();
		tree1.PostOrderTrav(tree1.getRoot());
		System.out.println();
		tree1.InOrderTrav(tree1.getRoot());
		System.out.println();
		O = tree1.getNode(2);
		tree1.insertLeft(O,4);
		tree1.insertRight(O,5);
		O = tree1.getNode(3);
		tree1.insertLeft(O,6);
		tree1.insertRight(O,7);
		tree1.PreOrderTrav(tree1.getRoot());
		System.out.println();
		tree1.PostOrderTrav(tree1.getRoot());
		System.out.println();
		tree1.InOrderTrav(tree1.getRoot());
		System.out.println();
		O = tree1.getNode(4);
		tree1.insertLeft(O,8);
		tree1.insertRight(O,9);
		O = tree1.getNode(5);
		tree1.insertLeft(O,10);
		tree1.PreOrderTrav(tree1.getRoot());
		System.out.println();
		tree1.PostOrderTrav(tree1.getRoot());
		System.out.println();
		tree1.InOrderTrav(tree1.getRoot());
		System.out.println();
	}
	public static void main(String[] args) {
			treeTester();
		}	
}