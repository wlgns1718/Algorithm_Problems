import java.io.*;
import java.util.*;
public class Main {
    static int M,N,answer;
    static String[][] map;
    static int[] dx  = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static boolean[][] visited;
    static Deque<Data> queue = new ArrayDeque<>();
    public static class Data{
        int x;
        int y;
        int dis;
        public Data(int x, int y, int dis){
            super();
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new String[M][N];
        //보물지도 생성
        for(int i = 0; i<M; i++){
            String temp = br.readLine();
            for(int j  = 0 ; j<N; j++){
                map[i][j] = String.valueOf(temp.charAt(j));
            }
//            System.out.println(Arrays.toString(map[i]));
        }

        //보물 찾기
        for(int i = 0; i<M; i++){
            for(int j = 0; j<N; j++){
                //물이면 건너뛰기
                if(map[i][j].equals("W")){
                    continue;
                }
                visited = new boolean[M][N];
                sol(i,j,visited);


            }
        }
        System.out.println(answer);

    }

    public static void sol(int x, int y, boolean[][] visit){
        visit[x][y] = true;
        queue.clear();
        queue.offer(new Data(x,y,0));
        while(!queue.isEmpty()){
            //햔제 위치
            Data cur = queue.poll();
            //햔제 위치에서 갈 수 있는 곳 탐색
            for(int idx = 0 ; idx<4; idx++){
                int nx = cur.x+dx[idx];
                int ny = cur.y+dy[idx];
                //범위 체크
                if(nx < 0 || ny < 0 || nx >= M || ny >= N){
                    continue;
                }
                if(map[nx][ny].equals("W")){
                    continue;
                }
                //방문체크
                if(visit[nx][ny]){
                    continue;
                }
                //방문 안했으면
                visit[nx][ny] = true;
                queue.offer(new Data(nx,ny,cur.dis+1));

            }
            if(cur.dis>answer){
                answer = cur.dis;
            }
        }
    }
}