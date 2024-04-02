import java.io.*;
import java.util.*;
public class Main {
    static TreeSet<String> treeSet = new TreeSet<>((o1,o2)->{
        if(o1.length() == o2.length()){
            return o1.compareTo(o2);
        }
        else{
            return o1.length() - o2.length();
        }
    });
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            String input = br.readLine();
            treeSet.add(input);
        }
        for(String t : treeSet){
            sb.append(t).append("\n");
        }
        System.out.println(sb);
    }
}