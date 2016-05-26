import java.lang.*;
import java.io.BufferedReader;
class LastDig{
	public static <E> void pr(E s){System.out.println(s);} 
	public static void main(String[] args) throws java.lang.Exception{
BufferedReader buf = new BufferedReader(new java.io.InputStreamReader(System.in));
int t = Integer.parseInt(buf.readLine());String s;
while(t-- > 0){
	s = buf.readLine();String sp[] = s.split(" ");int a = Integer.parseInt(sp[0]);int b = Integer.parseInt(sp[1]);
	if(a==0)pr(0);else if(b==0)pr(1);
	else if(a%10==0||a%10==1||a%10==5||a%10==6) {pr(a%10);}
	else{if(b%4==1)pr(a%10);
		else if(b%4==2)pr((a*a)%10);
		else if(b%4==3)pr((a*a*a)%10);
		else pr((a*a*a*a)%10);}}}}