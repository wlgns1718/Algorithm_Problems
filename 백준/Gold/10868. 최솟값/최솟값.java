import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int[] tree;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        tree = new int[size(N)];
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(br.readLine());
            update(0, N-1, 1, a, i);
        }
        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]) - 1;
            int b = Integer.parseInt(input[1]) - 1;
            sb.append(cal(0, N-1, a,b,1)).append("\n");
        }
        System.out.println(sb);
    }

    private static void update(int start, int end, int node, int val, int idx){

        if(start == idx && end == idx){
            tree[node] = val;
            return;
        }
        int mid = (start + end)/2;
        if(idx <= mid){
            //idx가 현재 기준 왼쪽 노드로 가야할 때
            update(start, mid, node * 2, val, idx);
        }
        else{
            //idx가 현재 기준 오른쪽 노드로 가야할 때
            update(mid + 1, end, node * 2 + 1, val, idx);
        }
        tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
    }
    private static int cal(int start, int end, int left, int right, int node){
        //left와 right는 확인해야 할 범위
        if(left > end || right < start){
            //범위를 벗어날 경우
            return Integer.MAX_VALUE;
        }
        if(start >= left && end <= right) {
            //범위에 속한다면
            return tree[node];
        }
        //하위 노드 탐색
        int mid = (start + end) / 2;
        return Math.min(cal(start, mid, left, right, node * 2), cal(mid+1, end, left, right, node * 2 + 1));

    }
    private static int size(int n){
        int h = (int)Math.ceil(Math.log(n)/Math.log(2)) + 1;
        return (int) Math.pow(2,h);
    }
}