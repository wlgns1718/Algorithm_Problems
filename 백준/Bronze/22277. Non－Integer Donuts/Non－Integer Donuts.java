import java.io.*;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int b = 0;

        //초기 금액
        String input = br.readLine();
        String[] temp;

        temp = cal(input);

        b += Integer.parseInt(temp[1]);
        int answer = 0;
        for(int i = 0; i < N; i++){
            input = br.readLine();
            temp = cal(input);
            b += Integer.parseInt(temp[1]);
            if(b % 100 != 0) answer++;
        }
        System.out.println(answer);
    }
    private static String[] cal(String input){

        String cost;
        cost = input.substring(1);
        return cost.split("\\.");
    }
}