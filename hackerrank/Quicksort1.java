import java.io.*;
import java.util.*;
// partition method of the quicksort
class Quicksort1 {
	public static void exchange(int ar[],int a,int b){
		int temp = ar[a];
		ar[a] = ar[b];
		ar[b] = temp;
	}
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        ArrayList<Integer> ar = new ArrayList<Integer>();
        ArrayList<Integer> left = new ArrayList<Integer>();
        ArrayList<Integer> right = new ArrayList<Integer>();
        int i=0;
        while(i<t){
        	ar.add(s.nextInt());
        	i++;
        }
        int pivot = ar.get(0);
        i=1;
        while(i<t){
        	if(ar.get(i)<pivot) left.add(ar.get(i++));
        	else right.add(ar.get(i++));
        }
        i=0;
        while(i<left.size()) System.out.print(left.get(i++)+" ");
        // System.out.println();
        System.out.print(pivot+" ");
        // System.out.println();
        i=0;
        while(i<right.size()) System.out.print(right.get(i++)+" ");
        System.out.println();
    }
}