import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N,M,K,answer=987654321,len;
	static int[][] map;
	static int[] sel;
	static boolean[] visited;
	static Queue<Integer> queue = new ArrayDeque<>();
	static ArrayList<Data> list = new ArrayList<>();
	public static class Data{
		int r;
		int c;
		int s;
		public Data(int r, int c, int s) {
			this.r = r;
			this.c = c;
			this.s = s;
			
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i =0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int r,c,s;
		for(int i = 0 ; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			r = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			list.add(new Data(r-1,c-1,s));
		}
		len = list.size();
		sel = new int[len];
		visited = new boolean[len];
		sol1(0);
		System.out.println(answer);
	}

	public static void sol(int r, int c, int s,int[][] copy) {//r,c넣어줄때 -1하고 넣어주기
		int CNT = ((s*2)-1)/2;
		int rotation = s*2;
		int x = r-s;
		int y = c-s;
		for(int cnt = 0; cnt<=CNT; cnt++,rotation -=2) {
			for(int idx = 0; idx<4; idx++) {
				if(idx == 0) {
					
					queue.offer(copy[x+cnt][y+cnt]);
					
					for(int i=1; i<=rotation; i++) {
						queue.offer(copy[x+cnt][y+cnt+i]);
						copy[x+cnt][y+cnt+i] = queue.poll();
					}
					
				}
				else if(idx == 1) {
					
					for(int i=1; i<=rotation; i++) {
						queue.offer(copy[x+cnt+i][y+(s*2)-cnt]);
						copy[x+cnt+i][y+(s*2)-cnt] = queue.poll();
					}
					
				}
				else if(idx == 2) {
					
					for(int i=1; i<=rotation; i++) {
						
						queue.offer(copy[x+(s*2)-cnt][y+(s*2)-cnt-i]);
						copy[x+(s*2)-cnt][y+(s*2)-cnt-i] = queue.poll();
					}
					
				}
				else if(idx == 3) {
					
					for(int i=1; i<=rotation; i++) {
						queue.offer(copy[x+(s*2)-cnt-i][y+cnt]);
						copy[x+(s*2)-cnt-i][y+cnt] = queue.poll();
					}
					
				}
			}
			queue.poll();
		}
	}
	public static void sol1(int idx) {
		if(idx == len) {
			int[][] copy = new int[N][M];
			for(int k = 0; k<N; k++) {
				for(int l = 0; l<M; l++) {
					copy[k][l] = map[k][l];
				}
			}
//			System.out.println(Arrays.toString(sel));
			for(int j = 0; j < idx; j++) {
				Data cur = list.get(sel[j]);
				
				sol(cur.r,cur.c,cur.s, copy);
				//copy =3
			}
			int temp;
//			for(int i = 0; i<N; i++) {
//				System.out.println(Arrays.toString(copy[i]));
//
//			}
//			System.out.println("-----------------------------------------");
			for(int i = 0; i<N; i++) {
				temp = 0;
				for(int j = 0; j < M; j++) {
					temp += copy[i][j];
				}
				if(answer > temp) {
					answer = temp;
				}
			}
			return;
			
		}
		for(int i = 0; i < len; i++) {
			if(visited[i])continue;
			sel[idx] = i;
			visited[i] = true;
			sol1(idx+1);
			visited[i] = false;
		}
		
	}
	
	

}