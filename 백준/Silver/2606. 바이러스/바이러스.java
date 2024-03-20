import java.io.*;
import java.util.*;

public class Main {
    static int N, M, arr[][];
    static boolean[] visit;

    public static void main (String[] operations) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        arr = new int[N][N];
        visit = new boolean[N];
        visit[0] = true;

        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(0);
        int answer = 0;
        while(!q.isEmpty()){

            int cur = q.poll();

            for(int i = 0; i < N; i++){
                if(arr[cur][i] == 0) continue;
                if(visit[i]) continue;

                visit[i] = true;
                answer++;
                q.offer(i);
            }

        }
        System.out.println(answer);
    }

}