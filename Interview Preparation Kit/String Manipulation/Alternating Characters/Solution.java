// Alternating Characters
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the alternatingCharacters function below.
    static int alternatingCharacters(String s) {

    	int count = 0;
    	int sLen = s.length();
    	
    	// �ٷ� �� ĳ���� �����ϱ� ���� .
    	char cTmp = s.charAt(0);
    	
    	for(int i = 1 ; i < sLen; i++) {
    		char sC = s.charAt(i);
    		
    		if( cTmp == sC)
    			count++;
    		cTmp = sC;
    	}
    	
    	return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String s = scanner.nextLine();

            int result = alternatingCharacters(s);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
