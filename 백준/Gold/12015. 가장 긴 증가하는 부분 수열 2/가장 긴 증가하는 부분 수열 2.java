import java.util.*;
import java.io.*;


public class Main {
    static int N, arr[];
    static List<Integer> ls = new ArrayList<>();
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        arr = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        ls.add(arr[0]);
        for(int i = 1; i < N; i++){
            if(ls.get(ls.size() - 1) < arr[i]){
                ls.add(arr[i]);
            }
            else{
                change(arr[i]);
            }
        }
        System.out.println(ls.size());

    }
    private static void change(int num){
        int start = 0;
        int end = ls.size() - 1;
        while(start < end){
            int mid = (start + end)/2;
            if(ls.get(mid) >= num){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        ls.set(end, num);
    }
}