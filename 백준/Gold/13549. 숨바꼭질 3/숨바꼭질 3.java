import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
	
	static int N,K;
	static int min = Integer.MAX_VALUE;
	static Queue<Data> queue = new ArrayDeque<>();
	static HashSet<Integer> visit = new HashSet<>();
	public static class Data{
		int x;
		int cnt;
		public Data(int x, int cnt) {
			super();
			this.x = x;
			this.cnt = cnt;
		}
		
	}
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//수빈이 위치
		K = Integer.parseInt(st.nextToken());// 동생 위치
		ArrayList<Integer> answer = new ArrayList<>();
		queue.offer(new Data(N,0));
		while(!queue.isEmpty()) {
			Data cur = queue.poll();
			if(cur.x==K) {
				answer.add(cur.cnt);
			}
			visit.add(cur.x);
			if(cur.x + 1<= 100000 && !visit.contains(cur.x+1)) {
				queue.offer(new Data(cur.x+1,cur.cnt+1));
			}
			if(0 <= cur.x - 1 && !visit.contains(cur.x-1)) {
				queue.offer(new Data(cur.x-1,cur.cnt+1));
			}
			if(cur.x*2<= 100000 && !visit.contains(cur.x*2)) {
				queue.offer(new Data(cur.x*2,cur.cnt));
			}
		}
		for(int i : answer) {
			if(min > i) {
				min = i;
			}
		}
		System.out.println(min);
		
	}

}