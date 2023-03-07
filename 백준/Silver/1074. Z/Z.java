import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,r,c;
	static int idx = 0;
	static boolean check;
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		 N = Integer.parseInt(st.nextToken());
		 r = Integer.parseInt(st.nextToken());
		 c = Integer.parseInt(st.nextToken());
		 int temp = (int) Math.pow(2, N);
		 sol(temp,0,0);

	}
	public static void sol(int size, int start_x, int start_y ) {
		if (check) return;
		if (size==1) {
			if(start_x == r && start_y == c) {
				System.out.println(idx);
				check = true;
			}
			idx++;
			return;
		}
		if(!(start_x <= r && r <= start_x+size && start_y <= c && c <= start_y+size)) {
			idx += size*size;
			return;
		}
		sol(size/2, start_x,start_y);
		sol(size/2,start_x, start_y + size/2);
		sol(size/2,start_x+ size/2,start_y);
		sol(size/2,start_x + size/2, start_y+ size/2);
	}
}