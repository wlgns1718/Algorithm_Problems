import java.util.*;
import java.io.*;

public class Main {
    static int G;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        G = Integer.parseInt(br.readLine());
        boolean flag = false;

        int g = (int)(Math.sqrt(G));
        if(g*g == G){
            g --;
        }
        for(int i = g; i >= 1; i-- ){
            if(G % i == 0){
                if(((G/i + i) % 2 == 0)){
                    bw.write((G/i + i)/2 + "\n");
                    flag = true;
                }

            }
        }
        if(flag){
            bw.flush();
        }
        else{
            System.out.println(-1);
        }
    }
}