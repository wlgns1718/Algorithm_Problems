import java.io.*;
import java.util.*;

public class Main {
    static long[] arr = new long[101];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());

        arr[1] = 1;
        arr[2] = 1;
        arr[3] = 1;
        arr[4] = 2;
        for(int i = 5; i <= 100; i++){
            arr[i] = arr[i-1] + arr[i-5];
        }
        for(int i = 0; i < TC; i++){
            System.out.println(arr[Integer.parseInt(br.readLine())]);
        }
    }

}