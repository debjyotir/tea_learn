import java.util.Random;
class BubbleSort<E>{
	E[] list;
	int size;

	BubbleSort(E[] arr){
		list=arr;
		size=list.length;
	}
	void BubbleSorter(){
		int loops=0;
		int sorted=1;
		for(int j=size-1;j>=0;j--){
			sorted=1;
			for(int i=1;i<=j;i++){
				if(((Comparable)list[i-1]).compareTo((Comparable)list[i]) > 0){
					E temp = list[i-1];
					list[i-1] = list[i];
					list[i] = temp;
					sorted=0;
				}
			}
			if(sorted==1){break;}
			loops++;
		}
		System.out.println("loops : "+loops);
	}
	void printList(){
		for(int i=0;i<size;i++){
			System.out.print(list[i]+" ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		Random r = new Random();
		Integer[] list = new Integer[r.nextInt(10)];
		for(int i=0;i<list.length;i++){
			list[i] = r.nextInt(30);
		}
		BubbleSort bs = new BubbleSort(list);
		bs.printList();
		bs.BubbleSorter();
		bs.printList();
	}
}