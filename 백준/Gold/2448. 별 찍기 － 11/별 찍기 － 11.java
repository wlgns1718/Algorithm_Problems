import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static StringBuilder sb;
    static String[] answer;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        answer = new String[N];
        answer[0] = "  *  ";
        answer[1] = " * * ";
        answer[2] = "*****";
        for(int i = 1; 3 * (int)(Math.pow(2, i)) <= N; i++){
            sol(i);
        }
        sb.delete(0, sb.length());
        for(int i = 0; i < N; i++){
            sb.append(answer[i]+ "\n");
        }
        System.out.println(sb.toString());

    }
    private static void sol(int n){
        int bottom = 3 * (int) Math.pow(2,n); //맨 마지막 행
        int start = bottom/2; //시작 행

        // n = 1일 떄 bottom = 6 start = 3
        for(int i = start; i < bottom; i++){
            sb.delete(0, sb.length());
            answer[i] = sb.append(answer[i-start]).append(" ").append(answer[i-start]).toString();
        }

        //start 이전 행에 빈칸 추가. 빈 칸은 start 만큼
        String blank = " ".repeat(start);
        for(int i = 0; i < start; i++){
            sb.delete(0, sb.length());
            answer[i] = sb.append(blank).append(answer[i]).append(blank).toString();
        }
    }
}