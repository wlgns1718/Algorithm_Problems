import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static String[] bulb;
    static boolean[] visit;
    static int answer = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        bulb = new String[N];
        visit = new boolean[N];

        for(int i = 0; i < N; i++){
            String input = br.readLine();
            bulb[i] = input;
        }
        sol(sb, 0);
        System.out.println(answer);
    }
    private static void sol(StringBuilder sb, int idx){
        if(idx == N){
            int temp = 0;
            char pre = sb.charAt(0);
            for(int i = 1; i < sb.length(); i++){
                if(pre != sb.charAt(i)){
                    temp++;
                    pre = sb.charAt(i);
                }
            }
            answer = Math.min(answer, temp);
            return;
        }
        for(int i = 0; i < N; i++){
            if(visit[i]) continue;
            sb.append(bulb[i]);
            visit[i] = true;
            sol(sb, idx + 1);
            sb.delete(sb.length() - bulb[i].length(), sb.length());
            visit[i] = false;
        }
    }
}