import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		N = 1000-N;
		
		int cnt = 0;
		while(N > 4) {
			if(N>=500) {
				cnt += 1;
				N -= 500;
			}
			else if(N >= 100) {
				cnt += 1;
				N -= 100;
			}
			else if(N >= 50) {
				cnt += 1;
				N -=50;
			}
			else if(N>=10) {
				cnt += 1;
				N -= 10;
			}
			else if(N>=5) {
				cnt += 1;
				N -=5;
			}
		}
		
		cnt += N;
		System.out.println(cnt);
	}
	
	
}








