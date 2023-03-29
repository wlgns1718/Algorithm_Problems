import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] select;
	static int[] nums;
	static int[][] price;
	static int answer = Integer.MAX_VALUE;
	static int N,temp;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		select = new boolean[N];
		nums = new int[N];
		price = new int[N][N];
		for(int i = 0 ; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j=0; j<N; j++) {
				price[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sol(0);
		System.out.println(answer);
	}
	static void sol(int idx) {
		if(idx == N) {
			temp = 0;
			for (int i = 0; i < N; i++) {
				if(i == N-1) {
					if(price[nums[i]][nums[0]]==0) {
						return;
					}
					temp += price[nums[i]][nums[0]];
					continue;
				}
				if (price[nums[i]][nums[i+1]] == 0) {
					return;
				}
				temp += price[nums[i]][nums[i+1]];
				
			}
			if(answer > temp) {
				answer = temp;
			}
			return;
		}
		
		for (int i = 0; i<N; i++) {
			if(select[i]==true) {
				continue;
			}
			nums[idx] = i;
			select[i] = true;
			sol(idx + 1);
			select[i] = false;
		}
	}
}
