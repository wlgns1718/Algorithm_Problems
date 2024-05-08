import java.util.*;
import java.io.*;

public class Main {
    static int N, arr[], answer[];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        answer = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        for(int i = 0; i < N; i++){
            int idx = arr[i];
            int temp = 0;
            int cnt = 0;
            while(cnt < idx){

                if(answer[temp] == 0){
                    cnt++;
                }
                temp++;
            }
            while(answer[temp] != 0){
                temp++;
            };
            answer[temp] = i+1;
        }
        for(int i = 0; i < N; i++){
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }

}