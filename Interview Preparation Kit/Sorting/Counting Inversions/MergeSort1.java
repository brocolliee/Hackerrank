import java.util.Scanner;

import Utils.ArrayUtils;

public class MergeSort1 {
	
	public static void startMS() {
		
		int num = 0 ;
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Length of Array: " );
		num = sc.nextInt();
		
		int[] array = new int[num];

		System.out.print("Enter Array: " );
		for( int i = 0 ; i < num ; i++) {
			array[i] = sc.nextInt();
			
		}
		
		ArrayUtils.printArray(array);
		mergesort(array);
		sc.close();
	}
	
	public static  void mergesort(int[] a) {
		int a_length = a.length;
		
		if(a_length > 1) {
			int mid = a_length / 2;
			//System.out.print(mid + "mid");
			int[] a1 = new int[mid];
			//System.out.println(a1.length);
			
			int[] a2 = new int[a_length - mid];
			//System.out.println(a2.length);
			
			for( int i = 0 ; i < a1.length ; i++) {
				a1[i] = a[i];
			}
			
			for(int i = 0 ; i < a2.length ; i ++) {
				a2[i] = a[mid + i];
			}
			System.out.println("***************");
			ArrayUtils.printArray(a1); 
			ArrayUtils.printArray(a2);
			System.out.println("***************");
			mergesort(a1);
			mergesort(a2);
			merge(a1, a2 , a ); 
		}
		
	}
	
	public static void merge(int[] a1, int[] a2 , int[]final_a) {
		int i1 =0  , i2= 0  , f_i = 0;
		int l1 = a1.length;
		int l2 = a2.length;
		
		System.out.println("***************");
		ArrayUtils.printArray(a1); 
		ArrayUtils.printArray(a2);

		while(i1 < l1 && i2 <l2) {
			if(a1[i1] > a2[i2]) {
				final_a[f_i] = a2[i2];
				i2++;
			}else {
				final_a[f_i] = a1[i1];
				i1++;
			}
			f_i++;
		}
		
		if(i1 < i2) {
			while(i1 < l1) {
				final_a[f_i] = a1[i1];
				i1++;
				f_i++;
			}
		}else if(i1 > i2) {
			while(i2 < l2) {
				final_a[f_i] = a2[i2];
				i2++;
				f_i++;
			}
		}
		
		ArrayUtils.printArray(final_a);
		System.out.println("***************");
		
	}
}
