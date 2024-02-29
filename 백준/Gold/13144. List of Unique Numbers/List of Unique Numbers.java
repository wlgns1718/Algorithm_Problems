import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long answer = 0L;

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int[] visit = new int[100001];
        while(start < N){
            while(end < N && visit[arr[end]] == 0){
                visit[arr[end++]]++;
            }
            answer += (end - start);
            visit[arr[start++]] --;
        }
        System.out.println(answer);
    }
}