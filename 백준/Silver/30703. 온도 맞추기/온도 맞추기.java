import java.io.*;
import java.util.*;

class Main {
    static int N, start[], target[], temp[], res[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        N = Integer.parseInt(br.readLine());
        start = new int[N];
        target = new int[N];
        temp = new int[N];
        res = new int[N];
        int answer = 0;
        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            start[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            target[i] = Integer.parseInt(input[i]);
        }
        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            temp[i] = Integer.parseInt(input[i]);
        }

        for(int i = 0; i < N; i++){
            if(start[i] == target[i]) continue;

            //바꿔야하는 온도
            int c = Math.abs(start[i] - target[i]);

            if(c % temp[i] != 0){
                //조절할 수 없다면
                System.out.println(-1);
                return;
            }
            res[i] = c / temp[i];
        }
        boolean flag = false;
        answer = Math.max(answer, res[0]);
        if(res[0] % 2 == 0) flag = true;
        else flag = false;

        for(int i = 1; i < N; i++){
            if(flag && res[i] % 2 != 0){
                System.out.println(-1);
                return;
            }
            else if(!flag && res[i] % 2 == 0){
                System.out.println(-1);
                return;
            }
            answer = Math.max(answer, res[i]);
        }
        System.out.println(answer);
    }

}