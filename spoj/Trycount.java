import java.math.BigInteger;
class Trycount{
public static void main(String[] args) throws java.lang.Exception{
java.io.BufferedReader b = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
int t = Integer.parseInt(b.readLine());
while(t-->0){
long n = Long.parseLong(b.readLine());
BigInteger bi;
bi = BigInteger.valueOf(n*(n+2)*(2*n+1));
bi = bi.divide(BigInteger.valueOf(8));
System.out.println(bi+"\n"+(long)Math.floor((n*(n+2)*(2*n+1))/8));
}
}
}