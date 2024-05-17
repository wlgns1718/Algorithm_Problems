import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static class Info{
        int dir;
        int dis;
        public Info(int dir, int dis){
            this.dir = dir;
            this.dis = dis;
        }
    }
    static List<Info> ls = new ArrayList<>();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int cnt = Integer.parseInt(br.readLine());
        String[] input;
        for(int i = 0; i < cnt; i++){
            input = br.readLine().split(" ");
            ls.add(new Info(Integer.parseInt(input[0]), Integer.parseInt(input[1])));
        }
        input = br.readLine().split(" ");
        int dir = Integer.parseInt(input[0]);
        int dis = Integer.parseInt(input[1]);
        int answer = 0;
        for(Info info : ls){
            if(info.dir == dir) answer += Math.abs(dis - info.dis);
            else{
                if(dir == 1){
                    if(info.dir == 2){
                        answer += Math.min(dis + M + info.dis, N - dis + M + N - info.dis);
                    }else if (info.dir == 3){
                        answer += (dis + info.dis);
                    }
                    else{
                        answer += (N - dis + info.dis);
                    }
                }
                else if (dir == 2){
                    if(info.dir == 1){
                        answer += Math.min(dis + M + info.dis, N - dis + M + N - info.dis);
                    }else if (info.dir == 3){
                        answer += (dis + M - info.dis);
                    }
                    else{
                        answer += (N - dis + M - info.dis);
                    }
                }
                else if (dir == 3){
                    if(info.dir == 1){
                        answer += (info.dis + dis);
                    }else if (info.dir == 2){
                        answer += (M - dis + info.dis);
                    }
                    else{
                        answer += Math.min(dis + N + info.dis, M - dis + N + M - info.dis);
                    }
                }
                else{
                    if(info.dir == 1){
                        answer += (N - info.dis + dis);
                    }else if (info.dir == 2){
                        answer += (M - dis + N - info.dis);
                    }
                    else{
                        answer += Math.min(dis + N + info.dis, M - dis + N + M - info.dis);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}