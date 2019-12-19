//Hash Tables: Ransom Note
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
	// Complete the checkMagazine function below.
    static void checkMagazine(String[] magazine, String[] note) {
    	Hashtable<String, Integer> magazineHT = new Hashtable<String, Integer>();
    	
    	for(String mw : magazine) {
    		if(magazineHT.containsKey(mw)) {
    			magazineHT.replace(mw, magazineHT.get(mw) + 1);
    		}else {
    			magazineHT.put(mw, 1);
    		}
    	}
    	
    	for(String nw : note) {
    		if(!magazineHT.containsKey(nw) || magazineHT.get(nw) == 0  ) {
    			System.out.println("No");
    			return;
    		}
    		magazineHT.replace(nw, magazineHT.get(nw) -1);
    	}
    	
    	System.out.println("Yes");
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] mn = scanner.nextLine().split(" ");

        int m = Integer.parseInt(mn[0]);

        int n = Integer.parseInt(mn[1]);

        String[] magazine = new String[m];

        String[] magazineItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < m; i++) {
            String magazineItem = magazineItems[i];
            magazine[i] = magazineItem;
        }

        String[] note = new String[n];

        String[] noteItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            String noteItem = noteItems[i];
            note[i] = noteItem;
        }

        checkMagazine(magazine, note);

        scanner.close();
    }
}
