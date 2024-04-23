import java.io.*;
import java.util.*;

public class Main {
    static int[] arr = new int[1001];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        arr[1] = 1;
        arr[2] = 3;
        arr[3] = 5;
        for(int i = 4; i <= 1000; i++){
            arr[i] = (arr[i-1] + arr[i-2] * 2) % 10007;
        }
        sb.append(arr[Integer.parseInt(br.readLine())]);
        System.out.println(sb);
    }

}