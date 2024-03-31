import java.util.*;
import java.io.*;

public class Main {
    static int N, M, K;
    static long[] tree;
    static final int MOD = 1_000_000_007;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        tree = new long[size(N)];
        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            update(i, 0, N-1, 1, num);
        }
        String[] input;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M+K; i++){
            input = br.readLine().split(" ");
            int order = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            if(order == 1){
                update(b - 1, 0, N-1, 1, c);
            }
            else{
                sb.append(find(b - 1, c - 1, 0, N-1, 1)).append("\n");
            }
        }
        System.out.println(sb);

    }
    private static int size(int n){
        int H = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        return (int) Math.pow(2, H);
    }
    private static long find(int s, int e, int start, int end, int node){

        if(start > e || end < s) return 1L;
        if(start >= s && end <= e){
            return tree[node];
        }
        int mid = (start + end) / 2;
        return find(s, e, start, mid, node * 2) * find(s, e, mid + 1, end, node * 2 + 1) % MOD;
    }
    private static void update(int idx, int start, int end, int node, int val){

        if(idx == start && idx == end){
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;

        if(idx <= mid){
            update(idx, start, mid, node * 2, val);
        }
        else{
            update(idx, mid + 1, end, node * 2 + 1, val);
        }
        tree[node] = tree[node * 2] * tree[node * 2 + 1] % MOD;
    }
}