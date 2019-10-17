import java.io.IOException;
import java.util.Scanner;

public class Solution {

	// Complete the sockMerchant function below.
	static int sockMerchant(int n, int[] arr) {
		
		int pairs = 0;
		int[] socks = new int[100];
		
		for( int i = 0 ; i < n; i++) {
			
			socks[arr[i]-1] ++;
			
		}
		
		//get pairs
		for( int i = 0 ; i < socks.length ; i++) {
			
			pairs += socks[i] / 2;
		}
		
		return pairs;
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		
		int n = scanner.nextInt();

		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		int result = sockMerchant(n, arr);

		System.out.print(result);

		scanner.close();
	}

}
