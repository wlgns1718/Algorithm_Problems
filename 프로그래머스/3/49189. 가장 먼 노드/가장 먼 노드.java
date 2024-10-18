import java.util.*;

class Solution {
    
    static boolean[][] map;
    static boolean[] visit;
    static int[] dis = new int[50001];
    static class Node{
        int node;
        int dis;
        public Node(int node, int dis){
            this.node = node;
            this.dis = dis;
        }
    }
    static int max_dis = 0;
    public int solution(int n, int[][] edge) {
        int answer = 0;
        map = new boolean[n + 1][n + 1];
        visit = new boolean[n + 1];
        for(int[] e : edge){
            //간선 처리
            map[e[0]][e[1]] = true;
            map[e[1]][e[0]] = true;
        }
        visit[1] = true;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(1, 0));
        while(!q.isEmpty()){
            Node cur = q.poll();
            for(int i = 1; i <= n; i++){
                //자신 또는 방문한 노드라면 건너뛰기
                if(i == cur.node || visit[i]) continue;
                if(map[cur.node][i]){
                    //갈 수 있다면
                    q.offer(new Node(i, cur.dis + 1));
                    dis[cur.dis + 1] ++;
                    max_dis = Math.max(max_dis, cur.dis + 1);
                    visit[i] = true;
                }
            }
        }
        answer = dis[max_dis];
        return answer;
    }
}