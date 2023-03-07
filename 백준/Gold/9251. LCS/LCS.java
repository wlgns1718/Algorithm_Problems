import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static String a,b;
	static int cnt;
	static int[][] dp;
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		b = br.readLine();
		a = br.readLine();
		dp = new int[a.length()+1][b.length()+1];
		for(int i = 0; i < a.length()+1; i++) {
			for(int j = 0; j<b.length()+1; j++) {
				if(i==0 || j==0) {
					dp[i][j] = 0;
					continue;
				}
				dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				if(a.charAt(i-1)==b.charAt(j-1)) {
					dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
				}
				
			}
		}
		System.out.println(dp[a.length()][b.length()]);
		
		
	}

}