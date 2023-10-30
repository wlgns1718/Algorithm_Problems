import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int N,M,map[][],answer[];
    static int[] dx = {0,0,1,-1}, dy = {1,-1,0,0};
    static class Data{
        int x;
        int y;
        int dis;
        public Data(int x, int y, int dis){
            this.x = x;
            this.y = y;
            this.dis = dis;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        answer = new int[3];
        for(int i =0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 0)continue;
                sol(new Data(i,j,0));
            }
        }
        System.out.println(answer[0] + answer[1]);

    }
    private static void sol(Data data){

        Queue<Data> queue = new ArrayDeque<>();
        queue.offer(data);
        boolean[][] visit = new boolean[N][M];
        visit[data.x][data.y] = true;
        while(!queue.isEmpty()){
            Data cur = queue.poll();
            for(int idx = 0; idx < 4; idx++){
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];

                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(visit[nx][ny]) continue;
                if(map[nx][ny] == 0) continue;

                visit[nx][ny] = true;
                queue.offer(new Data(nx, ny, cur.dis + 1));
                if(answer[2] <= cur.dis + 1){
                    if(answer[2] == cur.dis + 1){
                        if(answer[1] + answer[0] < map[data.x][data.y] + map[nx][ny]){
                            answer[0] = map[data.x][data.y];
                            answer[1] = map[nx][ny];
                        }
                    }
                    else{
                        answer[0] = map[data.x][data.y];
                        answer[1] = map[nx][ny];
                        answer[2] = cur.dis + 1;
                    }
                }
            }
        }
    }

}