import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        int num = 24;
        int N = Integer.parseInt(br.readLine());
        if(N < 5){
            System.out.println(0);
            return;
        }
        else{
            for(int i = 5; i <= N; i++){
                int temp = num * i;
                while(temp % 10 == 0){
                    cnt ++;
                    temp /= 10;
                }
            }
        }
        System.out.println(cnt);
    }
}