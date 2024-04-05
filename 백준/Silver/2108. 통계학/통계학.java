import java.io.*;
import java.util.*;

public class Main {
    static int N, min = 4000, max = -4000, mode = 0, ans = 0;
    static long sum = 0L;
    static int[] arr;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[8001];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(br.readLine());
            sum += a;
            arr[a + 4000] ++;
            if(arr[a+4000] > mode){
                mode = arr[a+4000];
                ans = a;
            }

            if(a > max) max = a;
            if(a < min) min = a;
            pq.offer(a);
        }
        int temp = 0;
        for(int i = 0; i <= 8000; i++){
            if(arr[i] == mode){
                temp++;
                ans = i;
            }
            if(temp >= 2) break;
        }
        for(int i = 0; i < N/2; i++){
            pq.poll();
        }

        sb.append((int) Math.round((double) sum / N)).append("\n");
        sb.append(pq.peek()).append("\n");
        sb.append(ans - 4000).append("\n");
        sb.append(max-min).append("\n");
        System.out.println(sb);
    }
}