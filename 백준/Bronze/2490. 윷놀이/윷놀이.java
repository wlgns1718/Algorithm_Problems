import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i = 0; i < 3; i++){
            String[] input = br.readLine().split(" ");
            int cnt = 0;
            for(int j = 0; j < 4; j++){
                if(input[j].equals("1")) cnt++;
            }
            if(cnt == 0){
                System.out.println("D");
            }
            else if(cnt == 3){
                System.out.println("A");
            }
            else if(cnt == 2){
                System.out.println("B");
            }
            else if(cnt == 1){
                System.out.println("C");
            }
            else{
                System.out.println("E");
            }
        }
    }
}