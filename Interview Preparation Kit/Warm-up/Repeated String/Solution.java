// Repeated String
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
    	long result = 0;
    	
    	long aCount = 0;
    	char[] strChars = s.toCharArray();
    	
    	for( int i = 0 ; i < strChars.length ; i++) {
    		if( strChars[i] == 'a')
    			aCount++;
    	}
    	
    	result = (n / strChars.length ) * aCount;
    	
    	for( int i = 0 ; i < (n % strChars.length ) ; i++ ) {
    		if( strChars[i] == 'a')
    			result++;
    	}
    	
    	return result;
    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		String s = scanner.nextLine();
		long n = scanner.nextLong();
		
		long result = repeatedString(s, n);

		System.out.println(result);

		scanner.close();
	}

}
