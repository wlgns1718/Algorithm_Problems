import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[][] arr = new char[5][15];
        int[] brr = new int[5];
        for(int i = 0; i < 5; i++){
            String temp = br.readLine();
            for(int j = 0; j < temp.length(); j++){
                arr[i][j] = temp.charAt(j);
            }
            brr[i] = temp.length();
        }
        for(int i = 0; i < 15; i++){
            for(int j = 0; j < 5; j++){
                if(arr[j][i] == '\u0000') continue;
                sb.append(arr[j][i]);
            }
        }
        System.out.println(sb);

    }

}