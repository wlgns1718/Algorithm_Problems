import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main (String[] operations) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            sb.append(Integer.parseInt(input[0]) + Integer.parseInt(input[1])).append("\n");
        }
        System.out.println(sb);

    }
}