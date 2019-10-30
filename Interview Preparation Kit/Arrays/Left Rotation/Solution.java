// Arrays: Left Rotation
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the rotLeft function below.
    static int[] rotLeft(int[] a, int d) {
    	int[] result = new int[a.length];
    	
    	for(int i = 0 ; i < result.length ; i++) {
    		int tmp = i - d;
    		
    		if( tmp < 0 ) {
    			result[result.length + tmp ] = a[i];
    		}else {
    			result[tmp ] = a[i];
    		}
    	}
    	
    	return result;
    }
    
	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);

		for( int i = 0 ; i < result.length; i++) {
			System.out.print(result[i] + " ");
		}
		System.out.println();
		
		scanner.close();
	}

}
