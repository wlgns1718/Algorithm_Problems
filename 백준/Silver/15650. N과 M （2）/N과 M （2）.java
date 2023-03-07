import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[] arr;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 범위
		M = Integer.parseInt(st.nextToken());// 갯수
		arr = new int[N];
		m1(0,1);
		bw.close();

	}
	public static void m1(int idx, int start) throws Exception {
		if (idx == M) {
			for(int temp = 0; temp<M; temp++) {
				bw.write(arr[temp]+ " ");
			}
			bw.write("\n");
			return;
		}
		for (int i = start; i <= N; i++) {
			arr[idx] = i;
			m1(idx + 1, i + 1);
		}
	}
}
