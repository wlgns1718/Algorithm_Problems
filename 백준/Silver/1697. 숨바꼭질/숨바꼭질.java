import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static Queue<Data> stack = new LinkedList<Data>(); 
	static boolean[] visit = new boolean[100001];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		stack.offer(new Data(N,0));
		visit[N] = true;
		while(!stack.isEmpty()) {
			Data cur = stack.poll();
			if (cur.x == K) {
				System.out.println(cur.cnt);
				break;
			}
			if(cur.x+1 <= 100000 && !visit[cur.x+1]) {
				stack.offer(new Data(cur.x+1,cur.cnt+1));
				visit[cur.x+1] = true;
			}
			if(cur.x-1>=0 && !visit[cur.x-1]) {
				stack.offer(new Data(cur.x-1, cur.cnt+1));
				visit[cur.x-1] = true;
			}
			if(cur.x * 2 <= 100000 && !visit[cur.x*2]) {
				stack.offer(new Data(cur.x*2,cur.cnt+1));
				visit[cur.x*2] = true;
			}
		}
	}
	static class Data{
		int x;
		int cnt;
		public Data(int x, int cnt) {
			super();
			this.x = x;
			this.cnt = cnt;
		}
		
	}
	
	
	
}