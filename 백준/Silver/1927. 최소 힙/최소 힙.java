import java.io.*;
import java.util.*;

public class Main {

    static PriorityQueue<Long> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++){
            long a = Long.parseLong(br.readLine());
            if(a == 0){
                if(pq.isEmpty()){
                    sb.append(0).append("\n");
                }
                else{
                    sb.append(pq.poll()).append("\n");
                }
            }
            else{
                pq.offer(a);
            }
        }
        System.out.println(sb);
    }
}