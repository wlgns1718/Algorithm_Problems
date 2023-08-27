import java.util.*;

class Solution {
    public int solution(int[] a) {
        int answer = 0;
        int len = a.length - 1;
        int[] min_numR = new int[len+1];
        int[] min_numL = new int[len+1];
        min_numR[0] = a[0];
        min_numL[len] = a[len];
        for(int i = 1; i < len+1; i++){
            min_numR[i] = Math.min(min_numR[i-1],a[i]);
            min_numL[len-i] = Math.min(min_numL[len-i+1],a[len-i]);
        }
        answer += 2;
        // System.out.println(Arrays.toString(min_numR));
        // System.out.println(Arrays.toString(min_numL));
        for(int i = 1; i < len; i++){
            int cur = a[i];
            if(min_numR[i-1] < cur && min_numL[i+1] < cur){
                continue;
            }
            // System.out.println(cur);
            answer++;
        }
        return answer;
    }
}