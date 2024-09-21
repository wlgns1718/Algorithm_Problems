import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] visit = new boolean[33554433];
        StringBuilder sb = new StringBuilder();
        int temp = 0;
        while(st.hasMoreTokens()){
            temp = Integer.parseInt(st.nextToken());
            if(visit[temp]) continue;
            visit[temp] = true;
            sb.append(temp).append(" ");
        }
        System.out.println(sb);

    }

}