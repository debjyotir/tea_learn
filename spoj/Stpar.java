import java.util.*;

class Stpar{
	public static void main(String[] args) throws java.lang.Exception{
		java.io.BufferedReader b = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int t=Integer.parseInt(b.readLine());
		while(t != 0){
			int flag=0;
			java.util.Stack<Integer> st = new java.util.Stack<Integer>();
			String line = b.readLine();
			String nums[] = line.split(" ");
			int comp=1;
			int i=0,n=0;
			while(i<t){
				n=Integer.parseInt(nums[i]);
				while (st.isEmpty() !=true && st.peek() == comp) {
					comp++;
					st.pop();
				}
				if (n == comp) comp++;
				else if (!st.isEmpty() && st.peek() < n) {
					flag=-1;
					break;
				} else st.push(n);
				i++;	
			}
			if(flag != -1) System.out.println("YES");
			else System.out.println("NO");
			t=Integer.parseInt(b.readLine());
		}

	}
}