import java.util.Random;
class BinarySearch{
	int binarySearch(int arr[],int l,int r,int x){
		if(r >= l){
			int mid = (l + r)/2;
			if(x==arr[mid]) return mid;
			if(x > arr[mid]){
				return binarySearch(arr,mid+1,r,x);
			}
			else return binarySearch(arr,l,mid-1,x);
		}
		return -1;
	}
	int pivotedBinarySearch(int arr[],int size,int x){
		int pivot = findPivot(arr,0,size-1);
		if(pivot==-1) return binarySearch(arr,0,size-1,x);
		if(arr[pivot]==x) return pivot;
		if(arr[0]<=x) return binarySearch(arr,0,pivot-1,x);
		return binarySearch(arr,pivot+1,size-1,x);
	}
	int findPivot(int arr[],int l,int r){
		if(l>r) return -1;
		if(l==r) return l;

		int mid = (l+r)/2;
		if(mid > l && arr[mid] < arr[mid-1]) return mid-1;
		if(mid < r && arr[mid] > arr[mid-1]) return mid;
		if(arr[l] >= arr[mid]) return findPivot(arr,l,mid-1);
		else return findPivot(arr,mid+1,r);
	}
	void printArray(int arr[],int size){
		for(int i=0;i<size;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		BinarySearch bs = new BinarySearch();
		Random r=new Random();
		int size = r.nextInt(10);
		int arr[] = new int[size];
		for(int i=0;i<size;i++){
			arr[i] = i;
		}
		int x = r.nextInt(10);
		bs.printArray(arr,size);
		System.out.println("looking for "+x);
		System.out.println("found at "+bs.binarySearch(arr,0,size-1,x));
	}
}