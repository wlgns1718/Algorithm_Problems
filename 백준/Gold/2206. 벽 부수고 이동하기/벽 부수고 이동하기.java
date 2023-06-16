import java.io.*;
import java.util.*;

public class Main {
    static int N,M,answer;
    static int[][] map;
    static boolean[][][] visit;
    static Queue<Data> queue = new ArrayDeque<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static class Data{
        int x;
        int y;
        int wall;
        int dis;
        public Data(int x, int y, int wall,int dis){
            super();
            this.x = x;
            this.y = y;
            this.wall = wall;
            this.dis = dis;
        }
    }
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visit = new boolean[N][M][2];
        //MAP 생성
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));

            }
        }
        visit[0][0][0] = true;
        queue.offer(new Data(0,0,0,1));
        answer = 987654321;
        while(!queue.isEmpty()){
            Data cur = queue.poll();
            if(cur.x == N-1 && cur.y == M-1){
                if(answer > cur.dis){
                    answer = cur.dis;
                }
                continue;
            }
            //현재 지점에서 갈 수 있는 경로 파악
            for(int idx = 0; idx < 4; idx++){
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];
                //범위 체크
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                //최적으로 초기화가 되어 있는지 체크
                //현재 지점에서 벽을 부순 상태인 경우
                if(cur.wall == 1){
                    if(visit[nx][ny][1]) continue;

                    if(map[nx][ny]==1){//또 벽인 경우
                        continue;
                    }
                    else{//벽이 아닌 경우
                        queue.offer(new Data(nx,ny,1,cur.dis+1));
                        visit[nx][ny][1] = true;
                    }
                }
                else{ //아직 벽을 부수지 않았을 때
                    if(visit[nx][ny][0]) continue;

                    if(map[nx][ny] == 1){ //아직 부수기 전 벽인 경우
                        queue.offer(new Data(nx,ny,1,cur.dis+1));
                        visit[nx][ny][1] = true;
                    }
                    else{
                        queue.offer(new Data(nx,ny,0,cur.dis+1));
                        visit[nx][ny][0] = true;
                    }
                }
            }

        }
       if(answer== 987654321){
           System.out.println(-1);
       }else{
           System.out.println(answer);
       }

    }

}