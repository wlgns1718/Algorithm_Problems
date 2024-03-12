import java.io.*;
import java.util.*;

public class Main {
    static int H, W,arr[],right[], left[], answer = 0;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        H = Integer.parseInt(input[0]);
        W = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        arr = new int[W];
        for(int i = 0; i < W; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        right = new int[W];
        left = new int[W];
        right[W-1] = arr[W-1];
        left[0] = arr[0];

        for(int i = 1; i < W; i++){
            left[i] = Math.max(left[i-1], arr[i]);
        }
        for(int i = W-2; i >= 0; i--){
            right[i] = Math.max(right[i+1],arr[i]);
        }
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));

        for(int i = 1; i < W-1; i++){
            if(arr[i] < left[i] && arr[i] < right[i]){
                answer += (Math.min(left[i],right[i]) - arr[i]);
            }
        }
        System.out.println(answer);

    }
}