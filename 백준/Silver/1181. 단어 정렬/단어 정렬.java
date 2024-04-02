import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<String> pq = new PriorityQueue<>((o1,o2) ->{
        if(o1.length() == o2.length()){
            return o1.compareTo(o2);
        }
        else{
            return o1.length() - o2.length();
        }
    });
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            if(set.contains(input)) continue;
            set.add(input);
            pq.offer(input);
        }
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb);
    }
}