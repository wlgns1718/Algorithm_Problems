import java.util.*;
import java.io.*;


public class Main {
    static int N, M, answer = 11,target;
    static int[] students;
    public static void main(String[] args) throws Exception {
//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        students = new int[M+1];
        target = 0;
        for(int i = 1; i <= N; i++){
            target |= 1 << i;
        }
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for(int j = 0; j < size; j++){
                students[i] |= (1 << Integer.parseInt(st.nextToken()));
            }
        }
        sol(1, 0, 0);
        if(answer == 11) answer = -1;
        System.out.println(answer);

    }
    private static void sol(int idx, int cnt, int flag){
        if (flag == target) {
            answer = Math.min(answer, cnt);
            return;
        }

        for (int i = idx; i <= M; i++) {
            sol(i+1, cnt+1, (flag | students[i]));
        }
    }

}