// Luck Balance
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
    	int luck = 0;
    	
    	
    	ArrayList<Integer> addImpLuck = new ArrayList<Integer>();
    	
    	int addCount = 0 ;
    	
    	for( int i = 0 ; i < contests.length; i++) {
    		int l = contests[i][0];
    		//System.out.print("contest " + i + " : ");
    		
    		if( contests[i][1] == 0) { // not important
    			luck += l;
    			//System.out.println("unimportant - " + luck);
    		}else {
    			int min = 10000;
    			if(addImpLuck.size() > 0 )
        			min = addImpLuck.get(0);

    			
    			if( addCount < k ) {
    				addImpLuck.add(l);
    				luck += l;
    				addCount++;
    			}else {
    				if( min < l ) {
    					addImpLuck.add(l);
    					addImpLuck.remove(0);
    					luck += l;
    					luck -= min * 2;
    					
    				}else {
    					luck -= l;
    				}
    			}
    			//System.out.println("important - " + luck);
    			Collections.sort(addImpLuck);
    		}
    	}
    	
    	return luck;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


//BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));