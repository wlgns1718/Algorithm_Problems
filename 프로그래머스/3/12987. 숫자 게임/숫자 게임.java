import java.util.*;
class Solution {
    static PriorityQueue<Integer> a = new PriorityQueue<>((o1, o2) -> o2 - o1);
    static PriorityQueue<Integer> b = new PriorityQueue<>((o1, o2) -> o2 - o1);
    public int solution(int[] A, int[] B) {
        int answer = 0;
        for(int i = 0; i < A.length; i++){
            a.offer(A[i]);
            b.offer(B[i]);
        }
        
        while(!a.isEmpty() && !b.isEmpty()){
            if(b.peek() > a.peek()){
                answer++;
                b.poll();
                a.poll();
            }
            else{
                a.poll();
            }
        }
        return answer;
    }
}