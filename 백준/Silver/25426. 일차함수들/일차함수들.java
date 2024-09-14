import java.io.*;
import java.util.*;

class Main {
    static int N;
    static long answer = 0;
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input;
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            pq.offer(Integer.parseInt(input[0]));
            answer += Long.parseLong(input[1]);
        }
        for(int i = 1; i <= N; i++){
            answer += ((long) i * pq.poll());
        }
        System.out.println(answer);
    }

}