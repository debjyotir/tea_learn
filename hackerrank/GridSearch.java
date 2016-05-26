class GridSearch{
	public static void main(String[] args) throws java.lang.Exception{
		java.io.BufferedReader b = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
		int t = Integer.parseInt(b.readLine());
		while(t-->0){
			String matrixsize = b.readLine();
			String matz[] = matrixsize.split(" ");
			int R = Integer.parseInt(matz[0]);
			int r=0;
			String cols[] = new String[R];
			while(r<R){
				cols[r] = b.readLine();
				r++;
			}
			r=0;
			String csize = b.readLine();
			String csizes[] = csize.split(" ");
			int R2=Integer.parseInt(csizes[0]);
			String ccols[] = new String[R2];
			while(r<R2){
				ccols[r] = b.readLine();
				r++;
			}
			int found=0;
			r=0;
			int r2=0;
			int index=-1;
			while(r<R){
				if(cols[r].indexOf(ccols[r2]) >= 0){
					if(r2==0)index=cols[r].indexOf(ccols[r2]);
					else if(index == cols[r].indexOf(ccols[r2])){
						if(r2==R2) {found=1;break;}
					}
				r2++;
				}
				r++;
			}
			if(found==1)System.out.println("YES");
			else System.out.println("NO");
		}
	}
}