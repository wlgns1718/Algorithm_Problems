import java.io.*;
import java.util.*;

public class Main {

    static long answer = 0;
    static long[] segment_tree;
    static PriorityQueue<Data> pq = new PriorityQueue<>((o1,o2) -> o1.val - o2.val);
    static class Data{
        int val;
        int idx;

        public Data(int val, int idx){
            this.val = val;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        segment_tree = new long[tree_size(N)];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            pq.add(new Data(Integer.parseInt(st.nextToken()), i));
        }
        List<Integer> ls = new ArrayList<>();
        int num = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            Data data = pq.poll();
            if(num != data.val){
                //이전 인덱스값 tree에 반영
                for(int idx : ls){
                    update(0, N - 1, 1, idx);
                }
                num = data.val;
                ls.clear();
            }
            //바꿀 횟수 더하기
            answer += cal(0, N - 1, 1, data.idx, N);
            ls.add(data.idx);

        }
        System.out.println(answer);
    }
    private static int tree_size(int n){
        //Math.log(n) 에서 log는 자연로그이므로 밑이 2인 로그를 사용하기 위해 나눔
        int h = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        return (int) Math.pow(2, h) - 1;
    }

    private static long cal(int start, int end, int node, int left, int right){
        // 해당 범위의 값 더해주기
        if(end < left || start > right){
            //찾는 밤위를 벗어난다면
            return 0L;
        }

        if(left <= start && end <= right){
            //찾는 범위라면 결과값 반환
            return segment_tree[node];
        }
        //하위 노드 탐색
        int mid = (start + end)/2;
        return cal(start, mid, node * 2, left, right) + cal(mid + 1, end, node * 2 + 1, left, right);
    }

    private static void update(int start, int end, int node, int idx){
        //리프 노드부터 부모 노드 업데이트 하기
        if(start == idx && end == idx){
            //리프노드인 경우
            segment_tree[node] = 1L;
            return;
        }
        //하위 노드 탐색
        int mid = (start + end) / 2;
        if(idx <= mid){
            //현재 노드 기준 왼쪽으로 가야할 때
            update(start, mid, node * 2, idx);
        }
        else{
            //현재 노드 기준 오른쪽으로 가야할 때
            update(mid + 1, end, node * 2 + 1, idx);
        }
        //현재 노드값 업데이트
        segment_tree[node] = segment_tree[node * 2] + segment_tree[node * 2 + 1];
    }
}