import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.nio.BufferUnderflowException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int H,W,N,cur_x,cur_y,temp_x,temp_y;
	static String[][] map;
	static String temp,temp1;
	static String input;
	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int TC = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=TC; tc++) {
			st = new StringTokenizer(br.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new String[H][W];
			for(int i = 0; i<H; i++) { //게임 맵 생성
				input = br.readLine();
				for(int j=0; j<W; j++) {
					map[i][j] = String.valueOf(input.charAt(j));
					if (map[i][j].equals("^") || map[i][j].equals("v") || map[i][j].equals("<") || map[i][j].equals(">")) {
						cur_x = i;
						cur_y = j;
					}
				}
			}
			N = Integer.parseInt(br.readLine()); // 명령 개수
			temp = br.readLine();
			for (int i = 0; i<N; i++) {
				temp1 = String.valueOf(temp.charAt(i));
				order(temp1,cur_x,cur_y);
			}
			bw.write("#"+tc+" ");
			for ( int p = 0; p < H; p++) {
				for (int q = 0; q < W; q++) {
					bw.write(map[p][q]);
				}
				bw.write("\n");
			}
			
			
			
		}
		bw.close();

	}
	public static void order(String ord,int x,int y) {
		switch(ord) {
			case "U":
				if(x-1>=0 && map[x-1][y].equals(".")) {//위쪽으로 갈 수 있는 경우
					map[x][y] = ".";
					map[x-1][y] = "^";
					cur_x = x-1;
				}
				else {
					map[x][y] = "^";
				}
				break;
			case "D":
				if(x+1<H && map[x+1][y].equals(".")) {//밑쪽으로 갈 수 있는 경우
					map[x][y] = ".";
					map[x+1][y] = "v";
					cur_x = x+1;
				}
				else {
					map[x][y] = "v";
				}
				break;
			case "L":
				if(y-1 >=0 && map[x][y-1].equals(".")) {//왼쪽으로 갈 수 있는 경우
					map[x][y] = ".";
					map[x][y-1] = "<";
					cur_y = y-1;
				}
				else {
					map[x][y] = "<";
				}
				break;
			case "R":
				if(y + 1 < W && map[x][y+1].equals(".")) {//왼쪽으로 갈 수 있는 경우
					map[x][y] = ".";
					map[x][y+1] = ">";
					cur_y = y+1;
				}
				else {
					map[x][y] = ">";
				}
				break;
			case "S":
				temp_x = x;
				temp_y = y;
				if (map[x][y].equals("^")){
					while (temp_x-1 >=0) {
						if(map[temp_x-1][y].equals(".") || map[temp_x-1][y].equals("-")) {
							temp_x --;
							continue;
						}
						else if(map[temp_x-1][y].equals("#")) {
							break;
						}
						else if(map[temp_x-1][y].equals("*")) {
							map[temp_x-1][y] = ".";
							break;
						}
					}
				}
				else if (map[x][y].equals("v")){
					while (temp_x+1 <H) {
						if(map[temp_x+1][y].equals(".") || map[temp_x+1][y].equals("-")) {
							temp_x ++;
							continue;
						}
						else if(map[temp_x+1][y].equals("#")) {
							break;
						}
						else if(map[temp_x+1][y].equals("*")) {
							map[temp_x+1][y] = ".";
							break;
						}
					}
					
				}
				else if (map[x][y].equals("<")){
					while (temp_y-1 >=0) {
						if(map[x][temp_y-1].equals(".") || map[x][temp_y-1].equals("-")) {
							temp_y --;
							continue;
						}
						else if(map[x][temp_y-1].equals("#")) {
							break;
						}
						else if(map[x][temp_y-1].equals("*")) {
							map[x][temp_y-1] = ".";
							break;
						}
					}
					
				}
				else if (map[x][y].equals(">")){
					while (temp_y+1 < W) {
						if(map[x][temp_y+1].equals(".") || map[x][temp_y+1].equals("-")) {
							temp_y ++;
							continue;
						}
						else if(map[x][temp_y+1].equals("#")) {
							break;
						}
						else if(map[x][temp_y+1].equals("*")) {
							map[x][temp_y+1] = ".";
							break;
						}
					}
					
				}
				break;
		}
	}
}
