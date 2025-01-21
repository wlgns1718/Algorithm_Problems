import java.util.*;

class Solution {
    static class Info{
        int a;
        int b;
        public Info(int a, int b){
            this.a = a;
            this.b = b;
        }
    }
    static PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2)->{
        if(o1.a == o2.a){
            return o1.b - o2.b;
        }
        return o2.a - o1.a;
    });
    public int solution(int[][] scores) {
        int answer = 0;
        int a = scores[0][0];
        int b = scores[0][1];
        int target = a + b;
        for(int[] s : scores){
            pq.offer(new Info(s[0],s[1]));
        }
        int max_b = 0;
        while(!pq.isEmpty()){
            Info cur = pq.poll();
            if(a < cur.a && b < cur.b) return -1;
            
            if(cur.b >= max_b){
                max_b = cur.b;
                if(cur.a + cur.b > target) answer++;
            }
            
        }
        return answer + 1;
    }
}