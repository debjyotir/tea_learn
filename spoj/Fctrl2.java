import java.lang.*;
import java.util.*;
import java.math.*;

public class Fctrl2{
	public static BigInteger getFactorial(int n){
		if(n==0 || n==1) return BigInteger.valueOf(1);
		return getFactorial(n-1).multiply(BigInteger.valueOf(n));
	}
	public static void main(String[] args) throws java.lang.Exception{
		java.io.BufferedReader buf = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int t = Integer.parseInt(buf.readLine());
		while (t-- > 0){
			int n = Integer.parseInt(buf.readLine());
			System.out.println(getFactorial(n));
		}
	}
}