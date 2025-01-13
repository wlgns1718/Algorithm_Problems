import java.util.*;

class Solution {
    static char[][] map;
    static class Info{
        int x;
        int y;
        int cnt;
        public Info(int x, int y){
            this.x = x;
            this.y = y;
        }
        public Info(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    static Queue<Info> queue = new ArrayDeque<>();
    static boolean[][] visit;
    static Info goal;
    static int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0};
    
    public int solution(String[] board) {
        int answer = Integer.MAX_VALUE;
        int row = board.length;
        int col = board[0].length();
        map = new char[row][col];
        visit = new boolean[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'G'){
                    goal = new Info(i, j);
                }
                else if(map[i][j] == 'R'){
                    visit[i][j] = true;
                    queue.offer(new Info(i, j, 0));
                }
            }
        }
        while(!queue.isEmpty()){
            Info cur = queue.poll();
            if(cur.x == goal.x && cur.y == goal.y){
                answer = Math.min(answer, cur.cnt);
                continue;
            }
            for(int idx = 0; idx < 4; idx++){
                int nx = cur.x;
                int ny = cur.y;
                while(true){
                    nx += dx[idx];
                    ny += dy[idx];
                    //범위 체크
                    if(nx < 0 || ny < 0 || nx >= row || ny >= col){
                        nx -= dx[idx];
                        ny -= dy[idx];
                        break;
                    }
                    //돌 체크
                    if(map[nx][ny] == 'D'){
                        nx -= dx[idx];
                        ny -= dy[idx];
                        break;
                    }
                }
                if(visit[nx][ny]) continue;
                visit[nx][ny] = true;
                queue.offer(new Info(nx, ny, cur.cnt + 1));
                
            }
        }
        if(answer == Integer.MAX_VALUE) answer = -1;
        return answer;
    }
}