//Making Anagrams
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makeAnagram function below.
    static int makeAnagram(String a, String b) {
    	
    	int deleteNum =0 ;
    	int containNum = 0;
    	
    	int aLen = a.length();
    	int bLen = b.length();
    	
    	HashMap<Character, Integer> aHm = new HashMap<Character, Integer>();
    	
    	for(int i = 0 ; i < aLen ; i++) {
    		char c = a.charAt(i);
    		aHm.put(c, aHm.getOrDefault(c, 0) +1 );
    	}
    	
    	for( int i = 0 ; i < bLen; i++) {
    		char c = b.charAt(i);
    		
    		if( aHm.containsKey(c) ) {
    			
    			aHm.put(c, aHm.get(c)-1);
    			if(aHm.get(c) == 0 )
    				aHm.remove(c);
    			containNum++;
    		}
    	}
    	
    	
    	
    	deleteNum = aLen - containNum;
    	deleteNum += bLen - containNum;
    	
    	return deleteNum;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = scanner.nextLine();

        String b = scanner.nextLine();

        int res = makeAnagram(a, b);

        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
