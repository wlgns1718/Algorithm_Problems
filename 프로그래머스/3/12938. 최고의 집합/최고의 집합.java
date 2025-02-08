import java.util.*;
class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        //n개로 이루어진 자연수
        //모든 원소의 합이 S
        
        //9 2 4
        int temp = s / n;
        
        if(temp == 0) return new int[]{-1};
        
        if(s % n != 0){
            
            int remain = s % n;
            int idx = 0;
            
            for(int i = 0; i < n - remain; i++){
                answer[i] = temp;
                idx = i;
            }
            
            for(int i = idx + 1; i < idx + remain + 1; i++){
                answer[i] = temp + 1;
            }
            
        }else{
            for(int i = 0; i < n; i++){
                answer[i] = temp;
            }
        }
        return answer;
    }
}