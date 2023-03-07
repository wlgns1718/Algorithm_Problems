import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	static int V,E,start,from,to,w;
	static int[] D;
	static ArrayList<ArrayList<Data>> list = new ArrayList<>();
	public static class Data{
		int idx;
		int w;
		public Data(int idx, int w) {
			super();
			this.idx = idx;
			this.w = w;
		}
		
		
		
	}
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(br.readLine());
		D = new int[V+1];
		for(int i =0; i<V+1; i++) {
			list.add(new ArrayList<>());
		}
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			list.get(from).add(new Data(to,w));
		}
		final int INF = 987654321;
		D = new int[V+1];
		Arrays.fill(D, INF);
		PriorityQueue<Data> pq = new PriorityQueue<>((a,b) -> a.w-b.w);
		pq.offer(new Data(start,0));
		Data cur;
		D[start] = 0;
		int weight, index;
		while(!pq.isEmpty()) {
			cur = pq.poll();
			for(int i = 0; i < list.get(cur.idx).size(); i++) {
				index = list.get(cur.idx).get(i).idx;
				weight = list.get(cur.idx).get(i).w;
				if(D[index] > D[cur.idx]+weight) {
					D[index] = D[cur.idx]+ weight;
					pq.offer(new Data(index,D[index]));
				}
				
				  
			}
			
		
		}
		for(int i =1; i<V+1; i++) {
			System.out.println(D[i] == 987654321 ? "INF":D[i]);
		}
	}

}