class Fruits{
	public static void main(String[] args) throws java.lang.Exception{
		java.io.BufferedReader b = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int t = Integer.parseInt(b.readLine());
		while(t-->0){
			String line = b.readLine();
			String nums[] = line.split(" ");
			int n = Integer.parseInt(nums[0]);
			int m = Integer.parseInt(nums[1]);
			int k = Integer.parseInt(nums[2]);
			if(n==m){
				System.out.println(0);
			}
			else{
				if(k > Math.abs(n-m))System.out.println(0);
				else System.out.println(Math.abs(n-m)-k);
			}
		}
	}
}