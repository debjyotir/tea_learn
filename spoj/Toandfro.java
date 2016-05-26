import java.io.*;
import java.util.*;
class Toandfro{
	public static void main(String[] args) throws java.lang.Exception{
		java.io.BufferedReader buf = new java.io.BufferedReader(new InputStreamReader(System.in));
		while(true){
			int col = Integer.parseInt(buf.readLine());
			// System.out.println("col : "+col);
			if(col == 0) break;
			String enc = buf.readLine();
			// System.out.println("enc : "+enc);
			int t = 0, p=0;
			while(t<col){
				p=t;
				while(p<enc.length()) {
					System.out.print(enc.charAt(p));
					p = p+col;
				}
				t++;
			}
			System.out.println();
		}
	}
}