//Poisonous Plants
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the poisonousPlants function below.
    static int poisonousPlants(int[] p) {
    	
    	int[] days = new int[p.length];
    	int minV = p[0];
    	int finalDays = 0;
    	
    	Stack<Integer> plants = new Stack<Integer>();
    	plants.add(0);
    	
    	for( int i = 1 ; i < p.length ; i++) {
    		if(p[i-1] < p[i]) {
    			days[i] = 1;
    		}
    		
    		if( minV > p[i] ) {
    			minV = p[i];
    		}
    		//System.out.print(p[i] + " plants Size : " + plants.size() + " - " );
    		while(!plants.isEmpty() && p[plants.peek()] >= p[i]) {
    			
    			//System.out.print(" p[plants.peek()]  : " + plants.peek());
    			if(p[i] > minV) {
    				if( days[i] <= days[plants.peek()] + 1) {
    					days[i] = days[plants.peek()] + 1;
    				}
    			}
    			
    			plants.pop();
    		}
    		
    		
    		if(finalDays < days[i]) {
    			finalDays = days[i];
    		}
    		//System.out.println(" => " +  finalDays);
    		plants.push(i);
    	}
    	
    	
    	return finalDays;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] p = new int[n];

        String[] pItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int pItem = Integer.parseInt(pItems[i]);
            p[i] = pItem;
        }

        int result = poisonousPlants(p);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}



//BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));