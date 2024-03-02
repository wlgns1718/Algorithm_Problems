import java.io.*;
import java.util.*;

public class Main {
    static long[] tree;
    static int N;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        tree = new long[size(N)];
        int TC = Integer.parseInt(input[1]) + Integer.parseInt(input[2]);
        for(int i = 0; i < N; i++){
            long val = Long.parseLong(br.readLine());
            update(0,N-1,1, i, val);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < TC; i++){
            input = br.readLine().split(" ");

            if(input[0].equals("1")){
                //업데이트
                int idx = Integer.parseInt(input[1]) - 1;
                long val = Long.parseLong(input[2]);
                update(0,N-1, 1, idx, val);
            }
            else{
                int s = Integer.parseInt(input[1]) - 1;
                int e = Integer.parseInt(input[2]) - 1;
                sb.append(cal(0, N-1, s, e, 1)).append("\n");
            }
        }
        System.out.println(sb);
    }
    private static int size(int n){
        int h = (int) Math.ceil((Math.log(n)/Math.log(2))) + 1;
        return (int)Math.pow(2,h);
    }
    private static void update(int start, int end, int node, int idx, long val){

        if(start == idx && end == idx){
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;
        if(idx <= mid){
            //목표 idx가 왼쪽으로 가야할 때
            update(start, mid, node * 2, idx, val);
        }
        else{
            update(mid + 1, end, node * 2 + 1, idx, val);
        }
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private static long cal(int start, int end, int left, int right, int node){

        if(left > end || right < start){
            return 0L;
        }

        if(left <= start && right >= end ){
            return tree[node];
        }

        //자식 노드 탐색
        int mid = (start + end) / 2;
        return cal(start, mid, left, right, node * 2) + cal(mid + 1, end, left, right, node * 2 + 1);
    }

}