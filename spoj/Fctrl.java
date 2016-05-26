import java.lang.*;
import java.util.*;

public class Fctrl{
	public static void printTrailZeros(int n){
		int count = 0;
		// for ( int i=5 ; n/i>1 ; i*=5 ) {
		// 	count += n/i;
		// }
		while(n > 0){
			n/=5;
			count+=n;
		}
		System.out.println(count);
	}
	public static void main(String[] args) throws java.lang.Exception{
		java.io.BufferedReader buf = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int t = Integer.parseInt(buf.readLine());
		while( t-- > 0 ){
			int n = Integer.parseInt(buf.readLine());
			printTrailZeros(n);
		}
	}
}