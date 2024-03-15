import java.util.*;

class Solution {
    
    static int[][] total, visit;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int N, M, flag = 1;
    static class Data{
        
        int x;
        int y;
        
        public Data(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int solution(int[][] land) {
        N = land.length;
        M = land[0].length;
        int answer = 0;
        
        total = new int[N][M];
        visit = new int[N][M];
        
        for(int j = 0; j < M; j++){
            Set<Integer> set = new HashSet<>();
            int temp = 0;
            for(int i = 0; i < N; i++){
                //기름 유뭄 확인
                if(land[i][j] == 0) continue;
                //기름이 있고 현재 이미 계산한 땅이라면
                if(set.contains(visit[i][j])) continue;
                //기름이 있는데 방문을 안했다면
                if(visit[i][j] == 0){
                    find(i, j, land);
                }
                temp += total[i][j];
                set.add(visit[i][j]);
            }
            answer = Math.max(answer, temp);
        }
        return answer;
    }
    private static void find(int x, int y, int[][] land){
        
        //현재 위치에 기름이 있고 방문하지 않았다면
        Queue<Data> queue = new ArrayDeque<>();
        queue.offer(new Data(x,y));
        visit[x][y] = flag;
        int sum = 1;
        
        while(!queue.isEmpty()){
            Data cur = queue.poll();
            for(int idx = 0; idx < 4; idx++){
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];
                //범위 확인
                if(nx < 0 || ny < 0 || nx >= N || ny >= M)continue;
                //방문 확인
                if(visit[nx][ny] == flag) continue;
                //기름이 있는지 확인
                if(land[nx][ny] == 0) continue;
                
                visit[nx][ny] = flag;
                sum++;
                queue.offer(new Data(nx, ny));
            }
        }
        //이후 기름 총량 업데이트 하기
        set_total(x, y, sum, land);
        flag++;
    }
    
    private static void set_total(int x, int y, int sum, int[][] land){
        
        Queue<Data> queue = new ArrayDeque<>();
        queue.offer(new Data(x, y));
        total[x][y] = sum;
        
        while(!queue.isEmpty()){
            Data cur = queue.poll();
            for(int idx = 0; idx < 4; idx++){
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];
                
                //범위확인
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                //기름이 있는지 확인
                if(land[nx][ny] == 0) continue;
                //총량으로 업데이트 했는지 확인
                if(total[nx][ny] != 0) continue;
                
                total[nx][ny] = sum;
                queue.offer(new Data(nx, ny));
            }
        }
    }
}