//Common Child
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the commonChild function below.
    static int commonChild(String s1, String s2) {

    	int[][] arr = new int[s1.length() +  1][s2.length() + 1]; 
    	
    	for( int i = 0 ; i< s1.length() ; i++) {
    		char c1 = s1.charAt(i);
    		
    		for( int j = 0 ; j < s2.length() ; j++) {
    			char c2 = s2.charAt(j);
    			
    			if(c1 == c2) {
    				arr[i+1][j+1] = arr[i][j] +1;
    			}else {
    				arr[i+1][j+1] = Math.max(arr[i][j+1],arr[i+1][j]);
    			}
    			
    		}
    	}
    	
    	return arr[s1.length()][s2.length()];
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = commonChild(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

