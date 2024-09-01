import java.io.*;
import java.util.*;

class Main {
    static int N, A, B, C;
    static int[] toping;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        A = Integer.parseInt(input[0]); //도우 가걱
        B = Integer.parseInt(input[1]); //토핑 가격
        C = Integer.parseInt(br.readLine()); //도우 열량
        toping = new int[N];
        for(int i = 0; i < N; i++){
            toping[i] = Integer.parseInt(br.readLine()); //토핑 열량
        }
        Arrays.sort(toping);
        int answer = C/A;
        int cost = A;
        int total = C;
        for(int i = N-1; i >= 0; i--){
            cost += B;
            total += toping[i];
            answer = Math.max(answer, total / cost);
        }
        System.out.println(answer);


    }
}