//Min Max Riddle
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	static long[] riddle(long[] arr) {
		
		// arr[i]의 largest window size 
		long[] lefts = leftWinSize(arr);
		long[] rights = rightWinSize(arr);

	    SortedMap<Long, Long> numberToWinSize = new TreeMap<>(Collections.reverseOrder());
	    
	    for(int i=0; i<arr.length; i++){
	      numberToWinSize.put(
	        arr[i],
	        Math.max(numberToWinSize.getOrDefault(arr[i], (long) -1),lefts[i] + rights[i] + 1)); // 왼쪽으로 갈 수 있는 win 크기, 오른쪽으로 갈 수 있는 win 크기, 자기자신(win 크기 = 1)
	    }
	    
	    Iterator<Long> iter = numberToWinSize.keySet().iterator();
	    long number = iter.next();
	    long[] result = new long[arr.length];
	    
	    for(int i=0; i<result.length; i++){
	    	
	      while(numberToWinSize.get(number) <= i){
	        number = iter.next();
	      }
	      result[i] = number;
	    }
	    
	    return result;
	 }
	
	 // arr[i]의 왼쪽만 고려했을 때 최대 win size
	  static long[] leftWinSize(long[] arr){
		  long[] lefts = new long[arr.length];
	    Stack<Integer> indices = new Stack<>();
	    
	    for(int i=0; i<arr.length; i++){
	      while(!indices.isEmpty() && arr[i] <= arr[indices.peek()]){
	        indices.pop();
	      }
	      lefts[i] = i - (indices.isEmpty() ? 0 : indices.peek() + 1);
	      indices.push(i);
	    }
	    
	    return lefts;
	  }
	  
	  // arr[i]의 오른쪽만 고려했을 때 최대 win size
	  static long[] rightWinSize(long[] arr){
		  long[] rights = new long[arr.length];
	    Stack<Integer> indices = new Stack<>();
	    
	    for(int i=arr.length-1; i>=0; i--){
	    	
	      while(!indices.isEmpty() && arr[i] <= arr[indices.peek()]){
	        indices.pop();
	      }
	      rights[i] = (indices.isEmpty() ? arr.length : indices.peek()) - i - 1;
	      indices.push(i);
	    }
	    return rights;
	  }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        
    	int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        long[] arr = new long[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long arrItem = Long.parseLong(arrItems[i]);
            arr[i] = arrItem;
        }

        long[] res = riddle(arr);
        
        for (int i = 0; i < res.length; i++) {
            bufferedWriter.write(String.valueOf(res[i]));

            if (i != res.length - 1) {
                bufferedWriter.write(" ");
            }
            
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


//BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));