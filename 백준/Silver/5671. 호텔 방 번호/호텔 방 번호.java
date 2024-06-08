import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try{
            while(true){
                StringTokenizer input = new StringTokenizer(br.readLine());
                int answer = 0;
                int a = Integer.parseInt(input.nextToken());
                int b = Integer.parseInt(input.nextToken());

                boolean[] visit = new boolean[10];
                for(int i = a; i <= b; i++){
                    String num = String.valueOf(i);
                    Arrays.fill(visit, false);
                    boolean tri = true;
                    for(int j = 0; j < num.length(); j++){
                        if(visit[num.charAt(j) - '0']){
                            tri = false;
                            break;
                        }
                        visit[num.charAt(j) - '0'] = true;
                    }
                    if(tri) answer++;
                }
                sb.append(answer).append("\n");
            }
        }catch (Exception e){
            System.out.println(sb);
        }

    }
}