import java.io.*;
import java.util.*;

public class Main {
    static int N, M;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> str = new HashMap<>();
        HashMap<Integer, String> idx = new HashMap<>();
        for(int i = 1; i <= N; i++){
            String temp = br.readLine();
            str.put(temp, i);
            idx.put(i, temp);
        }
        for(int i = 0; i < M; i++){
            String temp = br.readLine();
            try{
                int a = Integer.parseInt(temp);
                sb.append(idx.get(a)).append("\n");
            }catch (NumberFormatException e){
                sb.append(str.get(temp)).append("\n");
            }
        }
        System.out.println(sb);
    }
}