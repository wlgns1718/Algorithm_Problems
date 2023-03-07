import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int zero, one = 0;
	static StringBuilder sb = new StringBuilder();
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String temp;
		map = new int[N][N];
		for(int i =0; i<N; i++) {
			temp = br.readLine();
			for(int j = 0; j<N; j++) {
				map[i][j] = temp.charAt(j) == '0' ? 0 : 1; 
			}
		}
		
		sol(N,0,0);
		String str = sb.toString();
		System.out.println(str);

	}
	public static void sol(int size, int start_x, int start_y) {
		one = 0;
		zero = 0;
		if(size == 1) {
			sb.append(map[start_x][start_y]);
			return;
		}
		for(int i = start_x; i<start_x+size; i++) {
			for(int j = start_y; j <start_y+size; j++) {
				if(map[i][j] == 1) {
					one++;
				}
				else {
					zero++;
				}
			}
		}
		if(one == size*size) {
			sb.append("1");
			return;
		}
		else if(zero == size*size) {
			sb.append("0");
			return;
		}
		else {
			sb.append("(");
			sol(size/2, start_x,start_y);
			sol(size/2,start_x,start_y+size/2);
			sol(size/2,start_x+size/2,start_y);
			sol(size/2,start_x+size/2,start_y+size/2);
			sb.append(")");
			
		}
	}

}