import java.io.*;
import java.util.*;

public class Main {
    static int N, arr[];
    static List<List<Integer>> ls = new ArrayList<>();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        arr[1] = -1;
        for(int i = 0; i <= N; i++){
            ls.add(new ArrayList<>());
        }
        String[] input;
        for(int i = 0; i < N-1; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            ls.get(a).add(b);
            ls.get(b).add(a);
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int temp : ls.get(cur)){
                if(arr[temp] != 0) continue;
                arr[temp] = cur;
                q.offer(temp);
            }
        }
        for(int i = 2; i <= N; i++){
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb);
    }

}