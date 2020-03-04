//Making Candies
// 참고 한 코드 https://github.com/charles-wangkai/hackerrank/tree/master/making-candies
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
	static long divideToCeil(long x, long y) {
		return x / y + (x % y == 0 ? 0 : 1);
	}
	
    // Complete the minimumPasses function below.
    static long minimumPasses(long m, long w, long p, long n) {
    	
    	if (BigInteger.valueOf(m).multiply(BigInteger.valueOf(w)).compareTo(BigInteger.valueOf(n)) > 0) {
			return 1;
		}

		long minPass = Long.MAX_VALUE;
		long currentPass = 0;
		
		long totalCandies = 0;
		
		long printNum = 0;
		while (true) {
			System.out.println(printNum++);
			
			long currentCandies = m * w ; // 현재 얻을 수 있는 사탕 수
			long remainCandies = n - totalCandies ; // 목표 까지 남은 사탕 수
			
			// 현재 상태에서 남은 pass 횟수
			long remainPass = remainCandies / currentCandies;
			if(remainCandies % currentCandies > 0)
				remainPass++;
			
			minPass = Math.min(minPass, currentPass + remainPass); // 최소값 저장 하기
			
			// 남은 pass 가 하나 이하일 경우
			if (remainPass <= 1) {
				break;
			}
			
			// p가 현재 가지고 있는 사탕보다 개수가 커서 사지 못할 경우
			if (totalCandies < p) {
				
				// 현재 상태가 계속 유지 될거 가정 하고 pass와 사탕 계산
				long extraPass = (p - totalCandies) / currentCandies;
				if((p - totalCandies) % currentCandies > 0)
					extraPass++;
				
				currentPass += extraPass;
				
				totalCandies += extraPass * currentCandies;
				
				// 목표 개수 도달 했을 때
				if (totalCandies >= n) {
					minPass = Math.min(minPass, currentPass);
					break;
				}
			}

			// 하나만 샀다고 가정 하고 p만큼 빼고 w 혹은 m 증가 시키기
			totalCandies -= p;
			
			if (m <= w) {
				m++;
			} else {
				w++;
			}
		}
		return minPass;
    	
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] mwpn = scanner.nextLine().split(" ");

        long m = Long.parseLong(mwpn[0]);

        long w = Long.parseLong(mwpn[1]);

        long p = Long.parseLong(mwpn[2]);

        long n = Long.parseLong(mwpn[3]);

        long result = minimumPasses(m, w, p, n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}


//BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));