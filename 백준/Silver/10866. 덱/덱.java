import javax.lang.model.element.NestingKind;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> q = new ArrayDeque<>();
        String[] order;
        for(int i = 0; i < N; i++){
            order = br.readLine().split(" ");
            if(order[0].equals("push_back")){
                int a = Integer.parseInt(order[1]);
                q.offerLast(a);
            }
            else if(order[0].equals("push_front")){
                int a = Integer.parseInt(order[1]);
                q.offerFirst(a);
            }
            else if(order[0].equals("pop_front")){
                if(!q.isEmpty()) sb.append(q.pollFirst()).append("\n");
                else sb.append(-1).append("\n");
            }
            else if(order[0].equals("pop_back")){
                if(!q.isEmpty()) sb.append(q.pollLast()).append("\n");
                else sb.append(-1).append("\n");
            }
            else if(order[0].equals("size")){
                sb.append(q.size()).append("\n");
            }
            else if(order[0].equals("empty")){
                if(q.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if(order[0].equals("front")){
                if(q.isEmpty()) sb.append(-1).append("\n");
                else sb.append(q.peekFirst()).append("\n");
            }else{
                if(q.isEmpty()) sb.append(-1).append("\n");
                else sb.append(q.peekLast()).append("\n");
            }
        }
        System.out.println(sb);
    }
}