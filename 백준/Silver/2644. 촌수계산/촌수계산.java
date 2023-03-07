import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Main {
	static Queue<Data> queue = new LinkedList<>();
	static boolean[] visit;
	static int temp,N,M;
	static int a,b;
	static Data cur;
	static NODE[] arr;
	static boolean tri;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		temp = Integer.parseInt(br.readLine());
		visit = new boolean[temp+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		temp = Integer.parseInt(br.readLine());
		arr = new NODE[temp+1];
		for(int i =0; i<temp; i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			arr[i] = new NODE(a,b);
		}//노드 생성
		queue.offer(new Data(N,0));
		visit[N] = true;
		while(!queue.isEmpty()) {
			cur = queue.poll();
			if (cur.node == M) {
				System.out.println(cur.cnt);
				tri = true;
				break;
			}
			for(int i = 0; i<arr.length; i++) {
				if( arr[i] != null && arr[i].x == cur.node && !visit[arr[i].y]) {
					queue.offer(new Data(arr[i].y,cur.cnt+1));
					visit[arr[i].y] = true;
				}
				if(arr[i] != null && arr[i].y == cur.node && !visit[arr[i].x]) {
					queue.offer(new Data(arr[i].x,cur.cnt+1));
					visit[arr[i].x] = true;
				}
			}
		}
		if (!tri) {
			System.out.println(-1);
		}
	}
	static class Data{
		int node;
		int cnt;
		public Data(int node, int cnt) {
			super();
			this.node = node;
			this.cnt = cnt;
		}
		
	}
	static class NODE{
		int x;
		int y;
		public NODE(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}
}