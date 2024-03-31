import java.util.*;
import java.io.*;

public class Main {
    static int N, dis[], cost[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        dis = new int[N];
        cost = new int[N];
        int answer = 0;
        String[] input;
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            dis[i] = Integer.parseInt(input[0]);
            cost[i] = Integer.parseInt(input[1]);
        }

        boolean flag;
        for(int i = 0; i < N; i++){
            flag = true;
            Loop1:
            for(int j = 0; j < N; j++){
                if(i == j) continue;
                if(dis[i] > dis[j]){
                    if(cost[i] >= cost[j]){
                        flag = false;
                        break Loop1;
                    }
                }
                if(cost[i] > cost[j]){
                    if(dis[i] >= dis[j]){
                        flag = false;
                        break Loop1;
                    }
                }
            }
            if(flag) answer ++;
        }
        System.out.println(answer);
    }
}