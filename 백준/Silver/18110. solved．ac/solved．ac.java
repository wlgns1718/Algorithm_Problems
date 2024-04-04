import javax.lang.model.element.NestingKind;
import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> o1-o2);
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        int limit = (int) Math.round(N * 0.15); //절삭할 인원
        for(int i = 0; i < N; i++){
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int temp = 0;
        for(int i = 0; i < limit; i++){
            pq.poll();
        }
        for(int i = 0; i < N - (limit * 2); i++){
            temp += pq.poll();
        }
        sb.append((int) Math.round(temp / (N - (2.0 * limit))));
        System.out.println(sb);
    }
}