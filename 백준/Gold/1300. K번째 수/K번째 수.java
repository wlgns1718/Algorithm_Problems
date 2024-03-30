import java.util.*;
import java.io.*;


public class Main {
    static int N, K, answer;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        int start = 0;
        int end = K;
        while(start <= end){
            int mid = (start + end) / 2;
            int temp = 0; //해당 수 보다 낮은 수의 개수
            for(int i = 1; i <= N; i++){
                if(mid % i == 0){
                    temp += Math.min(N, (mid/i) - 1);
                }
                else{
                    temp += Math.min(N, mid/i);
                }

            }
            if(temp >= K){
                end = mid - 1;
                answer = end;
            }
            else{
                answer = end;
                start = mid + 1;

            }

        }
        System.out.println(answer);
    }
}