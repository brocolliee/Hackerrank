// Max Min
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maxMin function below.
    static int maxMin(int k, int[] arr) {
    	int result  = 100000 ;
    	
    	Arrays.sort(arr);
    	
    	for( int i = 0 ; i < arr.length - k  +1 ; i++) {
    		int tmp = arr[i+k -1 ] - arr[i];
    		
    		if( tmp < result )
    			result = tmp;
    		
    		if( result == 0 )
    			break;
    	}
    	
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int k = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int arrItem = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
            arr[i] = arrItem;
        }

        int result = maxMin(k, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


//BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));