import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(b);
        int answer = -1;
        int cnt = 0;

        Loop:
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int cur = q.poll();
                if(cur == a){
                    answer = cnt;
                    break Loop;
                }
                String temp = String.valueOf(cur);
                if(cur % 2 == 0 && cur/2 >= 1)q.offer(cur/2);
                if(cur >= 2 && cur != 1 && temp.charAt(temp.length() - 1) == '1') q.offer(Integer.parseInt(temp.substring(0,temp.length()-1)));
            }
            cnt++;
        }
        if(answer != -1) System.out.println(answer + 1);
        else System.out.println(-1);
    }
}