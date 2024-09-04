import java.io.*;
import java.util.*;

class Main {
    static int N, input[];
    static long[] prefix;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new int[N];
        String[] temp = br.readLine().split(" ");
        prefix = new long[N];
        for(int i = 0; i < N; i++){
            input[i] = Integer.parseInt(temp[i]);
            if(i == 0){
                prefix[i] = -input[i];
            }
            else{
                prefix[i] = prefix[i-1] - input[i];
            }
        }
        long answer = input[0];
        for(int i = 1; i < N; i++){
            answer = Math.max(answer, input[i] + prefix[i-1]);
        }
        System.out.println(answer);
    }
}