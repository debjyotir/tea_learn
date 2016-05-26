import java.io.*;
import java.util.*;
class InplaceQsort{
	protected void sort(ArrayList<Integer> list,int p,int q){
		if(p<q){
			int pivot = partition(list,p,q);
			printList(list,0,list.size()-1);
			sort(list,p,pivot-1);
			sort(list,pivot+1,q);
		}
	}
	protected int partition(ArrayList<Integer> list,int p,int q){
		int pivot = list.get(q);
		int i,j=p;
		// System.out.println("pivot - "+pivot);
		for(i=p;i<=q-1;i++){
			if(list.get(i)<=pivot){
				// System.out.println("swapping "+list.get(i)+" and "+list.get(j));
				int temp = list.get(i);
				list.set(i,list.get(j));
				list.set(j,temp);
				j++;
			}
		}
		// System.out.println("finally swapping "+list.get(j)+" and "+pivot);
		list.set(q,list.get(j));
		list.set(j,pivot);
		return j;
	}
	public void printList(ArrayList<Integer> list,int a,int b){
		int i=a;
		while(i<=b){
			System.out.print(list.get(i++)+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		ArrayList<Integer> ar=new ArrayList<Integer>();
		int i=0;
		while(i<t){
			ar.add(s.nextInt());i++;
		}
		InplaceQsort app = new InplaceQsort();
		app.sort(ar,0,ar.size()-1);
		// app.printList(ar,0,ar.size()-1);
	}
}