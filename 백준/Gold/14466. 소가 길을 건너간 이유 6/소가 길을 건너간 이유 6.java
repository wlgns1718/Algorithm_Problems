import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N;
    static int K;
    static int R;
    static int[][] farm;
    static int answer = 0;
    static int[] dx = {1,-1,0,0}, dy = {0,0,1,-1};
    static class Data{
        int x;
        int y;
        public Data(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj){
            Data data = (Data) obj;
            return this.x == data.x && this.y == data.y;
        }
        @Override
        public int hashCode(){
            return (100) * x + y;
        }
    }
    static HashMap<Data,List<Data>> map = new HashMap<>();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        farm = new int[N+1][N+1];

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            Data data1 = new Data(x1,y1);
            Data data2 = new Data(x2,y2);
            if(!map.containsKey(data1)){
                map.put(data1,new ArrayList<>());
            }
            if(!map.containsKey(data2)){
                map.put(data2,new ArrayList<>());
            }
            map.get(data1).add(data2);
            map.get(data2).add(data1);
        }
        for(int i = 0; i < K; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            farm[x][y] = 1;
        }
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(farm[i][j] == 1){
                    sol(i, j);
                }
            }
        }
        System.out.println(answer/2);
    }
    private static void sol(int x, int y){
        int cnt = 1;
        Queue<Data> queue = new ArrayDeque<>();
        queue.add(new Data(x,y));
        boolean[][] visit = new boolean[N+1][N+1];
        visit[x][y] = true;
        while(!queue.isEmpty()){
            Data cur = queue.poll();
            for(int idx = 0; idx < 4; idx++){
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];
                
                if(nx <= 0 || ny <= 0 || nx > N || ny > N) continue;
                if(visit[nx][ny]) continue;
                if(map.containsKey(cur) && !check(nx,ny,cur)) continue;
                
                queue.offer(new Data(nx,ny));
                visit[nx][ny] = true;
                if(farm[nx][ny] == 1){
                    cnt += 1;
                }

            }
        }
        answer += (K - cnt);
    }
    private static boolean check(int x, int y, Data cur) {
        for (Data data : map.get(cur)) {
            if (data.x == x && data.y == y) return false;
        }
        return true;
    }
}