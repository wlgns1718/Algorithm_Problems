import java.util.*;

class Solution {
    static int[] number;
    static class Data{
        int index;
        double fail;
        public Data(int index, double fail){
            this.index = index;
            this.fail = fail;
        }
        @Override
        public String toString(){
            return "index: " + this.index + " fail: " + this.fail;
        }
    }
    static PriorityQueue<Data> pq = new PriorityQueue<>((o1,o2) -> {
        if(o2.fail == o1.fail){
            return o1.index - o2.index;
        }
        else{
            if(o2.fail - o1.fail < 0){
                return -1;
            }
            else{
                return 1;
            }
            
        }
        
    });
    
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        number = new int[N+2];
        for(int stage : stages){
            number[stage] ++;
        }
        
        for(int i = N; i > 0; i--){
            int cur = number[i];
            number[i] += number[i+1];
            if(number[i] == 0){
                pq.add(new Data(i, 0.0));
                continue;
            }
            pq.add(new Data(i, (double) cur/number[i]));
        }
        int idx = 0;
        while(!pq.isEmpty()){
            Data data = pq.poll();
            answer[idx++] = data.index;
        }   
        return answer;
    }
}