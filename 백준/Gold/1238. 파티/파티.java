import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X, arr[][];
    static class Info{
        int e;
        int cost;
        public Info(int e, int cost){
            this.e = e;
            this.cost = cost;
        }
    }
    static class Node{
        int node;
        int cost;
        public Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    static Map<Integer, ArrayList<Info>> map = new HashMap<>();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        X = Integer.parseInt(input[2]) - 1;

        arr = new int[N][N];
        for(int i = 0; i < N; i++){
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }

        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]) - 1;
            int e = Integer.parseInt(input[1]) - 1;
            int cost = Integer.parseInt(input[2]);
            if(!map.containsKey(s)) map.put(s,new ArrayList<>());
            arr[s][e] = cost;
            map.get(s).add(new Info(e, cost));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);

        for(int i = 0; i < N; i++){
            pq.offer(new Node(i, 0));

            while(!pq.isEmpty()){
                Node cur = pq.poll();

                if(arr[i][cur.node] < cur.cost) continue;

                arr[i][cur.node] = cur.cost;

                if(map.containsKey(cur.node)){

                    for(Info info : map.get(cur.node)){
                        pq.offer(new Node(info.e, arr[i][cur.node] + info.cost));
                    }
                }
            }
        }
        int answer = 0;

        for(int i = 0; i < N; i++){
            int temp = arr[i][X] + arr[X][i];
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);
    }

}