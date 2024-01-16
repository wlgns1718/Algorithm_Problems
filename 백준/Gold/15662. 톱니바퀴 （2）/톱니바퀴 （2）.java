import java.io.*;
import java.util.*;

public class Main {

    static List<StringBuilder> ls = new ArrayList<>();
    static int N;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb1 = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            ls.add(new StringBuilder().append(br.readLine()));
        }
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++){
            String[] input = br.readLine().split(" ");
            int idx = Integer.parseInt(input[0]) - 1;
            int order = Integer.parseInt(input[1]);
            spin(idx,order);
//            for(StringBuilder sb : ls){
//                System.out.println(sb.toString());
//            }
//            System.out.println();
        }

        int answer = 0;

        for(StringBuilder sb : ls){
            if(sb.charAt(0) == '1'){
                answer++;
            }
        }
        System.out.println(answer);
    }

    private static void spin(int idx, int order){
        //1이면 시계 방향 -1이면 반시계
        //시계 방향이면 7에 있는걸 0에 넣고 8삭제
        //반시계 방향이면 0에 있는걸 8에 넣고 0삭제

        if (order == 1){
            StringBuilder sb = ls.get(idx);
            char left_char = sb.charAt(6);
            char right_char = sb.charAt(2);
            sb.insert(0, sb.charAt(7));
            sb.deleteCharAt(8);
            if(idx-1 >= 0 && left_char != ls.get(idx-1).charAt(2)){
                left(idx-1, -1);
            }
            if(idx + 1 < N && right_char != ls.get(idx+1).charAt(6)){
                right(idx+1, -1);
            }
        } else{
            StringBuilder sb = ls.get(idx);
            char left_char = sb.charAt(6);
            char right_char = sb.charAt(2);
            sb.insert(8, sb.charAt(0));
            sb.deleteCharAt(0);
            if(idx-1 >= 0 && left_char != ls.get(idx-1).charAt(2)){
                left(idx-1, 1);
            }
            if(idx + 1 < N && right_char != ls.get(idx+1).charAt(6)){
                right(idx+1, 1);
            }
        }
    }

    private static void left(int idx, int order){
        StringBuilder sb = ls.get(idx);
        char left_char = sb.charAt(6);
        if (order == 1){
            sb.insert(0, sb.charAt(7));
            sb.deleteCharAt(8);
            if(idx-1 >= 0 && left_char != ls.get(idx-1).charAt(2)){
                left(idx-1, -1);
            }
        } else{
            sb.insert(8, sb.charAt(0));
            sb.deleteCharAt(0);
            if(idx-1 >= 0 && left_char != ls.get(idx-1).charAt(2)){
                left(idx-1, 1);
            }
        }
    }
    private static void right(int idx, int order){
        StringBuilder sb = ls.get(idx);
        char right_char = sb.charAt(2);
        if (order == 1){
            sb.insert(0, sb.charAt(7));
            sb.deleteCharAt(8);
            if(idx + 1 < N && right_char != ls.get(idx+1).charAt(6)){
                right(idx+1, -1);
            }
        } else{
            sb.insert(8, sb.charAt(0));
            sb.deleteCharAt(0);
            if(idx + 1 < N && right_char != ls.get(idx+1).charAt(6)){
                right(idx+1, 1);
            }
        }
    }
}