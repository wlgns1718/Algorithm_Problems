import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int[] paper = {0,0,0,0,0,0};
	static int[][] paper_map = new int[10][10];
	static int answer = Integer.MAX_VALUE;
	static boolean tri;
	public static void main(String args[]) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		for(int i = 0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<10; j++) {
				paper_map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sol(0,0,0);
		System.out.println(answer != Integer.MAX_VALUE ? answer : -1);
		
	}
	public static void sol(int x, int y, int count) {
		if(y==10) {//끝에 다다랐다면 x+1, y = 0 으로 리턴
			sol(x+1,0,count);
			return;
		}
		if(x==10) {//맨 밑 바닥까지 왔다면 모든 경우를 탐색 한 것이므로 최솟값 비교
			if(answer > count) {
				answer = count;
			}
			return;
		}
		if(paper_map[x][y] != 0) {
			for(int i = 1; i<=5; i++) {//어떤 색종이를 붙일 수 있는지 탐색
				if(paper[i]==5) continue; //이미 다 썼다면 continue
				tri = true;
				for(int p = x; p<x+i; p++) {//현재 종이 크기로 붙일 때 0이 포함되거나 범위를 벗어난다면 break
					for(int q = y; q<y+i; q++) {
						if(q>=10 || p >= 10 || paper_map[p][q] == 0) {
							tri = false;
							break;
						}
					}
					if(!tri) { //불가능한 조건이라면 break
						break;
					}
				}
				if(!tri) {//현재 크기의 종이를 붙일 수 없을 때 다음 크기의 종이로 넘어가기
					continue;
				}
				//현재 크기의 종이를 붙일 수 있을 때 1이 되는 부분 전부 0으로 바꿔주기
				for(int p = x; p<x+i; p++) {
					for(int q = y; q<y+i; q++) {
						paper_map[p][q] = 0;
					}
				}
				paper[i] += 1;
				sol(x,y+i,count+1);
				paper[i] -= 1;
				//다시 원상태로 복구해주기
				for(int p = x; p<x+i; p++) {
					for(int q = y; q<y+i; q++) {
						paper_map[p][q] = 1;
					}
				}
				
				
			}
		}
		else {
			sol(x,y+1,count);
		}
	}
}