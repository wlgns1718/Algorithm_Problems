import java.util.*;

class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>(); //무적권을 사용한 적 정보
    public int solution(int n, int k, int[] enemy) {
        int answer = -1;
        //처음 병사 수 n, 무적권 k, 적 정보 enemy
        for(int i = 0; i < enemy.length; i++){
            int cur = enemy[i];
            if(pq.size() < k) pq.offer(cur);
            else{
                //pq사이즈가 k와 같을 때 현재 값과 pq.peek 값 중 더 작은걸 현재 n에서 빼기
                if(cur > pq.peek()){
                    //현재 값이 더 클 때 여기에 무적권을 사용
                    n -= pq.poll();
                    pq.offer(cur);
                }
                else{
                    //peek값이 cur보다 크거나 같을 때
                    n -= cur;
                }
            }
            
            //만약 n이 0이하가 된다면
            if(n < 0){
                answer = i;
                break;
            }
        }
        if(answer == -1) answer = enemy.length;
        
        return answer;
    }
}