import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, Integer> map = new HashMap<>();
        int N = friends.length;
        int[][] rel = new int[N][N];
        int[] give = new int[N];
        int[] take = new int[N];
        for(int i = 0; i < N; i++){
            map.put(friends[i], i);
        }
        for(String g : gifts){
            String[] temp = g.split(" ");
            int a = map.get(temp[0]);
            int b = map.get(temp[1]);
            
            give[a]++;
            take[b]++;
            rel[a][b] ++;
        }
        for(int i = 0; i < N; i++){
            int sum = 0;
            for(int j = 0; j < N; j++){
                if(i == j) continue;
                if(rel[i][j] != 0 && rel[i][j] > rel[j][i]){
                    sum++;
                }
                else if(rel[i][j] == rel[j][i]){
                    if(give[i] - take[i] > give[j] - take[j]){
                        sum++;
                    }
                }
            }
            answer = Math.max(answer, sum);
        }
        return answer;
    }
}