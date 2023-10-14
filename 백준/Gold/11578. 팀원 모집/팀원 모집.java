import java.util.*;
import java.io.*;


public class Main {
    static int N, M,cnt, answer = -1,target;
    static int[] students;
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        students = new int[M];
        visit = new boolean[M];
        target = (int)Math.pow(2,N+1)-1;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            for(int j = 0; j < size; j++){
                students[i] |= (1 << Integer.parseInt(st.nextToken()));
            }
        }
        for(int i = 1; i <= M; i++){
            if(answer != -1) break;
            cnt = i;
            sol(0);
        }
        System.out.println(answer);

    }
    public static void sol(int idx){

        if(idx == cnt){
            int temp = 1;
            for(int i = 0; i < M; i++){
                if(visit[i]){
                    temp |= students[i];
                    if(temp == target) break;
                }
            }
            if(temp == target){
                answer = idx;
            }
            return;
        }


        for(int i = 0; i < M; i++){
            if(visit[i])continue;
            visit[i] = true;
            sol(idx + 1);
            visit[i] = false;
        }
    }

}