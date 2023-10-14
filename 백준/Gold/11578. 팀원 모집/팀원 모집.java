import java.util.*;
import java.io.*;


public class Main {
    static int N, M,cnt, answer = -1;
    static List<int[]> list = new ArrayList<>();
    static boolean[] visit;
    public static void main(String[] args) throws Exception {
//
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visit = new boolean[M];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int[] temp = new int[size];
            for(int j = 0; j < size; j++){
                temp[j] = Integer.parseInt(st.nextToken());
            }
            list.add(temp);

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
            HashSet<Integer> number = new HashSet<>();
            for(int i = 0; i < M; i++){
                if(!visit[i]) continue;
                int[] temp_list = list.get(i);
                for (int j : temp_list) {
                    number.add(j);
                }
            }
            if(number.size() == N){
                answer = idx;
            }
            return;
        }
        for(int i = 0; i < M; i++){
            if(visit[i]) continue;
            visit[i] = true;
            sol(idx+1);
            visit[i] = false;
        }
    }
}