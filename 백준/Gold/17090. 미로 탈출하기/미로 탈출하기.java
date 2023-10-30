import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int N, M, answer;
    static char[][] map;
    static boolean[][] dp,visit;
    static class Data{
        int x;
        int y;
        public Data(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        dp = new boolean[N][M];
        visit = new boolean[N][M];

        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = temp.charAt(j);
            }
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(visit[i][j]) continue;
                sol(i, j);
            }
        }
//        for(int i = 0; i < N; i++){
//            System.out.println(Arrays.toString(dp[i]));
//        }
        System.out.println(answer);
    }

    private static void sol(int x, int y) {
        Stack<Data> stack = new Stack<>();
        stack.push(new Data(x, y));
        visit[x][y] = true;
        while(true){
            Data cur = stack.peek();
            if(dp[cur.x][cur.y]){
                gain(stack);
                return;
            }
            char cur_char = map[cur.x][cur.y];
            switch (cur_char){
                case 'U':
                    if(cur.x - 1 < 0 || dp[cur.x - 1][cur.y]){
                        gain(stack);
                        return;
                    }
                    else{
                        if(!visit[cur.x - 1][cur.y]){
                            visit[cur.x - 1][cur.y] = true;
                            stack.push(new Data(cur.x - 1, cur.y));
                        }
                    }
                    break;
                case 'D':
                    if(cur.x + 1 >= N || dp[cur.x + 1][cur.y]){
                        gain(stack);
                        return;
                    }
                    else{
                        if(!visit[cur.x + 1][cur.y]) {
                            visit[cur.x + 1][cur.y] = true;
                            stack.push(new Data(cur.x + 1, cur.y));
                        }
                    }
                    break;
                case 'R':
                    if(cur.y + 1 >= M || dp[cur.x][cur.y + 1]){
                        gain(stack);
                        return;
                    }
                    else{
                        if(!visit[cur.x][cur.y + 1]){
                            visit[cur.x][cur.y + 1] = true;
                            stack.push(new Data(cur.x, cur.y + 1));
                        }
                    }
                    break;
                case 'L':
                    if(cur.y - 1 < 0 || dp[cur.x][cur.y - 1]){
                        gain(stack);
                        return;
                    }
                    else{
                        if(!visit[cur.x][cur.y - 1]){
                            visit[cur.x][cur.y - 1] = true;
                            stack.push(new Data(cur.x, cur.y - 1));
                        }
                    }
                    break;
            }
            if(cur == stack.peek()) break;
        }

    }
    private static void gain(Stack<Data> stack){
        while(!stack.isEmpty()){
            Data cur = stack.pop();
            if(dp[cur.x][cur.y]) continue;
            dp[cur.x][cur.y] = true;
            answer += 1;
        }
    }
}