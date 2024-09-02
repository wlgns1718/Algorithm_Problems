import java.io.*;
import java.util.*;

class Main {
    static int N;
    static String cry;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cry = br.readLine();
        int answer = Integer.MAX_VALUE;
        for(int i = N; i >= 1; i--){
            answer = Math.min(answer, sol(cry, i));
        }
        System.out.println(answer);

    }
    private static int sol(String c, int per){

        char[] temp = c.toCharArray();
        //per은 주기
        int count = 0;

        for(int i = 0; i < temp.length; i++){
            if(temp[i] == '.') continue;
            count ++;

            Loop:
            for(int j = i; j < temp.length; j += per){
                if(temp[j] == '.') break Loop;
                temp[j] = '.';
            }
        }
        return count;
    }
}