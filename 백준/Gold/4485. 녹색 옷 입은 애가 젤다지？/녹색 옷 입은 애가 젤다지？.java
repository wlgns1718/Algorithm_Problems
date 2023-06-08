import java.util.*;
import java.io.*;



public class Main{
    static int[][] map,map_cnt;
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
    public static void  main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = null;
        int tc = 1;
        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if(N ==0) break;
            map = new int[N][N];
            map_cnt = new int[N][N];
            for(int i = 0; i<N; i++){
                //map 생성
                st = new StringTokenizer(br.readLine());
                for(int j = 0 ; j<N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    map_cnt[i][j] = 987654321;

                }
            }
            queue.offer(new Data(0,0));
            map_cnt[0][0] = map[0][0];

            while(!queue.isEmpty()){
                Data cur = queue.poll();
                //현재위치에서 갈 수 있는 곳 탐색
                for(int idx = 0; idx < 4; idx++){
                    int nx = cur.x + dx[idx];
                    int ny = cur.y + dy[idx];
                    //범위 체크
                    if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                    //현재위치에서 최소값으로 갱신가능하면 해주기
                    if(map_cnt[nx][ny] > map_cnt[cur.x][cur.y]+map[nx][ny]){
                        map_cnt[nx][ny] = map_cnt[cur.x][cur.y] + map[nx][ny];
                        queue.offer(new Data(nx,ny));
                    }
                }
            }




            bw.write("Problem "+tc+": "+ map_cnt[N-1][N-1]+"\n");
            ++tc;


        }
        bw.flush();
    }
}