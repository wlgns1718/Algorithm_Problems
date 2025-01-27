import java.util.*;

class Solution {
    static boolean[][] map;
    public int solution(int n, int[][] wires) {
        map = new boolean[n+1][n+1];
        
        //전력망 정보 저장
        for(int[] w : wires){
            map[w[0]][w[1]] = true;
            map[w[1]][w[0]] = true;
        }
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < wires.length; i++){
            answer = Math.min(answer, sol(i, n, wires));
        }
        
        return answer;
    }
    private static int sol(int idx, int n, int[][] wires){
        boolean[] visit = new boolean[n + 1];
        //idx의 전력망정보 없애고 확인
        int[] temp = wires[idx];
        map[temp[0]][temp[1]] = false;
        map[temp[1]][temp[0]] = false;
        int left = -1, right = -1;
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        left = 1;
        visit[1] = true;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 1; i <= n; i++){
                //전력망이 없는경우
                if(!map[cur][i]) continue;
                //이미 방문한 노드일 경우
                if(visit[i]) continue;
                visit[i] = true;
                left++;
                q.offer(i);
            }
        }
        for(int i = 1; i <= n; i++){
            if(!visit[i]){
                q.offer(i);
                right = 1;
                visit[i] = true;
                break;
            }
        }
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 1; i <= n; i++){
                //전력망이 없는경우
                if(!map[cur][i]) continue;
                //이미 방문한 노드일 경우
                if(visit[i]) continue;
                visit[i] = true;
                right++;
                q.offer(i);
            }
        }
        
        //원상복귀
        map[temp[0]][temp[1]] = true;
        map[temp[1]][temp[0]] = true;
        
        return Math.abs(left - right);
    }
}