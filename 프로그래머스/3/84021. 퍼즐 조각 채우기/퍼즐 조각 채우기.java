import java.util.*;

class Solution {
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static int n, m;
    static boolean[] visit;
    static List<List<List<Node>>> brr = new ArrayList<>();
    static int[][] spin0, spin90, spin180, spin270;
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString(){
            return "x : " + this.x + " y : " + this.y;
        }
    }
    static int answer = 0;
    public int solution(int[][] game_board, int[][] table) {
        n = table.length;
        m = table[0].length;

        spin0 = new int[n][m];
        spin90 = new int[n][m];
        spin180 = new int[n][m];
        spin270 = new int[n][m];


        findDiagram(table);
        spin(spin0);


        save(spin90, 1);
        save(spin180, 2);
        save(spin270, 3);

        find_arr(game_board);
        return answer;
    }
    private static void find_arr(int[][] table) {
        boolean[][] select = new boolean[table.length][table[0].length];
        int idx = 1;
        Queue<Node> q = new ArrayDeque<>();
        int cnt;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(table[i][j] == 1) continue; //도형 유무 체크
                if(select[i][j]) continue; //방문 체크
                select[i][j] = true;
                cnt = 1;
                //도형 모양 조회
                q.offer(new Node(i, j));

                while(!q.isEmpty()){
                    Node cur = q.poll();
                    for(int p = 0; p < 4; p++){
                        int nx = cur.x + dx[p];
                        int ny = cur.y + dy[p];
                        //범위체크
                        if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        //연결된 도형인지 체크
                        if(table[nx][ny] == 1) continue;
                        if(select[nx][ny]) continue;
                        select[nx][ny] = true;
                        //도형 dx, dy 정보 추가
                        q.offer(new Node(nx, ny));
                        cnt++;
                    }
                }

                boolean tri;

                Loop:
                for(int p = 0; p < brr.size(); p++){
                    if(visit[p]) continue;
                    if(brr.get(p).get(0).size() != cnt) continue;

                    for(int temp = 0; temp < 4; temp ++){
                        tri = true;

                        for(Node node : brr.get(p).get(temp)){
                            if(node.x + i < 0 || node.y + j < 0 || node.x + i >= n || node.y + j >= m){
                                tri = false;
                                break;
                            }
                            if(table[node.x + i][node.y + j] != 0){
                                tri = false;
                                break;
                            }

                        }
                        if(tri){

                            visit[p] = true;
                            for(Node node : brr.get(p).get(temp)){
                                table[i + node.x][j + node.y] = 1;
                            }
                            answer += brr.get(p).get(temp).size();

                            break Loop;
                        }
                    }
                }
                idx++;
            }
        }
        visit = new boolean[idx];
    }
    private static void findDiagram(int[][] table){
        boolean[][] select = new boolean[n][m];
        int idx = 1;
        Queue<Node> q = new ArrayDeque<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){

                if(table[i][j] == 0) continue; //도형 유무 체크
                if(select[i][j]) continue; //방문 체크
                brr.add(new ArrayList<>());
                for(int temp = 0; temp < 4; temp ++){
                    brr.get(idx-1).add(new ArrayList<>());
                }
                brr.get(idx-1).get(0).add(new Node(0, 0));
                select[i][j] = true;
                //도형 모양 조회
                q.offer(new Node(i, j));
                spin0[i][j] = idx;
                while(!q.isEmpty()){
                    Node cur = q.poll();
                    for(int p = 0; p < 4; p++){
                        int nx = cur.x + dx[p];
                        int ny = cur.y + dy[p];
                        //범위체크
                        if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        //연결된 도형인지 체크
                        if(table[nx][ny] == 0) continue;
                        if(select[nx][ny]) continue;
                        select[nx][ny] = true;
                        //도형 dx, dy 정보 추가
                        q.offer(new Node(nx, ny));
                        spin0[nx][ny] = idx;
                        brr.get(idx-1).get(0).add(new Node(nx - i, ny - j));
                    }
                }
                idx++;
            }
        }
        visit = new boolean[idx];
    }
    
    private static void save(int[][] board, int index){
        Queue<Node> q = new ArrayDeque<>();
        boolean[][] select = new boolean[n][n];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 0) continue;
                if(select[i][j]) continue;

                int idx = board[i][j] - 1;
                q.offer(new Node(i, j));
                select[i][j] = true;

                brr.get(idx).get(index).add(new Node(0, 0));

                while(!q.isEmpty()){
                    Node cur = q.poll();
                    for(int d = 0; d < 4; d++){
                        int nx = cur.x + dx[d];
                        int ny = cur.y + dy[d];

                        if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                        if(board[nx][ny] != idx + 1) continue;
                        if(select[nx][ny]) continue;

                        select[nx][ny] = true;
                        q.offer(new Node(nx, ny));
                        brr.get(idx).get(index).add(new Node(nx - i, ny - j));
                    }
                }
            }
        }
    }
    private static void spin(int[][] board){

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                spin90[i][j] = board[m-j-1][i];
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                spin180[i][j] = board[m-i-1][n-j-1];
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                spin270[i][j] = board[j][n-i-1];
            }
        }

    }
}