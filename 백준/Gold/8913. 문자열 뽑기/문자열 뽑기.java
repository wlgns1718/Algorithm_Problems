import java.util.*;
import java.io.*;

public class Main {
    static boolean tri = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++){
            tri = false;
            int idx = 0;
            String word = br.readLine();
            sol(word);
            if(tri) {
                bw.write("1\n");
            }
            else{
                bw.write("0\n");
            }
        }
        bw.flush();
        bw.close();

    }
    public static void sol(String word){
        if(tri){
            return;
        }
        if(word.isEmpty()){
            tri = true;
        }
        int i = 0;
        while(i < word.length() - 1){

            if(word.charAt(i) != word.charAt(i+1)){
                i++;
                continue;
            };
            int start = i;
            while(i < word.length()-1 && word.charAt(i) == word.charAt(i+1)){
                i++;
            }
            int end = i;
            StringBuilder sb = new StringBuilder();
            sb.append(word,0,start);
            sb.append(word.substring(end+1));
            sol(sb.toString());
            i++;
        }


    }
}