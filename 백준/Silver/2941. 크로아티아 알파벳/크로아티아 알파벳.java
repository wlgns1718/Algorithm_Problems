import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        HashSet<String> set = new HashSet<>();
        set.add("c=");
        set.add("c-");
        set.add("dz=");
        set.add("d-");
        set.add("lj");
        set.add("nj");
        set.add("s=");
        set.add("z=");
        StringBuilder sb = new StringBuilder();
        int answer = 0;
        for(int i = 0; i < input.length(); i++){
            if(sb.length() > 2 && !sb.toString().equals("dz")){
                answer++;
                sb.deleteCharAt(0);
            }
            if(set.contains(sb.toString())){
                answer++;
                sb.delete(0, sb.length());
            }
            sb.append(input.charAt(i));
            if(set.contains(sb.toString())){
                answer++;
                sb.delete(0, sb.length());
            }

        }
        if(sb.length() != 0){
            if(set.contains(sb)) answer++;
            else{
                answer += sb.length();
            }
        }
        System.out.println(answer);
    }

}