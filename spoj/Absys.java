import java.io.BufferedReader;
class Absys{
	public static <E> void pr(E e){
		System.out.println(e);
	}
	public static void main(String[] args) throws java.lang.Exception{
		BufferedReader b=new BufferedReader(new java.io.InputStreamReader(System.in));
		int t=Integer.parseInt(b.readLine());
		while(t-->0){
			String s=b.readLine();
			while(s.contains("machula")==false){
				s=b.readLine();
				// pr(10);
			}
			String sp[]=s.split("( = )|( \\+ )");
			if(sp[0].contains("machula")==true)System.out.println((Integer.parseInt(sp[2])-Integer.parseInt(sp[1]))+" + "+sp[1]+" = "+sp[2]);
			else if(sp[1].contains("machula")==true)System.out.println(sp[0]+" + "+(Integer.parseInt(sp[2])-Integer.parseInt(sp[0]))+" = "+sp[2]);
			else if(sp[2].contains("machula")==true) System.out.println(sp[0]+" + "+sp[1]+" = "+(Integer.parseInt(sp[0])+Integer.parseInt(sp[1])));
			else pr(sp[0]+" + "+sp[1]+" = "+sp[2]);
		}
	}
}