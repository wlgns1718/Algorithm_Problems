import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static Integer[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        String[] input;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            if(input[0].equals("add")){
                set.add(Integer.parseInt(input[1]));
            }
            else if(input[0].equals("remove")){
                set.remove(Integer.parseInt(input[1]));
            }
            else if(input[0].equals("check")){
                if(set.contains(Integer.parseInt(input[1]))) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if(input[0].equals("toggle")){
                if(set.contains(Integer.parseInt(input[1]))) set.remove(Integer.parseInt(input[1]));
                else set.add(Integer.parseInt(input[1]));
            }
            else if(input[0].equals("all")){
                set.addAll(List.of(arr));
            }
            else{
                set.clear();
            }
        }
        System.out.println(sb);
    }
}