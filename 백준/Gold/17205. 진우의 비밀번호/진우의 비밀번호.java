import java.io.*;
import java.util.*;

class Main {
    static int N;
    static String pw;
    static long answer = 0;
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        pw = br.readLine();

        int a = 'a';
        for(char word : pw.toCharArray()){
            int n = word - a;
            if(n > 0){
                answer += (n * 26 * ((long) Math.pow(26, N-1) / 25) + n);
            }
            answer ++;
            N --;
        }
        System.out.println(answer);
    }
}