import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {
    static int N;
    static long min = Long.MAX_VALUE, M;
    static long[] time;
    static long answer;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken()); // int -> long 수정

        time = new long[N];
        for(int i = 0; i < N; i++){
            time[i] = Long.parseLong(br.readLine());
            min = Math.min(min, time[i]); // 추가
        }

        answer = min * M; // 추가
        long start = 0;
        while (start <= answer){
            long mid = (start + answer)/2;

            long temp = 0;
            for(int i = 0; i < N; i++){
                temp += mid/time[i];
            }

            if(temp >= M){
                answer = mid - 1;
            }
            else{
                start = mid + 1;
            }

        }
        System.out.println(answer+1);  // 수정
    }

}