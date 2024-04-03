import javax.lang.model.element.NestingKind;
import java.io.*;
import java.util.*;

public class Main {
    static class Node{
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            if(o1.x == o2.x){
                return o1.y - o2.y;
            }
            return o1.x - o2.x;
        });
        String[] input;
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            pq.offer(new Node(a, b));
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            Node node = pq.poll();
            sb.append(node.x).append(" ").append(node.y).append("\n");
        }
        System.out.println(sb);
    }
}