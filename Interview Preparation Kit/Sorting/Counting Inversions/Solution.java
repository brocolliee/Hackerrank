// Merge Sort : Counting Inversions
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
	public static void printArray(int[] arr) {
    	for( int i = 0 ; i < arr.length ; i++) {
    		System.out.print(arr[i] + " ");
    	}
    	System.out.println();
    }
    // Complete the countInversions function below.
    static long countInversions(int[] arr) {
    	long result = 0;
    	result = mergesort(arr, new int[arr.length], 0 , arr.length -1);
    	
    	return result;
	}
	
	public static long mergesort(int[] array , int[] temp , int leftStart , int rightEnd) {
		if( leftStart >= rightEnd) {
			return 0;
		}
		
		int middle = (leftStart + rightEnd) / 2;
		
		long count = mergesort(array, temp,leftStart, middle);
		count += mergesort(array,temp, middle + 1 , rightEnd );
		count += mergeHalves(array, temp,  leftStart , rightEnd);
		
		return count;
	}
	
	public static long mergeHalves(int[] array , int[] temp , int leftStart, int rightEnd) {
		long count= 0;
		int leftEnd = (rightEnd + leftStart) /2;
		int rightStart = leftEnd + 1;
		
		int size = rightEnd - leftStart + 1;
		
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		
		while(left <= leftEnd && right <= rightEnd) {
			if(array[left] <= array[right]) {
				temp[index] = array[left];
				left++;
				
			}else {
				temp[index] = array[right];
				count += right - index;
				right++;
			}
			index++;
		}
        
		System.arraycopy(array, left, temp, index,  leftEnd - left + 1);
		System.arraycopy(array, right, temp, index,  rightEnd - right + 1);
		System.arraycopy(temp, leftStart, array, leftStart, size);
		
		return count;
	}
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] arr = new int[n];

            String[] arrItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int arrItem = Integer.parseInt(arrItems[i]);
                arr[i] = arrItem;
            }

            long result = countInversions(arr);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
