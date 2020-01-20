//Sherlock and the Valid String
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isValid function below.
    static String isValid(String s) {
    	String result = "NO" ; // "YES"
    	
    	HashMap<Character , Long> cHm = new HashMap<Character , Long>();
    	HashMap<Long , Long> nHm = new HashMap<Long , Long>();
    	
    	for( int i = 0 ; i < s.length(); i++) {
    		char cTmp = s.charAt(i);
    		
    		long num = cHm.getOrDefault(cTmp, (long) 0) + 1;
    		cHm.put(cTmp, num );
    		
    		nHm.put(num, nHm.getOrDefault(num, (long) 0) + 1);
    		
    		if( i > 0) {
        		nHm.put(num - 1, nHm.getOrDefault(num-1, (long) 0) -1);
        		if(nHm.get(num-1) <= 0)
        			nHm.remove(num -1);
    		}
    		
    	}
    	
    	int nSize = nHm.size();
    	
    	if(nSize == 1) {
    		result = "YES";
    	}else if(nSize== 2) {
    		
    		Set<Long> keys = nHm.keySet();
    		Object[] kArray = keys.toArray();
    		
    		Long key1 = (Long) kArray[0];
    		Long key2 = (Long) kArray[1];
    		
    		Long diff = key1 - key2;
    		System.out.println(key1 + ": " + nHm.get(key1));
    		System.out.println(key2 + ": " + nHm.get(key2));
    		
    		
    		if( key1 == 1 && nHm.get(key1) == 1)
    			result = "YES";
    		else if(key2 == 1 && nHm.get(key2) == 1)
    			result = "YES";
    		else if ( diff == 1 && nHm.get(key1) == 1)
    			result = "YES";
    		else if( diff == -1 && nHm.get(key2) == 1)
    			result = "YES";
    	}
    	
    	return result;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String result = isValid(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
