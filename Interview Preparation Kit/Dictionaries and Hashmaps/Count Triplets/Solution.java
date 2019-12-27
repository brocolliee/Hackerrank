//Count Triplets
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

	// Complete the countTriplets function below.
    static long countTriplets(List<Long> arr, long r) {
    	Hashtable<Long, Long> numHT = new Hashtable<Long, Long>();
    	Hashtable<Long, Long> recordHT = new Hashtable<Long, Long>();
    	long count = 0;
        
        for( int i = 0 ; i < arr.size() ; i++) {
            long a = arr.get(i); // 배열에 있는 값 하나 가져오기
            long aDr = a / r; // a 나누기 r 한 값으로 등비 수열을 따질  때 a 바로 전에 오는 숫자
            long aRr = a % r; // 나머지가 0이어야지만 가능
            //System.out.println("a : " + a);
            
            if( numHT.containsKey(aDr) && aRr == 0) { // 만약에  a/r 한 숫자가 있으면 arr 배열에서 a/r이 a이전에 존재한다는 뜻
            	long c = numHT.get(aDr); // a/r의 개수를 가지고오기
            	recordHT.put(a, recordHT.getOrDefault(a, 0L) + c); // a 입장에서 선택할 수 있는 a/r의 개수 기록
            	//System.out.println("c : " + c);
            }
            
            if( recordHT.containsKey(aDr)  && aRr == 0) { //  aDr 인 값이 record 에 존재 한다는 것은 aDr 이전 값 (a/r의 제곱) 값이 있다는 뜻으로 등비 수열 생성 
            	count += recordHT.get(aDr); // 만들 수 있는 조합의 개수 더해주기
            	//System.out.println("count: " + count);
            }
            
           numHT.put(a, numHT.getOrDefault(a, 0L) + 1);
        }
        
        // r 은 1일 때 새롭게 해줘야함.
        if( r == 1) {
        	count = 0;
            Set<Long> nums = numHT.keySet();
            Iterator<Long> it = nums.iterator();
            while (it.hasNext()) {
                Long n = it.next();
                Long c = numHT.get(n);
                c = c * (c -1) * (c -2);
                c /= 6;
                count += c;
            }
        }
       
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(nr[0]);

        long r = Long.parseLong(nr[1]);

        List<Long> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Long::parseLong)
            .collect(toList());

        long ans = countTriplets(arr, r);
        
        System.out.println(ans);
        //bufferedWriter.write(String.valueOf(ans));
        //bufferedWriter.newLine();

        bufferedReader.close();
        //bufferedWriter.close();
    }
}