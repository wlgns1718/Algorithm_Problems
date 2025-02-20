class Solution {
    static boolean[] select;
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        boolean flag = true;
        select = new boolean[n+1];
        
        for(int a = 1; a <= n - 4; a++){
            select[a] = true;
            for(int b = a + 1; b <= n - 3; b++){
                select[b] = true;
                for(int c = b + 1; c <= n - 2; c++){
                    select[c] = true;
                    for(int d = c + 1; d <= n - 1; d++){
                        select[d] = true;
                        for(int e = d + 1; e <= n; e++){
                            select[e] = true;
                            
                            int cnt = 0;
                            flag = true;
                            
                            Loop1:
                            for(int i = 0; i < q.length; i++){
                                cnt = 0;
                                for(int j = 0; j < 5; j++){
                                    if(select[q[i][j]]) cnt++;
                                }
                                if(cnt != ans[i]){
                                    flag = false;
                                    break Loop1;
                                }
                            }
                            if(flag) answer++;
                            select[e] = false;
                        }
                        select[d] = false;
                    }
                    select[c] = false;
                }
                select[b] = false;
            }
            select[a] = false;
        }
        return answer;
    }
    
}