//Frequency Queries
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

	// Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {

        List<Integer> result = new ArrayList<>();
        Hashtable<Integer, Integer> nHT = new Hashtable<Integer, Integer>();
        Hashtable<Integer, Integer> freqHT = new Hashtable<Integer, Integer>();
        
        for( int i = 0 ; i < queries.size() ; i++) {
        	List<Integer> query= queries.get(i);
        	int qNum = query.get(0);
            int n = query.get(1);
            if(qNum ==3) {
            	int freq = freqHT.getOrDefault(n, 0);
            	if(freq > 0){
                    result.add(1);
                }else {
                    result.add(0);
                }
            	
            }
            else if( qNum == 1) {
            	int freq = nHT.getOrDefault(n, 0);
            	if( freq > 0 ) {
            		freqHT.put(freq, freqHT.get(freq) - 1);
            		if( freqHT.get(freq) == 0 ) {
            			freqHT.remove(freq);
                    }
            	}
            	freq++;
                nHT.put(n, freq);
                freqHT.put(freq,freqHT.getOrDefault(freq, 0) + 1 );
                
            }else if( qNum == 2) {
                
            	int freq = nHT.getOrDefault(n, 0);
            	if( freq > 0 ) {
            		freqHT.put(freq, freqHT.get(freq) - 1);
            		if( freqHT.get(freq) == 0 ) {
            			freqHT.remove(freq);
                    }
            		freq--;
                    nHT.put(n,freq);
                    freqHT.put(freq, freqHT.getOrDefault(freq, 0) + 1 );
                    
                    if( nHT.get(n) == 0 ) {
                        nHT.remove(n);
                    }
            	}
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        int q = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, q).forEach(i -> {
            try {
                queries.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> ans = freqQuery(queries);

        bufferedWriter.write(
            ans.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
