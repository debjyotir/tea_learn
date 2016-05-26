import java.util.*;
import java.io.*;
import java.math.*;

class StacyNumbers{
	public static void main(String[] args) throws java.lang.Exception{
		java.io.BufferedReader b=new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		String st_params=b.readLine();
		String[] params = st_params.split(" ");
		int t=Integer.parseInt(params[1]);
		String st_num=b.readLine();
		List<BigInteger> ar = new ArrayList<BigInteger>();
		for(int i=0;i<st_num.length();i++){
			if(st_num.charAt(i)!='0'){
				for(int j=i+1;j<=st_num.length();j++){
					BigInteger check_num=new BigInteger(st_num.substring(i,j));
					// BigInteger put=new BigInteger(check_num);
					// check_num=put.toString();
					ar.add(check_num);
				}
			}
			else{
				ar.add(BigInteger.ZERO);
			}
		}
		// for(BigInteger temp:ar){
		// 	System.out.print(temp+" ");
		// }
		// System.out.println();
		Collections.sort(ar);
		// for(BigInteger temp:ar){
		// 	System.out.print(temp+" ");
		// }
		// System.out.println();
		for(int i=0;i<t;i++){
			int n=Integer.parseInt(b.readLine());
			System.out.println(ar.get(n-1));
		}
	}
}