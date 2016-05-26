import java.lang.*;

public class Addrev{
	public static void main(String[] args) throws java.lang.Exception{
		java.io.BufferedReader nt = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int n = Integer.parseInt(nt.readLine());
		while(n-- > 0){
			// java.io.BufferedReader k = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
			String s;
			s = nt.readLine();
			StringBuffer buf = new StringBuffer(s);
			buf.reverse();
			String[] nums = buf.toString().split(" ");
			long ans = Integer.parseInt(nums[0])+Integer.parseInt(nums[1]);
			StringBuffer rep = new StringBuffer(Long.toString(ans));
			rep.reverse();
			String res = rep.toString();
			System.out.println(Integer.parseInt(res));
		}
	}
}