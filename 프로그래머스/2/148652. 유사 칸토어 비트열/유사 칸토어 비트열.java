import java.util.*;
class Solution {
    static int[] dec = {0, 1, 2, 2, 3};
    public int solution(int n, long l, long r) {
        int answer = 0;
        String left = quin(l - 1);
        String right = quin(r);
        return cal(right) - cal(left);
    }
    
    private int cal(String temp){
        
        int n = temp.length();
        int res = 0;
        for(int i = 0; i < n; i++){
            
            int num = Integer.parseInt(String.valueOf(temp.charAt(i)));
            if(num == 0) continue;
            
            res += ((int) Math.pow(4, n - i - 1) * dec[num]);
            if(num == 2) return res;
        }
        return res;
    }
    private String quin(long num){
        return Long.toString(num, 5);
    }
}