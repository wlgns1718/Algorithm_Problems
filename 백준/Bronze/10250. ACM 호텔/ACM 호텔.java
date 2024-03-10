import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int i = 0; i < TC; i++){

            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);
            int idx = Integer.parseInt(input[2]);
            int cnt = 0;
            Loop1 :
            for(int c = 1; c <= m; c++){
                for(int r = 1; r <= n; r++){
                    cnt++;
                    if(cnt == idx){
                        sb.append(r);
                        if(c < 10){
                            sb.append(0).append(c).append("\n");
                        }else{
                            sb.append(c).append("\n");
                        }
                        break Loop1;
                    }
                }
            }

        }
        System.out.println(sb);

    }
}