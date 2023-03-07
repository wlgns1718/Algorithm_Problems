import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static boolean tri;
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i = N; i<=M; i++) {
			if (i==1) continue;
			tri = true;
			for(int j = 2; j<((int) Math.sqrt(i)) + 1; j++) {
				if(i % j ==0) {
					tri = false;
					break;
				}
			}
			if(tri) {
				bw.write(i+"\n");
			}
		}
		bw.close();
	}
}