import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N,M,nx,ny;
    static int answer = 0;
    static boolean[][] visited;
    static ArrayList<Data> virus = new ArrayList<>();
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    
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
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        
        for(int i = 0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    virus.add(new Data(i,j));//초기 바이러스 담기
                }
            }
        }
        
        wall_create(map,0);
        System.out.println(answer);


    }

    public static void wall_create(int[][] map,int cnt) {//벽 3개 세우기
        if(cnt==3) {//벽을 3개 세웠으면 바이러스 퍼뜨리기
            
            int[][] temp_map = new int[N][M];
            for(int i =0; i<N; i++) {
                for(int j = 0; j<M; j++) {
                    temp_map[i][j] = map[i][j];
                }
            }
            spread(temp_map);
            return;
        }
        for(int i=0; i<N; i++) {
//        	if(i==1)return;
            for(int j = 0; j<M; j++) {
                
                if(map[i][j]== 1 || map[i][j] == 2) continue;
                
                map[i][j] = 1;
                wall_create(map,cnt+1);
                map[i][j] = 0;
                
                
            }
        }
    }
    
    public static void spread(int[][] map) {
    	visited = new boolean[N][M];
        Queue<Data> queue = new ArrayDeque<>();
        for(int i = 0; i<virus.size(); i++) {
            queue.offer(virus.get(i));
            visited[virus.get(i).x][virus.get(i).y] = true;
        }
        
        while(!queue.isEmpty()) {
            Data cur = queue.poll();
            for(int idx = 0; idx<4; idx++) {
                nx = cur.x + dx[idx];
                ny = cur.y + dy[idx];
                if(nx<0 || ny <0|| nx>=N || ny>=M)continue; //범위체크
                if(visited[nx][ny])continue;//방문체크
                if(map[nx][ny]==0) {//빈공간 체크
                    map[nx][ny] = 2;
                    visited[nx][ny] = true;
                    queue.offer(new Data(nx,ny));
                }
            }
            
        }

        int temp=0;
        for(int i = 0; i<N; i++) {
            for(int j = 0; j<M; j++) {
                if(map[i][j] == 0) {
                    temp++;
                }
            }
        }
        if(answer < temp) {
            answer = temp;
        }
        
        
    }
    
    public static void print(int[][] map) {
        for(int i=0; i<N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

}