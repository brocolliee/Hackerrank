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
            long a = arr.get(i); // �迭�� �ִ� �� �ϳ� ��������
            long aDr = a / r; // a ������ r �� ������ ��� ������ ����  �� a �ٷ� ���� ���� ����
            long aRr = a % r; // �������� 0�̾������ ����
            //System.out.println("a : " + a);
            
            if( numHT.containsKey(aDr) && aRr == 0) { // ���࿡  a/r �� ���ڰ� ������ arr �迭���� a/r�� a������ �����Ѵٴ� ��
            	long c = numHT.get(aDr); // a/r�� ������ ���������
            	recordHT.put(a, recordHT.getOrDefault(a, 0L) + c); // a ���忡�� ������ �� �ִ� a/r�� ���� ���
            	//System.out.println("c : " + c);
            }
            
            if( recordHT.containsKey(aDr)  && aRr == 0) { //  aDr �� ���� record �� ���� �Ѵٴ� ���� aDr ���� �� (a/r�� ����) ���� �ִٴ� ������ ��� ���� ���� 
            	count += recordHT.get(aDr); // ���� �� �ִ� ������ ���� �����ֱ�
            	//System.out.println("count: " + count);
            }
            
           numHT.put(a, numHT.getOrDefault(a, 0L) + 1);
        }
        
        // r �� 1�� �� ���Ӱ� �������.
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