// Hash Tables : Ice Cream Parlor
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Solution {

    // Complete the whatFlavors function below.
    static void whatFlavors(int[] cost, int money) {
    	
    	
    	Hashtable<Integer , Integer> ht = new Hashtable<Integer , Integer>();
    	
    	for( int i = 0 ; i < cost.length ; i++) {
    		ht.put(i+1, cost[i]);
    	}
    	
    	Arrays.sort(cost);
    	
    	int pairV1 = -1;
    	int pairV2 = -1;
    	
    	for( int i = 0 ; i < cost.length ; i++) {
    		boolean isExist = false;
    		
    		int spentCost = cost[i];
    		int leftCost = money - spentCost;
    		
    		int left = i + 1;
    		int right = cost.length -1;
    		
    		while(left <= right) {
    			int mid = left + ((right - left) / 2);
    			if( cost[mid] == leftCost ) {
    				isExist = true;
    				pairV1 = spentCost;
    				pairV2 = cost[mid];
    				///System.out.println( (i+1) + " " + (mid + 1));
    				break;
    				//return;
    			}    				
    			else if( cost[mid] > leftCost) {
    				right = mid -1;
    			}else {
    				left = mid + 1;
    			}
    		}
    		
    		if( isExist )
    			break;
    	}
    	
    	int index1 = -1 ; int index2 = -2;
    	
    	for (Map.Entry<Integer, Integer> entry : ht.entrySet()) {
    		
    		if( entry.getValue() == pairV1) {
    			
    			if( index1 < 0) {
    				index1 = entry.getKey();
    			}
    			else {
    				index2 = entry.getKey();
    			}
    				
    		}
    		
    		if( entry.getValue() == pairV2) {
    			index2 = entry.getKey();
    		}
    	    //System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
    		
    	}
    	
    	System.out.println(Math.min(index1, index2) + " " + Math.max(index1, index2));
    	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int money = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] cost = new int[n];

            String[] costItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int costItem = Integer.parseInt(costItems[i]);
                cost[i] = costItem;
            }

            whatFlavors(cost, money);
        }

        scanner.close();
    }
}



//BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));