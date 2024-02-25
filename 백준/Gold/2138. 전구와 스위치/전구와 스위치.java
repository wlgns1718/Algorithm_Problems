import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean[] after;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        char[] temp_before = br.readLine().toCharArray();
        char[] temp_after  = br.readLine().toCharArray();

        boolean[] before = new boolean[N];
        after = new boolean[N];
        for(int i = 0; i < N; i++){
            if(temp_before[i] == '1'){
                before[i] = true;
            }
            if(temp_after[i] == '1'){
                after[i] = true;
            }
        }
        int case1 = sol(before.clone(), 0);
        before[0] = !before[0];
        before[1] = !before[1];
        int case2 = sol(before.clone(), 1);
        int answer = Integer.MAX_VALUE;
        if(case1 != -1){
            answer = Math.min(answer, case1);
        }
        if(case2 != -1){
            answer = Math.min(answer, case2);
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
    private static int sol(boolean[] before, int val){
        //첫 번째 전구를 그대로 가져가는 경우
        int cnt = val;
        for(int i = 0; i < N; i++){
            if(after[i] != before[i]){
                if(i == N-1){
                    return -1;
                }
                cnt++;
                before[i+1] = !before[i+1];
                if( i + 2 < N) {
                    before[i+2] = !before[i+2];
                }
            }
        }
        return cnt;
    }

}