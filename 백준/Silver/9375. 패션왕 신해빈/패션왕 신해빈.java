import java.io.*;
import java.util.*;

public class Main {
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for(int i = 0; i < TC; i++){
            map.clear();
            int N = Integer.parseInt(br.readLine());
            for(int j = 0; j < N; j++){
                String[] input = br.readLine().split(" ");
                if(!map.containsKey(input[1])){
                    map.put(input[1], 1);
                }
                map.replace(input[1], map.get(input[1]) + 1);
            }

            int answer = 1;
            for(int cnt : map.values()){
                answer *= cnt;
            }
            sb.append(answer - 1).append("\n");
        }
        System.out.println(sb);
    }
}