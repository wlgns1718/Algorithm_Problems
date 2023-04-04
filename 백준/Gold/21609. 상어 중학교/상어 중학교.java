import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int answer = 0;
	static int N,M,cnt,nx,ny;
	static int[][] map;
	static int[] dx = {1,-1,0,0};
	static int[] dy = {0,0,1,-1};
	static int[] block_number;
	static boolean[][] visit;
	static Queue<Data> queue = new ArrayDeque<>();
	static boolean tri;
	static ArrayList<block> block = new ArrayList<>();
	static int zero_count;

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

	public static class block{
		Data data;
		int cnt;
		int zero_cnt;
		public block(Data data, int cnt,int zero_cnt) {
			this.data = data;
			this.cnt = cnt;
			this.zero_cnt = zero_cnt;
		}
		@Override
		public String toString() {
			return "block [data=" + data + ", cnt=" + cnt + "]";
		}

	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());//행렬 크기
		M = Integer.parseInt(st.nextToken());//색상의 개수
		block_number = new int[M+1];
		map = new int [N][N]; // 맵 생성
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken()); // 맵 채우기
			}
		}
		//0은 무지개 블럭 -1은 벽


		while(true) {
			serach();
			tri = getPoint();
			if(!tri)break;

			gravity();
			spin();
			gravity();

		}
		System.out.println(answer);



	}




	public static void spin() {//반시계로 돌리기
		int[][] temp_map = new int[N][N];
		for(int i = 0; i<N; i++) {
			for(int j = N-1, p = 0; j>=0; j--,p++ ) {
				temp_map[j][i] = map[i][p];
			}
		}

		for(int i =0; i<N; i++) {
			for(int j = 0; j<N; j++) {
				map[i][j] = temp_map[i][j];
			}
		}
	}


	public static void gravity() {//증력 설정

		for(int i = N-1; i>=0; i--) {
			for(int j = N-1; j>=0; j--) {
				if(map[i][j] == -1)continue; //벽이면 통과
				//벽이 아니고 밑에 공간이 있다면 숫자 내려주기 빈공간은 -2
				int temp = i;
				while(temp+1<N && map[temp+1][j]==-2) {//범위를 벗어 나지 않고 밑에 공간이 빈공간이라면 내리기
					map[temp+1][j] = map[temp][j];
					map[temp][j] = -2; //기존 공간은 빈 공간으로 설정
					temp++;
				}
			}
		}	
	}

	public static void serach() {//제거할 벽돌 찾기
		//인접한 블록의 개수가 모두 1인경우 게임 종료
		visit = new boolean[N][N];//방문처리 초기화
		queue.clear();
		for(int i = 0; i<N; i++) {
			for(int j = 0; j < N; j++) {
				//빈공간이면 패스
				if(map[i][j] == -1 || map[i][j] == 0 || map[i][j]== -2)continue; //검은블록이나 무지개 블록이면 패스
				if(visit[i][j])continue; //방문한 블럭이면 패스
				queue.add(new Data(i,j));
				visit[i][j] = true;//방문처리
				cnt = 1;
				zero_count = 0;
				while(!queue.isEmpty()) {//인접한 모든 블록 찾기
					//제거할 블록 개수 초기화
					Data cur_point = queue.poll();
					for(int idx = 0; idx<4; idx++) {
						nx = cur_point.x + dx[idx];
						ny = cur_point.y + dy[idx];
						//범위 체크
						if(nx < 0 || ny < 0 || nx>= N || ny >= N)continue;
						//벽돌체크
						if(map[nx][ny]== -1 || map[nx][ny]==-2) continue;
						//같은 숫자 체크 또는 무지개 블럭 체크
						if(visit[nx][ny]) continue;

						//						System.out.println(map[i][j]);


						if(map[nx][ny] == map[i][j] || map[nx][ny]==0) {
							if(map[nx][ny]==0) zero_count++;
							//같은 숫자면 큐에 담고 방문처리 해주고 cnt + 1
							queue.offer(new Data(nx,ny));
							visit[nx][ny] = true;
							cnt++;
						}
					}
				}
				//인접한 블록 모두 찾았으면 무지개 블록은 다시 방문처리 뺴주기
				block.add(new block(new Data(i,j), cnt,zero_count)); //기준 블럭과 인접 블록 개수 담기
				//무지개 블록 다시 미방문 처리 해주기
				for(int p = 0; p<N; p++) {
					for(int q = 0; q< N; q++) {
						if(map[p][q] == 0) {
							visit[p][q] = false;
						}
					}
				}





			}
		}

	}




	static boolean getPoint() {
		Data start = new Data(100,100);
		int block_cnt = 0;
		int zero_temp = 0;
		for(int i=0; i<block.size(); i++) {
			block cur = block.get(i);
			if(cur.cnt >= block_cnt) {//얻을 수 있는 점수가 더 많을 때
				//만약 점수가 같으면

				if(cur.cnt == block_cnt) {//점수가 같은 경우
					//행먼저 비교
					if(cur.zero_cnt== zero_temp) {
						if(cur.data.x == start.x) {//현재 블록이 행이 더 우선일 때
							if(cur.data.y > start.y) {//점수도 같고 행도 같을 때
								start = cur.data;
								block_cnt = cur.cnt;
								zero_temp = cur.zero_cnt;
							}

						}
						else if(cur.data.x > start.x){//행이 더 우선되면
							start = cur.data;
							block_cnt = cur.cnt;
							zero_temp = cur.zero_cnt;

						}
					}
					else if(cur.zero_cnt > zero_temp) {
						start = cur.data;
						block_cnt = cur.cnt;
						zero_temp = cur.zero_cnt;
					}
				}


				else {//점수가 더 큰 경우
					start = cur.data;
					block_cnt = cur.cnt;
					zero_temp = cur.zero_cnt;

				}
			}

		}
		if(block_cnt <= 1) {//최대로 제거할 블록이 1일 때
			return false;
		}

		else {//제거할 블록이 2개 이상일 때
			//점수 얻기
			answer += (block_cnt*block_cnt);
			//인접한 블록 전부 제거 > -2로 만들어 주기
			queue.clear();
			queue.offer(start);
			int temp = map[start.x][start.y];
			map[start.x][start.y] = -2;
			while(!queue.isEmpty()) {
				Data cur_point = queue.poll();
				for(int idx = 0; idx<4; idx++) {
					nx = cur_point.x + dx[idx];
					ny = cur_point.y + dy[idx];
					//범위 체크
					if(nx < 0 || ny < 0 || nx>=N || ny >= N)continue;
					//-1 체크
					if(map[nx][ny] ==-1) continue;
					//빈공간 체크
					if(map[nx][ny]==-2) continue;
					if(map[nx][ny] == 0 || map[nx][ny]==temp) {
						map[nx][ny] = -2;
						queue.offer(new Data(nx,ny));
					}
				}
			}
			//리스트 전부 초기화 해주기
			block.clear();
			return true;
		}
	}

}
