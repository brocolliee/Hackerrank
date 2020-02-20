// Pairs
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the pairs function below.
    static int pairs(int k, int[] arr) {
    	
    	int result = 0;
    	
    	Arrays.sort(arr);

    	for( int i = 0 ; i < arr.length ;i++) {
    		
    		if( arr[i] <= k)
    			continue;
    		
    		int otherV = Math.abs(k - arr[i]);
    		int searchIndex = -1;
    		
    		if( otherV < arr[i] )
    			searchIndex = searchValue(arr, otherV, 0 , i - 1);
    		
    		else if (otherV > arr[i]){
    			searchIndex = searchValue(arr, otherV, i + 1, arr.length -1  );
    		}
    		
    		System.out.println("firstV : " + arr[i] + " , otherV : " + otherV + " => searchIndex : " + searchIndex);
    		
    		if(searchIndex >= 0 ) {
    			result++;
    			
    		}
    	}
    	return result;
    }
    
    public static int searchValue(int[] arr , int value , int left, int right) {

    	while(left <= right) {
    		int mid =  (left + right)/ 2;
    		
    		if( arr[mid] < value) {
    			left = mid + 1;
    			
    		}else if (arr[mid]> value) {
    			right = mid - 1;
    			
    		}else if (arr[mid] == value) {
    			return mid;
    		}
    	}
    	
    	return -1;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int result = pairs(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

//BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));