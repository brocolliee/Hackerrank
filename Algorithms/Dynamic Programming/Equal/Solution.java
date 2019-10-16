// Equal

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


public class Solution {
	
	// Complete the equal function below.
    static int equal(int[] arr) {
    	
    	Arrays.sort(arr);
    	
    	int min = arr[0];
    	int ans = Integer.MAX_VALUE;
    	// min ~ min -4
    	for( int i = 0; i < 5 ; i++) {
    		int num = 0;
    		for( int j = 0 ; j < arr.length ; ++j) {
    			int t = arr[j] - (min - i);
    			
    			num += t/5 + t%5/2 + t%5%2;
    		}
    		ans = Math.min(ans, num);
    		
    	}
    	
    	return ans;

    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	
        
    	int t = scanner.nextInt();
    	
    	for(int i = 0 ; i < t ; i++) {
    		int n = scanner.nextInt();
    		
    		int[] arr = new int[n];
    		
    		for( int j = 0 ; j < arr.length ; j++ ) {
    			arr[j] = scanner.nextInt();
    		}
    		int result = equal(arr);

    		System.out.print(result);
    	}
    	
        scanner.close();
    }
}
