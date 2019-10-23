//Counting Valleys
import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
    	
    	char[] path = s.toCharArray();
    	int level = 0;
    	Boolean inValley = false;
    	int countValley = 0;
    	
    	for( int i = 0 ; i < path.length ; i++) {
    		if(path[i] == 'U') {
    			level++;
    		}else if( path[i] == 'D') {
    			level--;
    		}
    		//System.out.println("level " + level);
    		if( level < 0 && inValley == false) {
    			inValley = true;
    			//countValley++;
    		}
    		if( level >= 0 && inValley == true) {
    			inValley = false;
    			countValley++;
    		}
    		
    	}
    	
    	return countValley;

    }

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		int n = scanner.nextInt();
		scanner.nextLine();
		String str = scanner.nextLine();
		
		
		int result = countingValleys(n, str);

		System.out.println(result);

		scanner.close();
	}

}
