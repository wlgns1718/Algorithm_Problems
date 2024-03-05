import java.io.*;
import java.util.*;

public class Main {
    static long[] tree, lazy;
    static int N, s;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        s = size(N);
        tree = new long[s];
        lazy = new long[s];

        int TC = Integer.parseInt(input[1]) + Integer.parseInt(input[2]);
        for(int i = 0; i < N; i++){
            long val = Long.parseLong(br.readLine());
            init(0,N-1, 1, val, i);
        }
        for(int i = 0; i < TC; i++){
            input = br.readLine().split(" ");
            if(input[0].equals("1")){
                //업데이트
                int l = Integer.parseInt(input[1]) - 1;
                int r = Integer.parseInt(input[2]) - 1;
                long val = Long.parseLong(input[3]);
                update(0,N-1, l, r, 1, val);
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
    private static void init(int start, int end, int node, long val, int idx){
        if(start == idx && end == idx){
            tree[node] = val;
            return;
        }
        int mid = (start + end) / 2;

        if(idx <= mid){
            init(start, mid, node * 2, val, idx);
        }
        else{
            init(mid + 1, end, node * 2 + 1, val, idx);
        }
        tree[node] = tree[node * 2] + tree[node * 2 + 1];

    }

    private static void update(int start, int end,int left, int right ,int node, long val){
        propagate(start, end, node);

        //완전히 벗어나는 경우
        if(right < start || left > end){
            return;
        }
        //범위가 완전히 포함되는 경우
        if(start >= left && right >= end){
            lazy[node] = val;
            //자식 노드에게 lazy값 전달하기
            propagate(start, end, node);
            return;
        }
        //현재 범위가 목표로 하는 범위에 포함된다면
        int mid = (start + end) / 2;
        update(start, mid, left, right, node * 2, val);
        update(mid + 1, end, left, right, node * 2 + 1, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    private static void propagate(int start, int end, int node){
        //현재 노드에 lazy가 있는지 판단
        if(lazy[node] != 0){
            if(start != end){
                //리프노드가 아닐 경우 자식 노드에게 lazy값 물려주기
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            //현재 lazy값 적용하기
            tree[node] += (end - start + 1) * lazy[node];
            lazy[node] = 0;
        }
    }

    private static long cal(int start, int end, int left, int right, int node){
        propagate(start, end, node);

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