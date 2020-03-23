// Balanced Brackets
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the isBalanced function below.
    static String isBalanced(String s) {
    	char[] brackets = s.toCharArray();
    	
    	Stack<Character> openBrackets = new Stack<Character>();
    	
    	for( int i = 0 ; i < brackets.length ; i++) {
    		if(brackets[i] == '(' || brackets[i] == '{' || brackets[i] == '[' ) {
    			openBrackets.add(brackets[i]);
    		}else {
    			
    			if(openBrackets.isEmpty()) {
    				return "NO";
    			}
    			
    			char openBracket = openBrackets.pop();
    			char pairBracket = 0;
    			switch(brackets[i]){
    			case ')':
    				pairBracket = '(';
    				break;
    			case '}':
    				pairBracket = '{';
    				break;
    			case ']':
    				pairBracket = '[';
    				break;
    			}
    			
    			if(openBracket != pairBracket) {
    				return "NO";
    			}
    		}
    	}
    	
    	if(!openBrackets.isEmpty()) {
			return "NO";
		}
    	
    	return "YES";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);

            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}


//BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));