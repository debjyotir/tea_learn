import java.io.*;
import java.util.*;
import java.math.BigInteger;

class Stropr{
	public static void main(String[] args) throws java.lang.Exception{
		java.io.BufferedReader b=new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int t = Integer.parseInt(b.readLine());
		while(t-->0){
			String params = b.readLine();
			String[] sp_params = params.split(" ");
			int n=Integer.parseInt(sp_params[0]);
			int x=Integer.parseInt(sp_params[1]);
			BigInteger m = new BigInteger(sp_params[2]);
			BigInteger[] ar = new BigInteger[n];
			String nums = b.readLine();
			String sp_nums[] = nums.split(" ");
			// for (int i=0;i<n ;i++ ) {
			// 	ar[i]=new BigInteger(sp_nums[i]);
			// }
			for (BigInteger j=BigInteger.ZERO;j.compareTo(m)<0 ;j=j.add(BigInteger.ONE) ) {
				for(int k=1;k<x;k++){
					BigInteger actual = new BigInteger(sp_nums[k]);
					BigInteger prev = new BigInteger(sp_nums[k-1]);
					actual = actual.add(prev);
					sp_nums[k] = actual.toString();
				}
			}
			BigInteger out = new BigInteger(sp_nums[x-1]);
			System.out.println(out.mod(BigInteger.valueOf(1000000007)));
		}
	}
}