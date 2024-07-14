import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static List<List<Integer>> ls = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        for(int i = 0; i <= N; i++){
            ls.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            ls.get(s).add(e);
        }

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        int cnt = 1;
        boolean[] visit = new boolean[N+1];
        visit[1] = true;
        while(!q.isEmpty()){
            int len = q.size();

            for(int i = 0; i < len; i++){
                int cur = q.poll();
                for(int temp : ls.get(cur)){
                    if(visit[temp]) continue;
                    visit[temp] = true;
                    if(temp == N){
                        System.out.println(cnt);
                        return;
                    }
                    q.offer(temp);
                }
            }
            cnt++;
        }
        System.out.println(-1);
    }

}