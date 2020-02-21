// Triple sum
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the triplets function below.
    static long triplets(int[] a, int[] b, int[] c) {
    	
    	long count = 0;
    	Arrays.sort(a);
    	Arrays.sort(b);
    	Arrays.sort(c);
        int[] ar = Arrays.stream(a).sorted().distinct().toArray();
        int[] br = Arrays.stream(b).sorted().distinct().toArray();
        int[] cr = Arrays.stream(c).sorted().distinct().toArray();
        
    	int aIndex = 0;
    	int cIndex = 0;
    	
    	for( int i = 0 ; i < br.length ; i++) {
    		
    		while(aIndex < ar.length && ar[aIndex] <= br[i]) {
    			aIndex++;
    		}
    		while(cIndex < cr.length && cr[cIndex] <= br[i]) {
    			cIndex++;
    		}
    		
    		//System.out.println("value : " + b[i] + ", a index: "+ aIndex + ", c index : "+ cIndex);
    		
    		count += ((long)aIndex)*((long)cIndex);
  
    	}
    	
    	return count;
    }
    
    public static int searchIndex(int[] arr , int value , int left, int right) {
    	int index = -1;
    	
    	while(left <= right) {
    		int mid =  (left + right)/ 2;
    		
    		if( arr[mid] < value) {
    			left = mid + 1;
    			
    		}else if (arr[mid]> value) {
    			right = mid - 1;
    			
    		}else if (arr[mid] == value) {
    			return mid;
    		}
    	}
    	
    	if( arr[left] <= value)
    		index = left;
    	
    	return index;
    }
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] lenaLenbLenc = scanner.nextLine().split(" ");

        int lena = Integer.parseInt(lenaLenbLenc[0]);

        int lenb = Integer.parseInt(lenaLenbLenc[1]);

        int lenc = Integer.parseInt(lenaLenbLenc[2]);

        int[] arra = new int[lena];

        String[] arraItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lena; i++) {
            int arraItem = Integer.parseInt(arraItems[i]);
            arra[i] = arraItem;
        }

        int[] arrb = new int[lenb];

        String[] arrbItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenb; i++) {
            int arrbItem = Integer.parseInt(arrbItems[i]);
            arrb[i] = arrbItem;
        }

        int[] arrc = new int[lenc];

        String[] arrcItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < lenc; i++) {
            int arrcItem = Integer.parseInt(arrcItems[i]);
            arrc[i] = arrcItem;
        }

        long ans = triplets(arra, arrb, arrc);

        bufferedWriter.write(String.valueOf(ans));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}

//BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));