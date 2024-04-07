import java.io.*;
import java.util.*;

public class Main {
    static int N, temp = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= 20; i++){
            temp += 1 << i;
        }
        int a = 0;

        String[] input;
        for(int i = 0; i < N; i++){
            input = br.readLine().split(" ");
            if(input[0].equals("add")){
                int idx = Integer.parseInt(input[1]);
                if((a & 1 << idx) == 0) a += 1 << idx;
            }
            else if(input[0].equals("remove")){
                int idx = Integer.parseInt(input[1]);
                if((a & 1 << idx) != 0) a -= 1 <<idx;
            }
            else if(input[0].equals("check")){
                int idx = Integer.parseInt(input[1]);
                if((a & 1 << idx) != 0) bw.write(1 + "\n");
                else bw.write(0 + "\n");
            }
            else if(input[0].equals("toggle")){
                int idx = Integer.parseInt(input[1]);
                if((a & 1 << idx) != 0) a -= 1 << idx;
                else a += 1 << idx;
            }
            else if(input[0].equals("all")){
                a = temp;
            }
            else{
                a = 0;
            }
        }
        bw.flush();
    }
}