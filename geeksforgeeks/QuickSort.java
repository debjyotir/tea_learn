
public class QuickSort{
	private int[] values;
	private int size;

	QuickSort(int[] vals,int s){
		values = vals;
		size = s;
	}

	void procedure(int left,int right){
		if(right<=left) return;
		else{
			int pivot = values[left];
			int partition = partitionFunc(left,right,pivot);
			procedure(left,partition-1);
			procedure(partition+1,right);
		}
	}

	int partitionFunc(int left,int right,int pivot){
		int l=left+1;
		int r=right;
		while(true){
			while( l<=right && (values[l] < pivot)){l++;}
			while((values[r] > pivot) && r > 0 ){r--;}
			if(l >= r) break;
			else exchange(l,r);
		}
		exchange(left,r);
		return r;
	}
	private void exchange(int l,int r){
		int temp = values[l];
		values[l] = values[r];
		values[r] = temp;
	}
	void printList(){
		for (int i=0;i<size ;i++ ) {
			System.out.print(values[i]+" ");
		}
		System.out.println();
	}
}