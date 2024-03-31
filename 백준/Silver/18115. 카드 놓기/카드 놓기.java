import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Deque<Integer> deque = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int left = 0;
        int right = N - 1;
        int card = 1;
        String[] input = br.readLine().split(" ");
        for(int i = input.length - 1; i >= 0; i--){
            if(input[i].equals("1")){
                deque.offerFirst(card++);
            }
            else if(input[i].equals("2")){
                int temp = deque.pollFirst();
                deque.offerFirst(card++);
                deque.offerFirst(temp);
            }
            else{
                deque.offerLast(card++);
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i : deque){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}