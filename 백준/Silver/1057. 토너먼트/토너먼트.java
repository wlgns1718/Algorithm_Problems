import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int answer = 0;
        while(a != b){
            answer ++;
            if(a % 2 != 0){
                a += 1;
            }
            if(b % 2 != 0){
                b += 1;
            }
            a /= 2;
            b /= 2;
        }
        System.out.println(answer);
        
    }
}