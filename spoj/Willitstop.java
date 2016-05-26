class Willitstop{
	public static void looper(long n){
		if (n==1) System.out.println("TAK");
		else if (n%2==0){
			if(n%3==0)System.out.println("NIE");
			else looper(n/2);
		}
		else{
			if(n%3==0)System.out.println("NIE");
			else looper(3*n+3);
		}
	}
	public static void main(String[] args) throws java.lang.Exception{
		java.io.BufferedReader b = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		long n=Long.parseLong(b.readLine());
		looper(n);
	}
}