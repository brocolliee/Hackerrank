//Sherlock and Anagrams
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

	 // Complete the sherlockAndAnagrams function below.
    static int sherlockAndAnagrams(String s) {
    	Hashtable<String, Integer> subWords = new Hashtable<String, Integer>();
    	int result = 0;
    	
    	for( int i = 0 ; i < s.length() ; i++) {
    		
    		for( int j = i + 1 ;  j <= s.length() ; j++) {
    			
    			String[] tmp = s.substring(i, j).split("");
    			Arrays.sort(tmp);
    			
    			String word = "";
    			for(String t : tmp) {
    				word += t;
    	    	}
    			
    			if( subWords.containsKey(word)) {
    				subWords.replace(word, subWords.get(word) + 1);
    				
    			}
    			else {
    				
    				subWords.put(word, 1);
    			}
    			
    		}
    		
    	}
    	
    	Set<String> keys = subWords.keySet();
    	Iterator<String> it = keys.iterator();
		while (it.hasNext()) {
			String k = it.next();
			int val = subWords.get(k);
			result += val * (val -1) / 2;
		}
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = sherlockAndAnagrams(s);
            
            System.out.println(result);
            //bufferedWriter.write(String.valueOf(result));
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}