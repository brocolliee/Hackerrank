// Candies
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the candies function below.
    static long candies(int n, int[] arr) {
    	long totalCandies = 0;
    	
    	int[] candiesPerChild = new int[n];
    	
    	//Initialize
    	for( int i = 0 ; i < n ; i++) {
    		candiesPerChild[i] = 1;
    	}
    	
    	// a : 배열 앞에 있는 것 & b : 배열 뒤에 있는 것
    	
    	// Forward
    	for(int i = 0 ; i < n - 1  ; i++) {
    		int a = arr[i];
    		int b = arr[i+1];
    		
    		if(a < b && candiesPerChild[i] >= candiesPerChild[i+1]) {
    			
    			candiesPerChild[i+1] = candiesPerChild[i] + 1;
    			
    		}
    	}
    	
    	// Backward
    	for( int i = n - 1 ; i > 0 ; i--) {
    		int b = arr[i];
    		int a = arr[i-1];
    		
    		if( a > b && candiesPerChild[i] >= candiesPerChild[i-1]) {
    			
    			candiesPerChild[i-1] = candiesPerChild[i] + 1;
    		}
    	}
    	
    	for( int i = 0 ; i < n ; i++) {
    		totalCandies += candiesPerChild[i];
    	}
    	
    	return totalCandies;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
    	
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        long result = candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


//BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));