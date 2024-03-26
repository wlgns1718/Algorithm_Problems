import java.util.*;

class Solution {
    static final int MAX = Integer.MAX_VALUE;
    static int[] together, muzi, appeach;
    static int[][] map;
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = MAX;
        
        //초기 조건 설정
        init(n, s - 1, a - 1, b - 1, fares);
        
        //함께 이동하는 경로 최적화
        cal(s-1, together);
        
        //무지가 이동하는 경로 최적화
        cal(a-1, muzi);
        
        //어피치가 이동하는 경로 최적화
        cal(b-1, appeach);
        
        // System.out.println(Arrays.toString(together));
        
        //모든 지점에서 각자의 집으로 가는 최적의 수 구하기
        for(int i = 0; i < n; i++){
            int temp = 0;
            temp += together[i];
            temp += muzi[i];
            temp += appeach[i];
            if(answer > temp){
                answer = temp;
            }
        }
        return answer;
    }
    
    private static void init(int n,int s, int m, int a, int[][] fares){
        together = new int[n];
        muzi = new int[n];
        appeach = new int[n];
        map = new int[n][n];
        Arrays.fill(together, MAX);
        Arrays.fill(muzi, MAX);
        Arrays.fill(appeach, MAX);
        
        together[s] = 0;
        muzi[m] = 0;
        appeach[a] = 0;
        
        for(int[] f : fares){
            int node1 = f[0] - 1;
            int node2 = f[1] - 1;
            int cost = f[2];
            map[node1][node2] = cost;
            map[node2][node1] = cost;
        }
    }
    
    private static void cal(int s, int[] ls){
        //처음 s 지점부터 이동하는 최적의 경로
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(s);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            //현재 지점에서 갈 수 있는 경로 파악
            for(int i = 0; i < map[cur].length; i++){
                if(map[cur][i] != 0){
                    //최적의 요금을 갱신할 수 있을 때
                    if(ls[i] > map[cur][i] + ls[cur]){
                        ls[i] = map[cur][i] + ls[cur];
                        queue.offer(i);
                    }
                }
            }
        }
    }
}