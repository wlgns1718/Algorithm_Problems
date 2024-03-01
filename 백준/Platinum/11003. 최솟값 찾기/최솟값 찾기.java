import java.io.*;
import java.util.*;

public class Main {
    static int N, L;
    static Deque<Data> deque = new ArrayDeque<>();
    static class Data{
        int val;
        int idx;

        public Data(int val, int idx){
            this.idx = idx;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "val=" + val +
                    ", idx=" + idx +
                    '}';
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            int n = Integer.parseInt(st.nextToken());
            if(deque.isEmpty()){
                deque.offer(new Data(n,i));
                sb.append(n).append(" ");
                continue;
            }
            while(!deque.isEmpty() && deque.getLast().val > n){
                deque.pollLast();
            }
            while(!deque.isEmpty() && deque.getFirst().idx <= i-L){
                deque.pollFirst();
            }
            deque.offer(new Data(n,i));
            sb.append(deque.getFirst().val + " ");
        }
        System.out.println(sb);
    }
}