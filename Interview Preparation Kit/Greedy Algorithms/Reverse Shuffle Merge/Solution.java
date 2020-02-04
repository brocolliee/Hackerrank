// Reverse Shuffle Merge
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the reverseShuffleMerge function below.
	static String reverseShuffleMerge(String s) {
		
	    int a = 'a';
	    int m = 'z' - a + 1;
	    
	    int[] frequency = new int[m]; // 빈도수 계산
	    
	    s.chars().forEach(c -> frequency[c - a]++); // 빈도수 계산
	    
	    int[] count = Arrays.stream(frequency).map(f -> f / 2).toArray(); // count로 기록

	    int top = -1;
	    int[] stack = new int[s.length()]; // 문자 stack
	    
	    // reversed 된 문자열이 섞여 있기 때문에 거꾸로 
	    for(int n = s.length(); --n >= 0; ) {
	    	
	        int c = s.charAt(n) - a; // s의 현재 위치에 있는 char 숫자 받아오기
	        
	        frequency[c]--; // 빈도수 하나 빼주고
	        
	        if(count[c] < 1) continue; // count 가 1보다 작으면 반복문 끝으로 이동

	        // count[c] 가  1 이상일 때 수행
	        count[c]--; // count[c] 하나 빼주기 ( 이미 그 문자열 사용됨을 기록 ) 
	        while(top >= 0 && /* stack에 무언가가 들어가 있을 때 */
	            stack[top] > c && /* stack[top](stack맨 위)에 있는 것이 c 보다 클 때 */
	            frequency[stack[top]] > count[stack[top]] /*stack[top](stack맨 위)에 있는 것의 빈도수 보다 count가 작을 때 -> 짝꿍은 남아있고 문자 하나 들어온 경우 */) 
	        {
	        	// pop 하는 이유  : 알파벳 순으로 가장 작은 거를 찾아야하기 때문에 
	        	count[stack[top--]]++; // Increment and then pop the stack
	        }
	        
	        // stack에 숫자(char의 숫자) 기록
	        stack[++top] = c; // Push c on to the stack
	    }
	    
	    // stack에 있는 문자 string으로 만들어 주기
	    return java.util.stream.IntStream.rangeClosed(0, top)
	        .mapToObj(c -> Character.toString((char)(stack[c] + a)))
	        .collect(java.util.stream.Collectors.joining(""));
	}
    
    
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    	BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = scanner.nextLine();

        String result = reverseShuffleMerge(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}



//BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));