import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N,M,x,y,cnt;
	static int[] vilage;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int TC = Integer.parseInt(br.readLine());
		StringTokenizer st = null;
		for(int tc = 1; tc <= TC; tc++) {
			cnt = 0;
			bw.write("#"+tc+" ");
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			makeSet();
			for(int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				unionSet(x,y);
				
			}
			for(int i = 1; i<N+1; i++) {
				if(vilage[i]!=i) continue;
				cnt++;
			}
			bw.write(cnt+"\n");
		}
		bw.close();
		
	}
	
	private static void unionSet(int a, int b) {
		a = findSet(a);
		b = findSet(b);
		vilage[b] = a;
	}
	private static int findSet(int x) {
		if(vilage[x]==x) {
			return x;
		}
		
		return vilage[x] = findSet(vilage[x]);
	}
	private static void makeSet() {
		vilage = new int[N+1];
		for(int i = 0; i<N+1; i++) {
			vilage[i] = i;
		}
	}
}