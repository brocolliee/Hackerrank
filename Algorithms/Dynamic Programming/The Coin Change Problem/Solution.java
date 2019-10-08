// The Coin Change Problem

import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'getWays' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. LONG_INTEGER_ARRAY c
     */

    public static long getWays(int n, List<Long> c) {
    // Write your code here
    	long[] combination = new long[n+1];
    	combination[0] = 1;
    	
    	for( int i = 0 ; i < c.size(); i++) {
    		long coin = c.get(i);
            for( int j = (int)coin ; j < combination.length; j++) {
                if (j >= coin)
                    combination[j] += combination[(int) (j-coin)];
                
            }
            
    	}
    	
    	return combination[n];
    }
    
}

public class Solution {
    public static void main(String[] args) throws IOException {
    	
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt();
        int numOfCoin = sc.nextInt();
        Long[] coins = new Long[numOfCoin];
        
        for( int i = 0 ; i < numOfCoin ; i++) {
        	coins[i] = sc.nextLong();
        }
        
        List<Long> c = Arrays.asList(coins);
        
        long ways = Result.getWays(amount, c);
        System.out.print(ways);
        
    }
}
