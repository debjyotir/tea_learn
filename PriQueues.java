import java.io.*;
import java.util.*;
import java.util.Comparator;
class Entry<K,V>{
	protected K key;
	protected V value;
	public Entry(K k,V v){
		key=k;
		value=v;
	}
	public K getKey(){ return key;}
	public V getValue(){return value;}
}
class KeyComparator<K> implements Comparator<K>{
	@Override
	public int compare(K k1,K k2){
		return ((Comparable<K>)k1).compareTo(k2);
	}
}
class CompleteBTree<E>{
	protected ArrayList<E> A;
	public CompleteBTree(){
		A = new ArrayList<E>();
		A.add(0,null);
	}
	public int size(){return A.size()-1;}
	public boolean isEmpty(){return A.size()==0;}
	public E getValue(int position){return A.get(position);}
	public boolean hasLeft(int position){
		if( !isEmpty() ) return 2*position <= A.size();
		else return false;
	}
	public boolean hasRight(int position){
		if( !isEmpty() ) return 2*position+1 <= A.size();
		else return false;
	}
	public boolean isInternal(int position){
		return hasLeft(position); //since if right child present, means left will pakka be there.
	}
	public boolean isExternal(int position){
		return !isInternal(position);
	}
	public E getRoot(){
		if(!isEmpty()) return A.get(1);
		else return null;
	}
	public E getLeft(int position){
		if(hasLeft(position)) return A.get(2*position);
		else return null;
	}
	public E getRight(int position){
		if(hasRight(position)) return A.get(2*position+1);
		else return null;
	}
	//returns the index of the parent node
	public int getParentPosition(int position){
		if(A.indexOf(position)>1){
			return (int)position/2;
		}
		else return 0;
	}
	public void add(E e){
		A.add(e);
	}
	public E replace(int i,E n){
		if(!isEmpty() && A.size()>i){
			E temp = A.get(i);
			A.set(i,n);
			return temp;
		}
		else return null;
	}
	public E remove(){
		if(!isEmpty()) return A.remove(A.size()-1);
		else return null;
	}
}

class HeapPQueue<K,V>{
	protected CompleteBTree<Entry<K,V>> heap;
	KeyComparator<K> comp;

	public HeapPQueue(){
		heap = new CompleteBTree<Entry<K,V>>();
		comp = new KeyComparator<K>();
	}

	public int size(){return heap.size();}
	public boolean isEmpty(){return heap.size()==0;}
	public Entry<K,V> min(){
		if(!isEmpty()){
			return heap.getRoot();
		}
		else return null;
	}
	public Entry<K,V> removeMin(){
		if(!isEmpty()){
			Entry<K,V> min = heap.getRoot();
			if(size()==1) heap.remove();
			else{
				heap.replace(1,heap.remove());
				downHeap(1);
			}
			return min;
		}
		else return null;
	}
	protected void downHeap(int position){
		while(heap.isInternal(position)){
			int s;   //position of a smaller child.
			if(!heap.hasRight(position)) s=2*position;
			else if( comp.compare(heap.getLeft(position).getKey(),heap.getRight(position).getKey()) <=0) s=2*position;
			else s=2*position+1;
			if(comp.compare(heap.getValue(position).getKey(),heap.getValue(s).getKey()) >0){
				swap(position,s);
				position=s;
			}
			else break;
		}
	}
	protected void upHeap(int position){
		int u;
		while(position!=1){
			u=heap.getParentPosition(position);
			if(comp.compare(heap.getValue(position).getKey(),heap.getValue(u).getKey())<0){
				swap(position,u);
				position=u;
			}
		}
	}
	protected void swap(int r,int s){
		Entry<K,V> temp = heap.getValue(r);
		heap.replace(r,heap.getValue(s));
		heap.replace(s,temp);
	}
}