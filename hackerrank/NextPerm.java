import java.util.*;
import java.io.*;
class NextPerm{
	public StringBuilder reverse(StringBuilder s,int start){
		for(int i=start+1,j=s.length()-1;i<j;i++,j--){
			char temp = s.charAt(i);
			s.setCharAt(i,s.charAt(j));
			s.setCharAt(j,temp);
		}
		return s;
	}
	public void findNextPerm(String test){
		if(test.length() <= 1){
			System.out.println("no answer");
		}
		else{
			int i=0,j=0,flag=0;
			for(int k=test.length()-2;k>=0;k--){
				if((int)test.charAt(k) < (int)test.charAt(k+1)){
					flag=1;
					i=k;
					// System.out.println("found i : "+i);
					break;
				}
			}
			if(flag==0){
				System.out.println("no answer");
			}
			else{
				for(int k=test.length()-1;k>i;k--){
					if((int)test.charAt(k)>(int)test.charAt(i)){
						j=k;
						// System.out.println("now j : "+j);
						break;
					}
				}
				StringBuilder newStr = new StringBuilder(test);
				char temp = test.charAt(i);
				newStr.setCharAt(i,test.charAt(j));
				newStr.setCharAt(j,temp);
				newStr = reverse(newStr,i);
				System.out.println(newStr);
			}
		}
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int t=s.nextInt();
		NextPerm n = new NextPerm();
		while(t-->0){
			String test = s.next();
			n.findNextPerm(test);
		}
	}
}