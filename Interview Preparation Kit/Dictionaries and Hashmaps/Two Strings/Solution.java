//TwoStrings
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the twoStrings function below.
    static String twoStrings(String s1, String s2) {
    	String answer = "NO"; // "NO"
    	char[] s1CharArray = s1.toCharArray();
    	char[] s2CharArray = s2.toCharArray();
    	
    	Hashtable<Character, Integer> s1HT = new Hashtable<Character, Integer>();
    	
    	for(char sc : s1CharArray) {
    		if(!s1HT.containsKey(sc)) {
    			s1HT.put(sc, 1);
    		}
    	}
    	
    	for(char sc : s2CharArray) {
    		if(s1HT.containsKey(sc)) {
    			answer = "YES";
    			break;
    		}
    	}
    	
    	return answer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s1 = scanner.nextLine();

            String s2 = scanner.nextLine();

            String result = twoStrings(s1, s2);

            System.out.println(result);
            //bufferedWriter.write(result);
            //bufferedWriter.newLine();
        }

        //bufferedWriter.close();

        scanner.close();
    }
}