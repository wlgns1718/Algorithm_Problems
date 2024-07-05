import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    static int N, arr[] = new int[21];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init();
        N = Integer.parseInt(br.readLine());
        System.out.println(arr[N]);
    }
    private static void init(){
        arr[1] = 1;
        for(int i = 2; i <= 20; i++){
            arr[i] = arr[i-1] + arr[i-2];
        }
    }
}