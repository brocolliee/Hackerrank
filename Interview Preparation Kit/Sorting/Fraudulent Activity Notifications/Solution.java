// Fradulent Activity Notifications
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	// Complete the activityNotifications function below.
    static int activityNotifications(int[] expenditure, int d) {
        
        int notiNum = 0;
        
        int[] counts = new int[201];
        
        for(int i = 0 ; i < d ; i++) {
        	counts[expenditure[i]]++;
        }
        for( int i = d ; i < expenditure.length  ; i++) {
        	
        	float median = getMedian(counts, d );
        	
        	//System.out.println(i + " median : " + median + " , expenditure[i] = " + expenditure[i]);
            if( expenditure[i] >= 2 * median)
                notiNum++;
            
            counts[expenditure[i-d]]--;
            counts[expenditure[i]]++;
        }
        
        //printArray(expenditure);
        return notiNum;
    }
    
    public static void printArray(int[] arr) {
    	for( int i = 0 ; i < arr.length ; i++) {
    		System.out.print(arr[i] + " ");
    	}
    	System.out.println();
    }
    
    public static float getMedian(int[] arr , int td ) {
    
        int c = 0 ;
        float median = 0;
        
        if( td % 2 == 0  ) {
        	int tmp1 = 0;
        	int tmp2 = 0;
        	for( int i = 0 ; i < arr.length; i++) {
        		c += arr[i];
        		if( tmp1 == 0 && c >= td / 2) {
        			tmp1 = i;
        		}
        		
        		if (tmp2 == 0 && c >= td /2 + 1) {
        			tmp2 = i;
        			break;
        		}
        	}
        	
        	median = (tmp1 + tmp2 ) / 2.0f ;
        	
        	//System.out.println(median);
        	
        }else {
        	for( int i = 0 ; i < arr.length; i++) {
        		c += arr[i];
        		if( c > td / 2) {
        			median = i;
        			break;
        		}
        	}
        }
        
        return median;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] expenditure = new int[n];

        String[] expenditureItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int expenditureItem = Integer.parseInt(expenditureItems[i]);
            expenditure[i] = expenditureItem;
        }

        int result = activityNotifications(expenditure, d);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
