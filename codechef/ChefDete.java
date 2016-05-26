import java.io.*;
import java.util.*;

class ChefDete{
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n = s.nextInt();
		int[] ar = new int[n+1];
		Arrays.fill(ar,0);
		for (int i=1;i<=n ;i++ ) {
			int reportee=s.nextInt();
			ar[reportee]++;
		}
		for (int i=1;i<=n ;i++ ) {
			if(ar[i]==0) System.out.print(i+" ");
		}
		System.out.println();
	}	
}