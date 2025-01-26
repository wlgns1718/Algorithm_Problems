class Solution {
    static boolean[] visit;
    static long para2;
    public int[] solution(int n, long k) {
        
        para2 = k - 1;
        int[] answer = new int[n];
        visit = new boolean[n + 1];
        
        for(int i = 0; i < n; i++){
            answer[i] = cal(n - i, para2, n);
        }
        
        return answer;
    }
    private static int cal(int idx, long remain, int n){
        int res = 0;
        long sum = 0L;
        long temp;
        while(sum < remain){
            
            temp = cal(idx - 1);
            if(sum + temp > remain) break;
            sum += temp;
            res++;
            
        }
        
        int cnt = 0;
        for(int i = 1; i <= n; i++){
            if(visit[i]) continue;
            if(cnt == res){
                visit[i] = true;
                para2 -= sum;
                return i;
            }
            else{
                cnt++;
            }
        }
        return 0;
    }
    
    private static long cal(int num){
        long res = 1L;
        for(int i = 2; i <= num; i++){
            res *= i;
        }
        return res;
    }
    
}