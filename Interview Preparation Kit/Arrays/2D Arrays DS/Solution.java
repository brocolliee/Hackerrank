// 2D Array - DS
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the hourglassSum function below.
    static int hourglassSum(int[][] arr) {
    	
    	int[][] hourglass = {{1,1,1},
    						 {0,1,0},
    						 {1,1,1}};

    	int max = calculate(arr, 0, 0);
    	
    	for( int i = 0 ; i < 4 ; i++) {
    		for( int j = 0 ; j < 4 ; j++) {
    			int tmp = calculate(arr, i, j);
    			if( max < tmp)
    				max = tmp;
    		}
    	}
    	
    	return max;
    }
    
    static int calculate(int[][] arr , int x1, int y1) {
    	int[][] hourglass = {{1,1,1},
				 			 {0,1,0},
				 			 {1,1,1}};
    	int sum = 0;
    	for( int i = 0 ; i < 3 ; i++) {
    		for( int j = 0 ; j < 3; j++) {
    			sum+= hourglass[i][j] * arr[x1+i][y1+j];
    		}
    	}
    	
    	return sum;
    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

        int result = hourglassSum(arr);

		System.out.println(result);

		scanner.close();
	}

}
