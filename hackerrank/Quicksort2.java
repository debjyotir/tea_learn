import java.io.*;
import java.util.*;

class Quicksort2{
	public ArrayList<Integer> sort(ArrayList<Integer> a){
		if(a.size() <= 1){
			return a;
		}
		else{
			int pivot = a.get(0);
			ArrayList<Integer> left = new ArrayList<Integer>();
			ArrayList<Integer> right = new ArrayList<Integer>();
			int i=1;
	        while(i < a.size()){
	        	if(a.get(i)<pivot) {left.add(a.get(i)); i++;}
	        	else if(a.get(i)>pivot) {right.add(a.get(i));i++;}
	        }
	        ArrayList<Integer> toPrint = concatenate(sort(left),pivot,sort(right));
	        printList(toPrint,0,toPrint.size()-1);
	        return toPrint;
		}
	}
	public ArrayList<Integer> concatenate(ArrayList<Integer> l,int piv,ArrayList<Integer> r){
		ArrayList<Integer> retList = new ArrayList<Integer>();
		for(int i=0;i<l.size();i++) retList.add(l.get(i));
		retList.add(piv);
		for(int i=0;i<r.size();i++) retList.add(r.get(i));
		return retList;
	}
	public static void printList(ArrayList<Integer> list,int a,int b){
		int i=a;
		while(i<=b){
			System.out.print(list.get(i++)+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		ArrayList<Integer> ar = new ArrayList<Integer>();
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int t=0;
		while(t<size){
			ar.add(s.nextInt());
			t++;
		}
		Quicksort2 q = new Quicksort2();
		ArrayList<Integer> sorted = q.sort(ar);
	}
}