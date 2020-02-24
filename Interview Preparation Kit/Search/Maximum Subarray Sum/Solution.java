//Maximum Subarray Sum
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the maximumSum function below.
    static long maximumSum(long[] a, long m) {
        
    	long max = 0;
        
    	long sum = 0;
    	
    	TreeSet<Long> ts = new TreeSet<Long>();
        for( int i = 0 ; i < a.length ; i++) {
        	sum = (sum + a[i]) % m;
        	
        	max = Math.max(max, sum);
        	
        	Long tmp = ts.higher(sum);
        	
        	if(tmp != null) {
        		max = Math.max(max, (sum - tmp + m ) % m);
        	}
        	
        	ts.add(sum);
            
        }
        
        return max;
    }
    
    /*
    // Time Limit : O(n^2)
    static long maximumSum(long[] a, long m) {
        long max = 0;
        
        for( int i = 0 ; i < a.length ; i++) {
            long sum = 0;
            for( int j = i; j < a.length ; j++) {
                sum += a[j];
                long mTmp = sum % m;
                if( mTmp > max)
                    max = mTmp;
                if( max == m -1)
                    return max;
            }
            
        }
        
        return max;
    } 
     */
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            long m = Long.parseLong(nm[1]);

            long[] a = new long[n];

            String[] aItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                long aItem = Long.parseLong(aItems[i]);
                a[i] = aItem;
            }

            long result = maximumSum(a, m);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}


//BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));