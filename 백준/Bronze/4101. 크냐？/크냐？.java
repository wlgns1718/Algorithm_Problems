import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true){
            String[] input = br.readLine().split(" ");
            
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            if(a == 0 && b == 0) break;
            if(a > b){
                sb.append("Yes").append("\n");
                
            }
            else{
                sb.append("No").append("\n");
            }
        }
        System.out.println(sb);
    }
}