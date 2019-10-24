//Jumping on the Clouds

import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the jumpingOnClouds function below.
    static int jumpingOnClouds(int[] c) {
    	int jumpNum = 0;
    	
    	int currentIndex = 0;
    	while(currentIndex < c.length - 2 ) {
    		
    		if( c[currentIndex + 2] == 0 ) {
    			currentIndex += 2;
    			
    		}else if( c[currentIndex + 1] == 0) {
    			currentIndex +=1;
    		}
    		jumpNum++;
    		
    		//System.out.println( "CI " + currentIndex);
    		//System.out.println( "jumpNum " + jumpNum);
    	}
    	
    	// currentIndex last move for one jump
    	// ex : 0 0 0 1 0 0
    	if( currentIndex < c.length - 1) {
    		jumpNum++;
    	}
    	
    	return jumpNum;
    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		int n = scanner.nextInt();
		int[] clouds = new int[n];
		for( int i = 0 ; i < n ; i++) {
			clouds[i] = scanner.nextInt();
		}
		
		int result = jumpingOnClouds(clouds);

		System.out.println(result);

		scanner.close();
	}

}
