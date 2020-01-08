import java.util.Scanner;

import Utils.ArrayUtils;

public class QuickSort {

	private static int[] array;
	public static void startQS() {
		int num = 0 ;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Length of Array: " );
		num = sc.nextInt();
		
		array = new int[num];

		System.out.print("Enter Array: " );
		for( int i = 0 ; i < num ; i++) {
			array[i] = sc.nextInt();
			
		}
		
		ArrayUtils.printArray(array);
		quicksort(0, num);
		System.out.println("************************");
		ArrayUtils.printArray(array); 
		sc.close();
	}

	public static void quicksort(int start_i , int end_i) {

		if( start_i < end_i) {
			int pivot_i = start_i; 
			pivot_i = partition( pivot_i , end_i );
			

			quicksort(start_i , pivot_i );
			quicksort(pivot_i + 1 , end_i);
		}
	}
		
		
	public static int partition(int start_i ,int end_i) {
		int tmp;
		int pivot_i = start_i;
		int low_i = start_i;
		int length = end_i - start_i;
		
		if( length > 1) {
			
			for( int i = pivot_i + 1 ; i < end_i; i++) {
				if( array[pivot_i] > array[i]  ) {
					low_i++;
					tmp = array[i];
					array[i] = array[low_i];
					array[low_i] = tmp;
				}
			}
			
			tmp = array[pivot_i];
			array[pivot_i] = array[low_i];
			array[low_i] = tmp;
			
			pivot_i = low_i;
			
		}
		
		return pivot_i;
	}
	

	//8
	//15 22 13 27 12 10 20 25 
}
