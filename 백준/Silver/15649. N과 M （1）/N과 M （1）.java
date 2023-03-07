import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Main{
	static int N,M;
	static int[] arr;
	static boolean T;
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M];
		m1(N,M,0,arr);
		bw.close();
	}
	//N = 숫자 M은 길이
	public static void m1(int N, int M,int cur,int[] arr) throws IOException{
		if(cur == M) {
			for(int a:arr) {
				bw.write(a+" ");
				
			}
			bw.write("\n");
			return;
		}
		for(int i= 1; i<= N; i++ ) {
			T = true;
			for(int j = 0; j<cur; j++) {
				if(arr[j] == i) {
					T=false;
					break;
				}
			}
			if(!T) continue;
			arr[cur] = i;
			if (cur<M) {
				m1(N,M,cur+1,arr);
			}
		}
		
	}
}