import java.util.*;
import java.io.*;

public class Main {
    static int N;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        String[] input;
        int[] arr = new int[3];
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            arr[0] = Integer.parseInt(input[0]);
            arr[1] = Integer.parseInt(input[1]);
            arr[2] = Integer.parseInt(input[2]);
            Arrays.sort(arr);
            sb.append("Case #").append(i+1).append(": ");

            if(arr[2] >= arr[0] + arr[1]) sb.append("invalid!").append("\n");
            else if(arr[0] == arr[1] && arr[1] == arr[2]) sb.append("equilateral").append("\n");
            else if(arr[0] == arr[1] || arr[1] == arr[2]) sb.append("isosceles").append("\n");
            else sb.append("scalene").append("\n");
        }
        System.out.println(sb);
    }

}