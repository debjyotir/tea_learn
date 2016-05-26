import java.lang.*;
public class Nsteps{
	public static void printNsteps(int x,int y){
		if (x==y || x==y+2){
			if (x%2==0 && y%2==0) System.out.println(x+y);
			else if(x%2!=0 && y%2!=0) System.out.println(x+y-1);
			else System.out.println("No Number");
		}
		else System.out.println("No Number");
	}
	public static void main(String[] args) throws java.lang.Exception{
		java.io.BufferedReader buf = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int t = Integer.parseInt(buf.readLine());
		while(t-->0){
			String s = buf.readLine();
			String nums[] = s.split(" ");
			int x = Integer.parseInt(nums[0]);
			int y = Integer.parseInt(nums[1]);
			printNsteps(x,y);
		}
	}
}