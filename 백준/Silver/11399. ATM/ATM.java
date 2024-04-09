import java.io.*;
import java.util.*;

public class Main {
    static int N;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            pq.offer(Integer.parseInt(input[i]));
        }
        int answer = 0;
        int temp = 0;
        while(!pq.isEmpty()){
            int a = pq.poll();
            answer += ( a + temp);
            temp += a;
        }
        System.out.println(answer);
    }
}