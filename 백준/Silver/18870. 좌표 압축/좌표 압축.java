import java.io.*;
import java.util.*;

public class Main {
    static int[] ls;
    static class Info{
        int idx;
        long val;

        public Info(int idx, long val){
            this.idx = idx;
            this.val = val;
        }
    }
    static PriorityQueue<Info> pq = new PriorityQueue<>((o1,o2) ->{
        if(o1.val < o2.val){
            return -1;
        }
        else{
            return 1;
        }
    });
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        ls = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            pq.offer(new Info(i, Long.parseLong(input[i])));
        }

        long temp = pq.peek().val;
        int cnt = 0;

        while(!pq.isEmpty()){
            Info cur = pq.poll();
            if(cur.val > temp){
                cnt++;
                temp = cur.val;
            }
            ls[cur.idx] = cnt;
        }
        for(int i : ls){
            sb.append(i).append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);

    }

}