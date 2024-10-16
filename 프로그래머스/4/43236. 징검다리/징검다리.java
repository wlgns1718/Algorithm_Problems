import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        //2, 11, 14, 17, 21
        //9, 3, 3, 4
        /*
        1. rocks를 정렬하고, 각 돌 사이의 거리를 구함
        2. 이분탐색으로 distance를 조절하며 각 거리에 따라 dis보다 작은
            값들이 n이 될 때 해당 값이 정답
        3. 만약 n보다 클경우 dis를 더 줄여야함
        4. 만약 n보다 작거나 같은 경우 dis를 크게할 수 있다.
        */
        //rocks 정렬
        Arrays.sort(rocks);
        
        int start = 1;
        int end = distance;
        int mid;
        
        while(start <= end){
            mid = (start + end) / 2;
            int temp = 0;
            int land = 0; //현재 거리
            for(int r : rocks){
                if(r - land < mid) temp++; //제거해야하는 돌
                else land = r;
            }
            if(distance - land < mid) temp++;
            
            if(temp <= n){
                //mid를 늘려야 한다.
                answer = start;
                start = mid + 1;
                
            }
            else{
                //mid를 작게
                end = mid - 1;
                answer = end;
            }
        }
        return answer;
    }
}