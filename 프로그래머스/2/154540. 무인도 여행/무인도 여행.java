import java.util.*;

class Solution {
    
    static boolean[][] visit;
    static int N, M;
    static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};
    static class Info{
        int x;
        int y;
        public Info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public int[] solution(String[] maps) {
        int[] answer;
        N = maps.length;
        M = maps[0].length();
        visit = new boolean[N][M];
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visit[i][j]) continue;
                if(maps[i].charAt(j) == 'X') continue;
                visit[i][j] = true;
                pq.add(sol(i, j, maps));
            }
        }
        if(pq.size() == 0) return new int[] {-1};
        answer = new int[pq.size()];
        int idx = 0;
        while(!pq.isEmpty()){
            answer[idx++] = pq.poll();
        }
        
        return answer;
    }
    
    private static int sol(int x, int y, String[] maps){
        int res = Integer.parseInt(String.valueOf(maps[x].charAt(y)));
        Queue<Info> queue = new ArrayDeque<>();
        queue.offer(new Info(x, y));
        while(!queue.isEmpty()){
            Info cur = queue.poll();
            for(int idx = 0; idx < 4; idx++){
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];
                if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                if(maps[nx].charAt(ny) == 'X') continue;
                if(visit[nx][ny]) continue;
                visit[nx][ny] = true;
                res += Integer.parseInt(String.valueOf(maps[nx].charAt(ny)));
                queue.offer(new Info(nx, ny));
            }
        }
        return res;
    }
}