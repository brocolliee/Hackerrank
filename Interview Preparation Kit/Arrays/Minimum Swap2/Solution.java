// Minimum Swaps 2
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
    	
    	int count = 0;
    	
    	int index = 0;
    	while(index < arr.length ) {
    		if(arr[index] == index + 1) {
    			index ++ ;
    			
    		}else {
    			int swIndex = arr[index] -1;
        		int tmp = arr[index];
        		arr[index] = arr[swIndex];
        		arr[swIndex] = tmp;
        		count ++;
    		}
    		
    	}
    	
    	return count;
    }
    
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int res = minimumSwaps(arr);
        System.out.println(res);
        /*
        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();
        */
        scanner.close();
    }

}
