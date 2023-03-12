import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	static int N, M;
	static int MAX_W;
	static int temp;
	static int[] snack = new int[2];
	static int[] snacks;

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int TC = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= TC; tc++) {
			MAX_W = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());// 과자 개수
			snacks = new int[N];
			M = Integer.parseInt(st.nextToken());// 무게 제한

			st = new StringTokenizer(br.readLine());
			for (int p = 0; p < N; p++) {
				snacks[p] = Integer.parseInt(st.nextToken());
			}
			sol(0, 0);
			if(MAX_W == 0) {
				MAX_W = -1;
			}
			bw.write("#"+tc+" "+MAX_W+"\n");
		}
		bw.close();

	}

	public static void sol(int idx, int start) {
		if (idx == 2) {
			temp = 0;
			for (int i = 0; i < 2; i++) {
				temp += snack[i];
				
			}
			if (temp<= M && temp > MAX_W) {
				MAX_W = temp;
			}
			return;
		}
		for (int j = start; j < N; j++) {
			snack[idx] = snacks[j];
			sol(idx + 1, j + 1);
		}
	}

}