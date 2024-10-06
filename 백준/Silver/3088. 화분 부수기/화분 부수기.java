import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Set<Integer> set = new HashSet<>();
    static boolean[] visit = new boolean[1000001];
    static boolean[] vase;
    static int answer = 0;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        vase = new boolean[N+1];
        String[] input;
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            if(i == 0){
                answer++;
                visit[a] = true;
                visit[b] = true;
                visit[c] = true;
                continue;
            }
            else{
                if(!visit[a] && !visit[b] && !visit[c]){
                    //화분이 안깨진다면
                    answer++;
                }
                visit[a] = true;
                visit[b] = true;
                visit[c] = true;
            }

        }
        System.out.println(answer);
    }
}