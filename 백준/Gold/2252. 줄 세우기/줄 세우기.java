import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	
	public static class Node{
		int vertex;
		Node link;
		public Node(int vertex, Node link) {
			this.vertex = vertex;
			this.link = link;
		}
		
	}
	static int N,M;
	static Node[] list;
	static int[] InDegree;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new Node[N+1];
		InDegree = new int[N+1];
		int from,to;
		for(int i = 0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			from = Integer.parseInt(st.nextToken());
			to = Integer.parseInt(st.nextToken());
			list[from] = new Node(to,list[from]);
			InDegree[to]++;
		}
		ArrayList<Integer> list = sol();
		if(list.size() == N) {
			for(int ls : list) {
				bw.write(ls+" ");
			}
		}
		else {
			System.out.println(-1);
		}
		bw.close();
		
	}
	static ArrayList<Integer> sol() {
		ArrayList<Integer> arr = new ArrayList<>();
		Queue<Integer> queue = new ArrayDeque<>();
		
		for(int i = 1; i <N+1; i++) {
			if(InDegree[i]==0) queue.offer(i);
		}
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			arr.add(cur);
			for(Node temp = list[cur]; temp != null; temp = temp.link) {
				InDegree[temp.vertex] -= 1;
				if(InDegree[temp.vertex] == 0) {
					queue.offer(temp.vertex);
				}
			}
		}
		return arr;
	}
	
}