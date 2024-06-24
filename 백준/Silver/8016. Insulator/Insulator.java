import java.util.*;
import java.io.*;

public class Main {
    static long answer = 0L;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> max = new PriorityQueue<>((o1,o2) -> o2-o1);
        PriorityQueue<Integer> min = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            max.offer(num);
            min.offer(num);
            answer += num;
        }
        int temp = 0;
        for(int i = 0; i < N/2; i++){
            if(i == N/2 - 1) temp = max.peek();
            answer += (max.poll() - min.poll());
        }

        if(N % 2 != 0){
            answer += Math.max(0, max.peek() - temp);
        }
        System.out.println(answer);
    }

}