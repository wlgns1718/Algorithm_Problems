class Solution {
    static int res = 0;
    static boolean[] visit;
    public int solution(int[] info, int[][] edges) {
        
        int answer = 0;
        visit = new boolean[info.length];
        visit[0] = true;
        sol(1, 0, edges, info);
        answer = res;
        
        return answer;
    }
    private static void sol(int sheep, int wolf, int[][] edges, int[] info){
        if(sheep > wolf){
            res = Math.max(res, sheep);
        }
        else{
            return;
        }
        for(int[] edge : edges){
            if(visit[edge[0]] && !visit[edge[1]]){
                visit[edge[1]] = true;
                if(info[edge[1]] == 0){
                    sol(sheep + 1, wolf, edges, info);
                }
                else{
                    sol(sheep, wolf + 1, edges, info);
                }
                visit[edge[1]] = false;
            }
        }
        
    }
}