import java.util.*;
class Solution {
    static int[] dis;
    static List<List<Integer>> ls = new ArrayList<>();
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        dis = new int[n + 1]; //목적지까지 각 인덱스에서 걸리는 최단 시간
        for(int i = 0; i <= n; i++){
            ls.add(new ArrayList<>());
        }
        Arrays.fill(dis, Integer.MAX_VALUE);
        dis[destination] = 0;
        for(int[] r : roads){
            ls.get(r[0]).add(r[1]);
            ls.get(r[1]).add(r[0]);
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(destination);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int temp : ls.get(cur)){
                if(dis[temp] == Integer.MAX_VALUE){
                    dis[temp] = dis[cur] + 1;
                    q.offer(temp);
                }
            }
        }
        for(int i = 0; i < sources.length; i++){
            if(dis[sources[i]] == Integer.MAX_VALUE) answer[i] = -1;
            else answer[i] = dis[sources[i]];
        }
        
        return answer;
    }
}