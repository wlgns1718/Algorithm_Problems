class Solution {
    public int[] solution(int e, int[] starts) {
        int[] answer = new int[starts.length];
        int[] dp = new int[e + 1];
        for(int i = 1; i <= e; i++){
            for(int j = i; j <= e; j += i){
                dp[j]++;
            }
        }
        int[] max_value = new int[e + 1];
        int max_temp = 0;
        int max_idx = 0;
        for(int i = e; i >= 1; i--){
            if(dp[i] >= max_temp){
                max_temp = dp[i];
                max_idx = i;
            }
            max_value[i] = max_idx;
        }
        for(int i = 0; i < starts.length; i++){
            answer[i] = max_value[starts[i]];
        }
        return answer;
    }
}