import java.util.*;
import java.lang.*;

class Acpc10a{
	public static void printApGp(int a,int b,int c){
		if((b-a) == (c-b)){
			System.out.println("AP "+(c+(c-b)));
		}
		else{
			System.out.println("GP "+(c*(int)(c/b)));
		}
	}
	public static void main (String[] args) throws java.lang.Exception{
		java.io.BufferedReader buf = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		String t;
		while(true){
			t=buf.readLine();
			String s[] = t.split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			if(a==0&&b==0&&c==0) break;
			printApGp(a,b,c);
		}
	}
}