import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, W;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		int w,p;
		int[] dp = new int[W+1];
		for (int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			p = Integer.parseInt(st.nextToken());
			
			for(int temp = 0; temp<=W; temp++) {
				if(w>temp) {
					continue;
				}
				dp[temp-w] = Math.max(dp[temp]+p, dp[temp-w]);
			}
		}
		int max_weight = 0;
		for(int i : dp) {
			if(i>max_weight) {
				max_weight = i;
				
			}
		}
		System.out.println(max_weight);
		
	}
}
