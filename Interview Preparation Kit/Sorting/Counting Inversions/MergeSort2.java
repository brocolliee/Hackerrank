import java.util.Scanner;

import Utils.ArrayUtils;

public class MergeSort2 {
	
	private static int[] array;
	public static void startMS2() {
		
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
		mergesort2(0, num);

		System.out.println("***************");
		ArrayUtils.printArray(array); 
		sc.close();
	}

	public static  void mergesort2(int start_i, int end_i) {
		int mid;
		if( end_i - start_i > 1) {

			mid = (start_i + end_i) / 2;
			
			mergesort2(start_i , mid);
			mergesort2(mid , end_i);
			merge2(start_i , mid , end_i);

		}

		
	}
	
	public static void merge2(int start_i, int mid ,  int end_i) {
		
		int[] local_array = new int[end_i - start_i];
		int local_i = 0;
		
		int tmp_1 = start_i;
		int tmp_2 = mid ;
		
		
		while(tmp_1 < mid && tmp_2 < end_i) {
			if( array[tmp_1] < array[tmp_2]) {
				local_array[local_i] = array[tmp_1];
				tmp_1++;
			}
			else {
				local_array[local_i] = array[tmp_2];
				tmp_2++;
			}
			local_i++;
		}
		
		if( tmp_1 >= mid) {
			while(tmp_2 < end_i) {
				local_array[local_i] = array[tmp_2];
				tmp_2++;
				local_i++;
			}
		}else {
			while(tmp_1 < mid) {
				local_array[local_i] = array[tmp_1];
				tmp_1++;
				local_i++;
			}
		}

		
		for( int i = 0 ; i < local_array.length ; i++) {
			array[start_i] = local_array[i]; 
			start_i++;
		}

		
	}
	// 8 6 74 23 62 5 4 55 35 15
}
