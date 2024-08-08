import java.io.*;
import java.util.Arrays;

class Main {
    static int N;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());

        for(int i = 0; i < TC; i++){

            N = Integer.parseInt(br.readLine());
            String bin = Integer.toBinaryString(N);
            for(int j = bin.length() - 1; j >= 0; j--){
                if(bin.charAt(j) == '1') sb.append(bin.length() - j - 1).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}