import java.io.*;
import java.util.*;
public class Main {
    static int M,N, answer;
    static int[][] map,cnt_map;
    static Queue<Data> queue = new ArrayDeque<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    public static class Data{
        int x;
        int y;
        public Data(int x, int y){
            super();
            this.x = x;
            this.y = y;
        }
    }
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cnt_map = new int[N][M];
        //미로 생성
        for(int i = 0; i<N; i++){
            String temp = br.readLine();
            for(int j  = 0 ; j<M; j++){
                map[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
                cnt_map[i][j] = 100000;
            }
//            System.out.println(Arrays.toString(map[i]));
        }
        cnt_map[0][0] = 0;
        queue.offer(new Data(0,0));
        while(!queue.isEmpty()){
            //현재위치 뽑기
            Data cur = queue.poll();
            //현재 위치에서 갈 수 있는 경로 최소값으로 초기화
            for(int idx = 0; idx < 4; idx++){
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];
                //범위 체크
                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                //가중치 업데이트
                if(map[nx][ny] == 1){
                    //갈 수 있는 경로가 1이라면 이전 경로에서 +1
                    if(cnt_map[nx][ny] > cnt_map[cur.x][cur.y]+1){
                        //다음 지점이 현재 경로보다 값이 더 클 때만 초기화 후 queue에 담아주기
                        cnt_map[nx][ny] = cnt_map[cur.x][cur.y]+1;
                        queue.offer(new Data(nx,ny));
                    }

                }
                else{
                    //갈 수 있는 경로가 0이라면 이전 경로에서 +0
                    if(cnt_map[nx][ny] > cnt_map[cur.x][cur.y]) {
                        cnt_map[nx][ny] = cnt_map[cur.x][cur.y];
                        queue.offer(new Data(nx, ny));
                    }
                }

            }


        }
        System.out.println(cnt_map[N-1][M-1]);
    }
}