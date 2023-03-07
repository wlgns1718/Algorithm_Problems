import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.nio.BufferUnderflowException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] S,B;
	static boolean[] selected;
	static int N;
	static int MIN;
	static int s,b;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		S = new int[N];
		B = new int[N];
		selected = new boolean[N];
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			S[i] = Integer.parseInt(st.nextToken());
			B[i] = Integer.parseInt(st.nextToken());
		}
		MIN = Math.abs(B[0] - S[0]);
		solution(0);
		System.out.println(MIN);
		
	}
	public static void solution(int idx) {
		if(idx==N) {
			s=1;
			b=0;
			for(int i = 0; i<N; i++) {
				if(selected[i]) {
					s *= S[i];
					b += B[i];
				}
			}
			if (b==0) {
				return;
			}
			if(MIN> Math.abs(s-b)) {
				MIN = Math.abs(s-b);
			}
			return;
		}
		
		selected[idx] = true;
		solution(idx+1);
		selected[idx] = false;
		solution(idx+1);
		
	}
	
	
}
