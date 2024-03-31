import java.util.*;
import java.io.*;

public class Main {

    static class Info{
        int idx;
        int val;
        public Info(int idx, int val){
            this.idx = idx;
            this.val = val;
        }
    }
    static PriorityQueue<Info> pq = new PriorityQueue<>((o1,o2) -> o2.val - o1.val);
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 8; i++){
            int a = Integer.parseInt(br.readLine());
            pq.offer(new Info(i, a));
        }
        int answer = 0;
        int[] ls = new int[5];
        for(int i = 0; i < 5; i++){
            Info info = pq.poll();
            answer += info.val;
            ls[i] = info.idx + 1;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer).append("\n");
        Arrays.sort(ls);
        for(int a : ls){
            sb.append(a).append(" ");
        }
        System.out.println(sb);
    }
}