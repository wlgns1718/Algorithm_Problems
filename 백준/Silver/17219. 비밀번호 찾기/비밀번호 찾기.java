import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] input;
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            map.put(input[0], input[1]);
        }
        String temp;
        for(int i = 0; i < M; i++){
            temp = br.readLine();
            sb.append(map.get(temp)).append("\n");
        }
        System.out.println(sb);
    }
}