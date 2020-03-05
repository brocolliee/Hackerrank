//Max Array Sum 
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
	
    // Complete the maxSubsetSum function below.
    static int maxSubsetSum(int[] arr) {

    	arr[1] = Math.max(arr[0], arr[1]);
    	int maxSum = arr[1];
    	
    	// a[i]는 a[0] ~ a[i] 에서 인접하지 않은 값을 더했을 때 구할 수 있는 가장 큰 값
    	for( int i = 2 ; i < arr.length ; i++) {
    		
    		arr[i] = Math.max( arr[i] , arr[i] + arr[i-2]); // arr[i] 갱신 : 현재 arr[i]와  arr[i] + arr[i-2] 비교
    		arr[i] = Math.max(maxSum, arr[i]);
    		maxSum = Math.max(arr[i], maxSum);
    		
    	}
    	
    	/*
    	// Time limit
    	int[] sumArray = new int[arr.length];

    	for( int i = arr.length - 1 ; i >= 0 ; i--) {
    		
    		int arrVal = arr[i];
    		
    		for( int j = i + 2 ; j < arr.length ; j++) {
                sumArray[i] = Math.max(sumArray[i] , arrVal + sumArray[j]);
            }
            maxSum = Math.max(sumArray[i], maxSum);
    		
    	}
    	*/
    	return maxSum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = maxSubsetSum(arr);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


//BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));