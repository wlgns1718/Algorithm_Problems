import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.nio.BufferUnderflowException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	static int[] answer = new int[2];
	static int[] arr = new int[9];
	static int[] brr = new int[9];
	static int sum = 0;
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i =0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum += arr[i];
		}//배열 생성
		for(int i = 0; i<9; i++) {
			brr[i] = arr[i];
		}
		Arrays.sort(arr);
		sum -=100;
		int start = 0;
		int end = 8;
		while (true) {
			if(arr[start]+arr[end] == sum) {
				answer[0] = start;
				answer[1] = end;
				break;
			}
			else if(arr[start]+arr[end] > sum) {
				end -= 1;
			}
			else {
				start += 1;
			}
		}
		int temp1 = arr[start];
		int temp2 = arr[end];
		for (int i = 0; i<9; i++) {
			if(brr[i] == temp1 || brr[i] ==temp2) continue;
			System.out.println(brr[i]);
		}
	}
}
