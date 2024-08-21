import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N % 7 == 0){
            if(String.valueOf(N).contains("7")){
                System.out.println(3);
            }
            else{
                System.out.println(1);
            }
        }
        else{
            if(String.valueOf(N).contains("7")){
                System.out.println(2);
            }
            else{
                System.out.println(0);
            }
        }

    }
}