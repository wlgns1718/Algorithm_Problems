import java.io.*;
import java.util.*;

public class Main {
    static int N, S;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        int start = 0;
        int temp = 0;
        int answer = 100000;
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            temp += arr[i];
            if(temp < S) continue;

            while(temp >= S){
                temp -= arr[start++];
                if(start > i){
                    System.out.println(1);
                    return;
                }
            }
            if(answer > (i - start + 2)){
                answer = i - start + 2;
            }
        }
        System.out.println(answer == 100000 ? 0 : answer);
    }
}