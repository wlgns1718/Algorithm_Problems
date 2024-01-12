import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            bw.write(sol(input)+"\n");
        }
        bw.flush();
    }
    private static long sol(String[] input){
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(String temp : input){
            pq.offer(Long.parseLong(temp));
        }
        long answer = 0;
        while(pq.size() > 1){
            long a = pq.poll();
            long b = pq.poll();
            answer += a+b;
            pq.offer(a+b);
        }
        return answer;
    }
}