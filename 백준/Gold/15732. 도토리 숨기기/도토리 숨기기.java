import java.util.*;
import java.io.*;

public class Main {
    static int N, K, D, arr[];
    static class Info{
        int start;
        int end;
        int range;
        public Info(int start, int end, int range){
            this.start = start;
            this.end = end;
            this.range = range;
        }
    }
    static Info[] infos;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        String[] input;
        infos = new Info[K];

        for(int i = 0; i < K; i++){
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int range = Integer.parseInt(input[2]);
            infos[i] = new Info(start, end, range);
        }
        int start = 0;
        int end = N;
        while(start <= end){

            int mid = (start + end) / 2;
            long res = cal(mid);

            if(res >= D){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        System.out.println(start);
    }
    static long cal(int cur){

        long res = 0;
        for(Info info : infos){
            if(cur < info.start) continue;
            int end = Math.min(info.end, cur);
            res += (end - info.start) / info.range + 1;
        }
        return res;
    }
}