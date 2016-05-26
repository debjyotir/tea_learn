public class ImportantFunctions{
	public static char[] insertionSort(char[] a){
		int n = a.length;
		for (int i=0; i<n; i++) {
			char cur = a[i];
			int j=i-1;
			while((j>=0)&&(a[j]>cur))
				a[j+1]=a[j--];
			a[j+1]=cur;
		}
		return a;
	}

	public static void main(String[] args) {
		int wow;
		char[] a = {'a','c','g','d','b'};
		char[] s = insertionSort(a);
		System.out.println(s);
	}
}