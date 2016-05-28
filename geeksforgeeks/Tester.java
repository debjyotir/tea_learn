import java.util.Arrays;
import java.util.Random;



public class Tester{
	public static void main(String[] args) {
		// qsortTester();
		mergeSortTester();
	}

	static void qsortTester(){
		Random generator = new Random();
		int[] numbers = new int[generator.nextInt(10)];
		
    	for (int i = 0; i < numbers.length; i++) {
    	  	numbers[i] = generator.nextInt(100);
    	}
		QuickSort qsort = new QuickSort(numbers,numbers.length);
		qsort.printList();
		qsort.procedure(0,numbers.length-1);
		qsort.printList();
	}
	static void mergeSortTester(){
		Random generator = new Random();
		Double[] numbers = new Double[generator.nextInt(10)];
		
    	for (int i = 0; i < numbers.length; i++) {
    	  	numbers[i] = generator.nextDouble()*10;
    	}
		MergeSort msort = new MergeSort(numbers);
		msort.printList();
		msort.divider(0,numbers.length-1);
		msort.printList();
	}
}