// Abbreviation
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the abbreviation function below.
    static String abbreviation(String a, String b) {

    	
    	if(b.length() > a.length())
    		return "NO";
    	
    	int aUpperCount = 0;
    	for( int i = 0 ; i < a.length() ; i++) {
    		if(a.charAt(i) < 97)
    			aUpperCount++;
    	}
    	
    	if(aUpperCount > b.length())
    		return  "NO";
    	
    	int[][] checkMatched = new int[a.length()][b.length()];
    	
    	// 초기 작업
    	if(a.charAt(0) == b.charAt(0) || a.charAt(0) - b.charAt(0) == 32) {
    		checkMatched[0][0] = 1;
    	}
    	
    	for(int aIndex = 1 ; aIndex < a.length(); aIndex++) {
    		char bChar = b.charAt(0);
    		char aChar = a.charAt(aIndex);
    		//System.out.print("aChar : " + aChar + " & bChar : " + bChar);
    		if(aChar == bChar || bChar == (char) (aChar -32)) {
    			checkMatched[aIndex][0] = 1;
    		}else {
    			if(aChar < 97) {
    				break;
    			}
    			
    			if(checkMatched[aIndex-1][0] == 1) {
    				checkMatched[aIndex][0] = 1;
    			}
    		}
    		//System.out.println(" - checkMatched : " + checkMatched[aIndex][0]);
    	}
    	//System.out.println();
    	
    	
    	for(int bIndex = 1; bIndex < b.length() ; bIndex++) {
    		
    		char bChar = b.charAt(bIndex);
    		
    		for(int aIndex = bIndex; aIndex < a.length() ; aIndex++) {
    			
    			char aChar = a.charAt(aIndex);
    			
    			//System.out.print("aChar : " + aChar + " & bChar : " + bChar);
    			
    			if(aChar == bChar){ // upper case and same
    				
    				checkMatched[aIndex][bIndex] = checkMatched[aIndex-1][bIndex-1];
    				
    			}else if(aChar - bChar == 32){ // lower case and same
    				
    				if(checkMatched[aIndex-1][bIndex-1] == 1 || checkMatched[aIndex-1][bIndex] ==1)
    					checkMatched[aIndex][bIndex] = 1;
    				
    			}else {
    				if(aChar >= 97)
    					checkMatched[aIndex][bIndex] = checkMatched[aIndex-1][bIndex];
    			}

    			//System.out.println(" - checkMatched : " + checkMatched[aIndex][bIndex]);
    			
    		}
    		//System.out.println();
    	}
    			
    	if(checkMatched[a.length() -1][b.length() -1] == 0)
    		return "NO";
    	
    	return "YES";
    	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}


//BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));