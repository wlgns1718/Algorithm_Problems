import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int con,x,y,nx,ny;
	static ArrayList<Data> con_list = new ArrayList<>();
	static Data house, festival;
	static Queue<Data> queue = new ArrayDeque<>();
	static boolean[] visit;
	public static class Data{
		int x;
		int y;
		public Data(int x, int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public String toString() {
			return "Data [x=" + x + ", y=" + y + "]";
		}

	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 0; tc<TC; tc++) {
			con = Integer.parseInt(br.readLine());

			for(int i = 0; i< con+2; i++) {

				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				if(i==0) {
					house = new Data(a,b);
				}
				else if(i == con+1) {
					festival = new Data(a,b);
				}
				else {
					con_list.add(new Data(a,b));
				}

			}
			visit = new boolean[con_list.size()];
			System.out.println(sol(house));
			con_list.clear();
			queue.clear();
		}


	}

	public static String sol(Data start) {
		queue.offer(start);
		while (!queue.isEmpty()) {
			Data cur_point = queue.poll();
			x = cur_point.x;
			y = cur_point.y;
			//현재 위치에서 페스티벌에 도착 할 수 있으면 해피 리턴
			if(Math.abs(x-festival.x)+Math.abs(y-festival.y)<= 1000) {
				return "happy";
			}
			for(int i = 0; i<con_list.size(); i++) {//현재 위치에서 갈 수 있는 모든 편의점 담기
				if(visit[i]) continue;
				Data next_con = con_list.get(i);
				nx = next_con.x;
				ny = next_con.y;
				if(Math.abs(x-nx)+Math.abs(y-ny) <= 1000) {
					visit[i] = true;
					queue.offer(next_con);
				}
			}
		}

		return "sad";
	}

}
