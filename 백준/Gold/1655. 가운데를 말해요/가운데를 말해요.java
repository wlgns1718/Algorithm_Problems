import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Integer> max = new PriorityQueue<>((o1,o2) -> o2-o1);
    static PriorityQueue<Integer> min = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){

            int num = Integer.parseInt(br.readLine());
            if(i == 0) {
                max.offer(num);
                sb.append(max.peek()).append("\n");
                continue;
            }
            if(i == 1){
                if(num > max.peek()){
                    min.offer(num);
                }
                else{
                    int temp = max.poll();
                    min.offer(temp);
                    max.offer(num);
                }
            }
            else{
                max.offer(num);
                if(max.peek() > min.peek()){
                    max.poll();
                    min.offer(num);
                    if(min.size() > max.size()){
                        max.offer(min.poll());
                    }
                }
                if(max.size() - min.size() > 1) min.offer(max.poll());
            }
            sb.append(max.peek()).append("\n");

        }
        System.out.println(sb);

    }


}