import java.util.*;

class Solution {
    static char[][] map;
    static int[] dx = {1, -1, 0, 0}, dy = {0, 0, 1, -1};
    static class Info{
        int x;
        int y;
        public Info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static int[][] infos = new int[3][2];
    static int n,m;
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        
        map = new char[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S'){
                    infos[0][0] = i;
                    infos[0][1] = j;
                }
                else if(map[i][j] == 'L'){
                    infos[2][0] = i;
                    infos[2][1] = j;
                }
                else if(map[i][j] == 'E'){
                    infos[1][0] = i;
                    infos[1][1] = j;
                }
            }
        }
        
        int lever = find_lever(infos[0][0], infos[0][1]);
        int exit = find_exit(infos[2][0], infos[2][1]);
        if(lever == -1 || exit == -1) return -1;
        
        return lever + exit;
    }
    private static int find_lever(int x, int y){
        //레버 찾기, 좌표는 스타트 지점
        
        boolean[][] visit = new boolean[n][m];
        visit[x][y] = true;
        
        Queue<Info> queue = new ArrayDeque<>();
        queue.offer(new Info(x, y));
        
        int len;
        int cnt = 1;
        while(!queue.isEmpty()){
            len = queue.size();
            for(int i = 0; i < len; i++){
                Info cur = queue.poll();
            
                for(int idx = 0; idx < 4; idx++){
                    int nx = cur.x + dx[idx];
                    int ny = cur.y + dy[idx];
                    
                    //범위밖
                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    //벽인 경우
                    if(map[nx][ny] == 'X') continue;
                    //방문한 경우
                    if(visit[nx][ny]) continue;
                    visit[nx][ny] = true;
                    if(nx == infos[2][0] && ny == infos[2][1]) return cnt;
                    queue.offer(new Info(nx, ny));
                }
            }
            cnt++;
        }
        return -1;
    }
    private static int find_exit(int x, int y){
        //레버에서 출구 찾기
        
        boolean[][] visit = new boolean[n][m];
        visit[x][y] = true;
        
        Queue<Info> queue = new ArrayDeque<>();
        queue.offer(new Info(x, y));
        
        int len;
        int cnt = 1;
        while(!queue.isEmpty()){
            len = queue.size();
            for(int i = 0; i < len; i++){
                Info cur = queue.poll();
                
                for(int idx = 0; idx < 4; idx++){
                    int nx = cur.x + dx[idx];
                    int ny = cur.y + dy[idx];
                    //범위밖
                    if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                    //벽인 경우
                    if(map[nx][ny] == 'X') continue;
                    //방문한 경우
                    if(visit[nx][ny]) continue;
                    
                    visit[nx][ny] = true;
                    if(nx == infos[1][0] && ny == infos[1][1]) return cnt;
                    queue.offer(new Info(nx, ny));
                }
            }
            cnt++;
        }
        return -1;
    }
}