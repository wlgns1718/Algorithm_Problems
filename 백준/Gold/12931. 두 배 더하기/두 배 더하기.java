import java.io.*;
import java.util.*;

public class Main {
    static int n, arr[];
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        int answer = 0;
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        while(!check()){
            List<Integer> ls = cal();
            if(ls.isEmpty()){
                answer ++;
                for(int i = 0; i < n; i++){
                    arr[i] /= 2;

                }
            }
            else{
               for(int idx : ls){
                   arr[idx] -= 1;
                   answer ++;
               }
            }
        }
        System.out.println(answer);

    }
    private static List<Integer> cal(){
        List<Integer> ls = new ArrayList<>();
        for(int i = 0; i < n; i++){
            if(arr[i] % 2 != 0){
                ls.add(i);
            }
        }
        return ls;
    }
    private static boolean check(){
        for(int i = 0; i < n; i++){
            if(arr[i] != 0) return false;
        }
        return true;
    }
}