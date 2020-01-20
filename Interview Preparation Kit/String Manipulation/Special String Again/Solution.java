//Special String Again
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the substrCount function below.
    static long substrCount(int n, String s) {
    	long count = 0;
    	
    	char[] strChars = s.toCharArray();
    	
    	for( int i = 0 ; i < strChars.length ; i++) {
    		
    		boolean isDiff = false;
    		char firstChar = strChars[i];
    		int leftLen = 1;
    		int rightLen = 0;
    		count++;
    		
    		for( int j = i + 1  ; j < strChars.length; j ++) {
    			char cmpChar = strChars[j];
    			System.out.print(firstChar + " vs " + cmpChar + " => ");
    			if( isDiff) {
    				System.out.print("diff - " );
    				if( cmpChar == firstChar ) {
    					rightLen++;
    					if( leftLen == rightLen) {
    						System.out.println("count!" );
    						count++;
    						break;
    					}
    				}else {
    					System.out.println("not count!" );
						break;
    				}
    				
    			}else {
    				System.out.print("same - " );
    				if( cmpChar == firstChar ) {
    					System.out.println("count!" );
    					count++;
    					leftLen++;
    				}
    				else {
    					System.out.println("not count!" );
    					isDiff = true;
    					
    				}
    					
    			}
    			
    		}
    	}
    	
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        long result = substrCount(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
