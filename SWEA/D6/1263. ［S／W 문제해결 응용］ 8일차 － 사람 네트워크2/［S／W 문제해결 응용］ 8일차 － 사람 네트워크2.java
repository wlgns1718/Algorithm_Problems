import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] dp;
	static int answer,temp;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int tc = 1; tc<=TC; tc++) {
			answer = 987654321;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			dp=new int[N][N];
			for(int i = 0; i<N; i++) {
				for(int j = 0; j<N; j++) {
					dp[i][j] = Integer.parseInt(st.nextToken());
					if(dp[i][j]==0 || i==j) {
						dp[i][j] = 987654321;
					}
				
				}
			}
			for(int k=0; k<N; k++) {
				for(int i = 0; i<N; i++) {
					for(int j=0; j<N; j++) {
						dp[i][j] = Math.min(dp[i][j], dp[i][k]+dp[k][j]);
					}
				}
			}
			for(int i =0; i<N; i++) {
				temp = 0;
				for(int j = 0; j<N;j++) {
					if(i==j) continue;
					temp += dp[i][j];
				}
				if(answer>temp) {
					answer = temp;
				}
			}
			
			
			System.out.printf("#%d %d%n",tc,answer);
			
		}

	}

}
