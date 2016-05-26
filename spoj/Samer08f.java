import java.util.*;
import java.lang.*;

public class Samer08f{
	public static void printSquares(int t){
		int sum = 0;
		for(int i=1;i<=t;i++){
			sum += i*i;
		}
		System.out.println(sum);
	}
	public static void main (String[] args) throws java.lang.Exception{
		java.io.BufferedReader buf = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int t;
		while( ( t = Integer.parseInt(buf.readLine()) ) > 0){
			printSquares(t);
		}
	}
}