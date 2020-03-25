//Largest Rectangle
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the largestRectangle function below.
    static long largestRectangle(int[] h) {
    	
    	// codes from discussion
    	Stack<Integer> hS = new Stack<>(); 
	    
    	long maxArea = 0;
    	
    	int index = 0;
    	while(index < h.length) {
    		
    		if( hS.isEmpty() || h[hS.peek()] <= h[index] ) {
    			hS.add(index);
    			index++;
    		
    		}else {
    			int topIndex = hS.pop();
    			if(!hS.isEmpty()) {
    				maxArea = Math.max(maxArea, h[topIndex] * (index - hS.peek() -1 ));
    			}else {
    				maxArea = Math.max(maxArea, h[topIndex] * index );
    			}
    			
    		}
    	}
    	//System.out.println("index = " + index);
    	
    	while(!hS.isEmpty()) {
    		//System.out.println(hS);
    		int topIndex = hS.pop();
			if(!hS.isEmpty()) {
				maxArea = Math.max(maxArea, h[topIndex] * ( index - hS.peek() -1 ));
				//System.out.println(maxArea);
			}else {
				maxArea = Math.max(maxArea, h[topIndex] * index );
			}
    	}
    	
	    return maxArea;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] h = new int[n];

        String[] hItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int hItem = Integer.parseInt(hItems[i]);
            h[i] = hItem;
        }

        long result = largestRectangle(h);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


//BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));