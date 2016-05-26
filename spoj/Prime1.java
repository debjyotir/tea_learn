import java.lang.*;
import java.util.*;
public class Prime1{
	public static ArrayList simpleSieve(int n){
		ArrayList primes = new ArrayList();
		boolean[] arr = new boolean[n+1];
		Arrays.fill(arr,true);
		for(int i=2;i*i < n;i++){
			if(arr[i]==true){
				for(int j=i*2;j<=n;j+=i) arr[j]=false;
			}
		}
		for(int i=2;i<=n;i++){
			if(arr[i]==true) primes.add(i);
		}
		return primes;
		// System.out.println();
	}
	public static void segmentedSieve(int m,int n){
		int limit = (int)Math.floor(Math.sqrt(n)) + 1;
		ArrayList first = simpleSieve(limit);
		// System.out.println(first);
		boolean mark[] = new boolean[n-m+1];
		Arrays.fill(mark,true);
		for(int i=0;i<first.size();i++){
			// System.out.println("i : "+i+" "+m/(int)first.get(i)+" ");
			int lowLim = (int)Math.floor(m/(int)first.get(i))*(int)first.get(i);
			if(lowLim < m) lowLim += (int)first.get(i);
			// System.out.println("lowLim : "+lowLim);
			for( int j=lowLim ; j<=n ; j+=(int)first.get(i) ) {
				mark[j-m] = false; 
				// System.out.println("marked : "+j);
			}
		}
		for(int i=0;i<first.size();i++){
			if ((int)first.get(i) >= m) System.out.println(first.get(i));
		}
		for(int i=0;i<=n-m;i++){
			if(mark[i]==true && i+m!=1) System.out.println(i+m);
		}
		System.out.println();
	}
	public static void printPrimes(int m,int n){
			// simpleSieve(m,n);
			segmentedSieve(m,n);
	}
	public static void main(String[] args) throws java.lang.Exception{
		java.io.BufferedReader t = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int p = Integer.parseInt(t.readLine());
		while ( p-- > 0 ){
			String s;
			s = t.readLine();
			String nums[] = s.split(" ");
			int m = Integer.parseInt(nums[0]);
			int n = Integer.parseInt(nums[1]);
			printPrimes(m,n);
		}
	}
}