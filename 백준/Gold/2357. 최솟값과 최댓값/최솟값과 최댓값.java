import java.util.*;
import java.io.*;

public class Main {
    static int N, M, max_tree[], min_tree[];

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        max_tree = new int[size(N)];
        min_tree = new int[size(N)];
        Arrays.fill(min_tree, Integer.MAX_VALUE);

        for(int i = 0; i < N; i++){
            int num = Integer.parseInt(br.readLine());
            max_update(0, N-1, 1, i, num);
            min_update(0, N-1, 1, i, num);
        }
        String[] input;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]) - 1;
            int e = Integer.parseInt(input[1]) - 1;
            sb.append(find_min(0, N-1, 1, s, e))
                    .append(" ").append(find_max(0, N-1, 1, s, e)).append("\n");
        }
        System.out.println(sb);
    }
    private static int size(int n){
        int H = (int) Math.ceil((Math.log(n)/Math.log(2))) + 1;
        return (int) Math.pow(2,H);
    }
    private static void max_update(int left, int right, int node, int idx, int val){
        if(left == idx && right == idx){
            max_tree[node] = val;
            return;
        }
        int mid = (left + right) / 2;
        if(idx <= mid){
            max_update(left, mid, node * 2, idx, val);
        }
        else{
            max_update(mid + 1, right, node * 2 + 1, idx, val);
        }
        max_tree[node] = Math.max(max_tree[node * 2], max_tree[node * 2 + 1]);
    }
    private static int find_max(int left, int right, int node, int start, int end){
        if(right < start || left > end) return 0;


        if(left >= start && right <= end){
            return max_tree[node];
        }
        int mid = (left + right)/2;
        return Math.max(find_max(left, mid, node * 2, start, end),
                find_max(mid + 1, right, node * 2 + 1, start ,end));
    }
    private static void min_update(int left, int right, int node, int idx, int val){
        if(left == idx && right == idx){
            min_tree[node] = val;
            return;
        }
        int mid = (left + right) / 2;
        if(idx <= mid){
            min_update(left, mid, node * 2, idx, val);
        }
        else{
            min_update(mid + 1, right, node * 2 + 1, idx, val);
        }
        min_tree[node] = Math.min(min_tree[node * 2], min_tree[node * 2 + 1]);
    }
    private static int find_min(int left, int right, int node, int start, int end){
        if(right < start || left > end) return Integer.MAX_VALUE;
        if(left >= start && right <= end){
            return min_tree[node];
        }
        int mid = (left + right)/2;
        return Math.min(find_min(left, mid, node * 2, start, end),
                find_min(mid + 1, right, node * 2 + 1, start ,end));
    }
}