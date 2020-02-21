//Minimum Time Required
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minTime function below.
    static long minTime(long[] machines, long goal) {
    	
    	long days = 0 ;
    	//long count = 0;
    	
    	Arrays.sort(machines);
    	
    	long maxDay = machines[machines.length -1] * goal;
    	long minDay = 1;
    	
    	while( minDay <= maxDay) {
            
            long midDay = (maxDay + minDay) /2 ;
            long cTmp = 0;
            
            for( int i = 0 ; i < machines.length ;i++) {
            	cTmp += midDay / machines[i];
            }
            
            if( cTmp > goal ) {
            	maxDay = midDay -1;
            }else if(cTmp < goal) {
            	minDay = midDay + 1;
            }else {
            	break;
            }
        }
    	// 정확한 값을 못찾았을 경우
    	if(minDay > maxDay ) {
    		days = minDay;
    	}
    	// 정확한 값이 있을 경우 범위 안에서 계산
    	while(minDay <= maxDay ) {
    		long cTmp = 0;
            
            for( int i = 0 ; i < machines.length ;i++) {
            	cTmp += minDay / machines[i];
            }
            
            if( cTmp == goal) {
            	days= minDay;
            	break;
            }
            else
            	minDay++;
    	}
    	
    	return days;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] nGoal = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nGoal[0]);

        long goal = Long.parseLong(nGoal[1]);

        long[] machines = new long[n];

        String[] machinesItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            long machinesItem = Long.parseLong(machinesItems[i]);
            machines[i] = machinesItem;
        }

        long ans = minTime(machines, goal);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

//BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));