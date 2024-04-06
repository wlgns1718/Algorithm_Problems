import java.io.*;
import java.util.*;

public class Main {
    static int N, idx;
    static class Info{
        int idx;
        int val;
        public Info(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        String[] input;
        for(int i = 0; i < TC; i++){
            input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            idx = Integer.parseInt(input[1]);

            input = br.readLine().split(" ");
            Queue<Info> q = new ArrayDeque<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2-o1);
            for(int j = 0; j < N; j++){
                int val = Integer.parseInt(input[j]);
                q.offer(new Info(j, val));
                pq.offer(val);
            }
            int cnt = 0;
            Loop1:
            while(!pq.isEmpty()){
                int cur_val = pq.poll();
                while(q.peek().val != cur_val){
                    Info info = q.poll();
                    q.offer(info);
                }
                cnt++;
                if(q.poll().idx == idx) break Loop1;
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}