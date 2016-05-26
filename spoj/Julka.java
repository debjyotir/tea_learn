import java.io.BufferedReader;
import java.math.BigInteger;
class Julka{
	public static void main(String[] args) throws java.lang.Exception{
		BufferedReader b=new BufferedReader(new java.io.InputStreamReader(System.in));
		int i=0;
		while(i<10){
			BigInteger t=new BigInteger(b.readLine());
			BigInteger y=new BigInteger(b.readLine());
			BigInteger n;
			n = (t.subtract(y)).divide(BigInteger.valueOf(2));
			System.out.println(n.add(y));
			System.out.println(n);
			i++;
		}
	}
}