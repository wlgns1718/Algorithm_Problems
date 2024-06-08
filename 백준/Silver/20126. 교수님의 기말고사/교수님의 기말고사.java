import java.util.*;
import java.io.*;

public class Main {
    static int N, M, S;
    static class Info{
        int start;
        int term;

        public Info(int start, int term){
            this.start = start;
            this.term = term;
        }
    }
    static PriorityQueue<Info> pq = new PriorityQueue<>((o1,o2) -> o1.start - o2.start);
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        S = Integer.parseInt(input[2]);
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int term = Integer.parseInt(input[1]);
            pq.offer(new Info(start, term));
        }
        int answer = -1;
        int s = 0;
        while(!pq.isEmpty()){
            Info cur = pq.poll();
            if(s + M <= cur.start && s + M <= S){
                answer = s;
                break;
            }
            s = cur.start + cur.term;
        }
        if(s + M <= S){
            answer = s;
        }
        System.out.println(answer);


    }

}