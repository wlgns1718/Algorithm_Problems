import java.util.*;

class Solution {
    static int[] height;
    static long square;
    public long solution(int k, int d) {
        long answer = 0;
        height = new int[d + 1];
        height[0] = d;
        
        square = (long) Math.pow(d, 2);
        long temp;
        for(int i = k; i < d; i += k){
            temp = (long) Math.pow(i, 2);
            height[i] = (int) Math.sqrt(square - temp);
        }
        for(int i = 0; i <= d; i += k){
            answer += (height[i] / k) + 1;
        }
        return answer;
    }
}