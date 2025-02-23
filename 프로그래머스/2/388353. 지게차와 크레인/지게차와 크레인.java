import java.util.*;

class Solution {
    static char[][] map;
    static int n, m;
    static boolean[][] visit;
    static Map<Character, List<Info>> crain = new HashMap<>();
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static class Info{
        int x;
        int y;
        public Info(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        visit = new boolean[n+2][m+2];
        
        for(int i = 0; i <= m; i++){
            visit[0][i] = true;
            visit[n + 1][i] = true;
            
        }
        
        for(int i = 0; i <= n + 1; i++){
            visit[i][0] = true;
            visit[i][m + 1] = true;
        }
        map = new char[n + 2][m + 2];
        Arrays.fill(map[0], '0');
        Arrays.fill(map[n + 1], '0');
        for(int i = 0; i < n; i++){
            Arrays.fill(map[i + 1], '0');
            for(int j = 0; j < m; j++){
                map[i + 1][j + 1] = storage[i].charAt(j);
                if(!crain.containsKey(map[i + 1][j + 1])) crain.put(map[i + 1][j + 1], new ArrayList<>());
                crain.get(map[i + 1][j + 1]).add(new Info(i + 1, j + 1));
            }
        }


        for(int i = 0; i < requests.length; i++){
            String temp = requests[i];
            if(!crain.containsKey(temp.charAt(0))) continue;
            if(temp.length() == 1){
                answer += can(temp.charAt(0));
            }
            else{
                answer += all(temp.charAt(0));
            }
        }
        return n * m - answer;
    }
    private static int can(char target){


        int cnt = 0;
        int index = 0;
        int len = crain.get(target).size();
        Queue<Info> queue = new ArrayDeque<>();

        for(int i = 0; i < len; i++){
            Info cur = crain.get(target).get(index);

            for(int idx = 0; idx < 4; idx++){

                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];

                if(visit[nx][ny]){
                    map[cur.x][cur.y] = '0';
                    queue.offer(new Info(cur.x, cur.y));
                    crain.get(target).remove(index--);
                    cnt++;
                    break;
                }
            }
            index++;
        }
        
        while(!queue.isEmpty()){
            len = queue.size();
            for(int i = 0; i < len; i++){
                Info cur = queue.poll();
                visit[cur.x][cur.y] = true;
                for(int idx = 0; idx < 4; idx++){
                    int nx = cur.x + dx[idx];
                    int ny = cur.y + dy[idx];
                    if(!visit[nx][ny] && map[nx][ny] == '0'){
                        queue.offer(new Info(nx, ny));
                    }
                }
            }
            
        }

        return cnt;
    }

    private static int all(char target){


        int cnt = 0;
        int len = crain.get(target).size();
        Queue<Info> queue = new ArrayDeque<>();
        for(int i = 0; i < len; i++){
            Info cur = crain.get(target).get(0);
            map[cur.x][cur.y] = '0';
            for(int idx = 0; idx < 4; idx++){
                int nx = cur.x + dx[idx];
                int ny = cur.y + dy[idx];
                if(visit[nx][ny]){
                    queue.offer(new Info(cur.x, cur.y));
                    break;
                }
            }
            crain.get(target).remove(0);
            cnt++;
        }
        while(!queue.isEmpty()){
            len = queue.size();
            for(int i = 0; i < len; i++){
                Info cur = queue.poll();
                visit[cur.x][cur.y] = true;
                for(int idx = 0; idx < 4; idx++){
                    int nx = cur.x + dx[idx];
                    int ny = cur.y + dy[idx];
                    if(!visit[nx][ny] && map[nx][ny] == '0'){
                        queue.offer(new Info(nx, ny));
                    }
                }
            }
        }
        return cnt;
    }
}