import java.util.*;
class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2-o1);
    public int solution(int[] cards) {
        int answer = 0;
        boolean[] visit = new boolean[cards.length + 1];
        for(int i = 0; i < cards.length; i++){
            if(visit[cards[i]]) continue;
            Queue<Integer> q = new ArrayDeque<>();
            q.offer(cards[i]);
            visit[cards[i]] = true;
            int cnt = 1;
            while(!q.isEmpty()){
                int cur = q.poll();
                if(visit[cards[cur - 1]]) break;
                visit[cards[cur - 1]] = true;
                cnt++;
                q.offer(cards[cur - 1]);
            }
            pq.offer(cnt);
        }
        if(pq.size() >= 2){
            answer = pq.poll() * pq.poll();
        }
        return answer;
    }
}