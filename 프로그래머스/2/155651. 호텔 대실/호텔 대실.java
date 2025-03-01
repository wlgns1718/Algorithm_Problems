import java.util.*;
class Solution {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static PriorityQueue<Info> sort = new PriorityQueue<>((o1,o2)->{
        if(o1.start != o2.start) return o1.start - o2.start;
        return o2.end - o1.end;
    });
    static class Info{
        int start;
        int end;
        public Info(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public int solution(String[][] book_time) {
        
        int answer = 0;
        for(String[] temp : book_time){
            
            int start = Integer.parseInt(temp[0].replace(":",""));
            int end = Integer.parseInt(temp[1].replace(":", "")) + 10;
            if(end % 100 >= 60){
                end += 40;
            }
            sort.offer(new Info(start, end));
        }
        while(!sort.isEmpty()){
            Info info = sort.poll();
            while(!pq.isEmpty()){
                if(pq.peek() <= info.start) pq.poll();
                else break;
            }
            pq.offer(info.end);
            answer = Math.max(answer, pq.size());
        }
        return answer;
    }
} 