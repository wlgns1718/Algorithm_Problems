import javax.lang.model.element.NestingKind;
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(input[i]);
            if(!map.containsKey(a)){
                map.put(a,1);
            }
            else{
                int temp = map.get(a);
                map.replace(a,temp + 1);
            }
        }
        N = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(input[i]);
            if(!map.containsKey(a))sb.append(0).append(" ");
            else sb.append(map.get(a)).append(" ");
        }
        System.out.println(sb);
    }
}