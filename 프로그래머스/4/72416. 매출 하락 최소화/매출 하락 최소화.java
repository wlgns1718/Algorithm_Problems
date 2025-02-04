import java.util.*;

class Solution {
    static Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    static int[] team_code;
    static int[][] dp;
    public int solution(int[] sales, int[][] links) {
        int answer = 0;
        team_code = new int[sales.length + 1];
        find_team(links);
        dp = new int[sales.length + 1][2]; // 1은 포함 0은 미포함
        dfs(1, sales);
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    private static void find_team(int[][] links){
        for(int[] l : links){
            if(!map.containsKey(l[0])){
                map.put(l[0], new PriorityQueue<>());
            }
            map.get(l[0]).add(l[1]);
            team_code[l[1]] = l[0];
        }
    }
    
    private static void dfs(int cur, int[] sales){
        boolean flag = false;
        //cur은 현재 팀원 번호
        dp[cur][0] = 0;
        dp[cur][1] = sales[cur-1];

        if(!map.containsKey(cur)) return;

        int minValue = Integer.MAX_VALUE;
        for(int team : map.get(cur)){
            dfs(team, sales);
            if(dp[team][0] < dp[team][1]){
                //해당 팀원이 참여 안하는게 더 효율적 일 때
                dp[cur][0] += dp[team][0];
                dp[cur][1] += dp[team][0];

                //모두가 참여 안할 경우 값 계산
                minValue = Math.min(minValue, dp[team][1] - dp[team][0]);
            }
            else{

                flag = true; // 해당 팀에서 한 팀원이 참여 한다면
                //해당 팀원이 참여하는게 더 효율적 일 때
                dp[cur][0] += dp[team][1];
                dp[cur][1] += dp[team][1];
            }

        }
        if(!flag){
            //모두가 참여 하지 않았을 때 가장 가성비 좋은 팀원 참여
            dp[cur][0] += minValue;
        }
    }
}