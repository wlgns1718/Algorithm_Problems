import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	static int N,answer;
	static int[] length,list;
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		
		int TC = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc<=TC; tc++) {
			answer = 0;
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			length = new int[N];
			list = new int[N];
			for(int i = 0; i<N; i++) {//배열 생성
				list[i] = Integer.parseInt(st.nextToken());
			}
			for(int i = 0; i<N; i++) {
				length[i] = 1;
				for(int j = 0; j<i; j++) {
					if(list[j] < list[i]) {
						length[i] = Math.max(length[i], length[j]+1);
					}
				}
			}
			for(int i=0; i<N; i++) {
				if(answer < length[i]) {
					answer = length[i];
				}
			}
			System.out.printf("#%d %d%n",tc,answer);
		}
	}
}