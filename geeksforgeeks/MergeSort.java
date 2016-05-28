public class MergeSort<E>{
	private E[] values;
	private int size;

	MergeSort(E[] vals){
		values=vals;
		size=values.length;
	}
	void divider(int left,int right){
		if(left<right){
			int mid = (left+right)/2;
			divider(left,mid);
			divider(mid+1,right);
			merger(left,mid,right);
		}
	}

	void merger(int left,int mid,int right){
		E[] sorted_values = (E[])new Object[right-left+1];
		int l=left,r=mid+1;
		int sorted_values_looper = 0;
		while(l<=mid && r<=right){
			if(((Comparable)values[l]).compareTo((Comparable)values[r])<0) sorted_values[sorted_values_looper++]=values[l++];
			else sorted_values[sorted_values_looper++]=values[r++];
		}
		while(l<=mid) sorted_values[sorted_values_looper++] = values[l++];
		while(r<=right) sorted_values[sorted_values_looper++] = values[r++];
		sorted_values_looper=0;
		while(left<=right){
			values[left++]=sorted_values[sorted_values_looper++];
		}
	}
	void printList(){
		for (int i=0;i<size ;i++ ) {
			System.out.print(values[i]+" ");
		}
		System.out.println();
	}
}