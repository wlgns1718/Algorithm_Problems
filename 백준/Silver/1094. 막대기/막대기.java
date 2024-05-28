import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int answer = 0;
        for(int i = 6; i >= 0; i--){
            if((N & 1 << i) != 0) answer++;
        }
        System.out.println(answer);
    }

}