import java.io.*;
import java.util.*;

public class Main {
    static int N, M, X, go[], back[];
    static class Node{
        int node;
        int cost;
        public Node(int node, int cost){
            this.node = node;
            this.cost = cost;
        }
    }
    static List<List<Node>> GO = new ArrayList<>();
    static List<List<Node>> BACK = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        X = Integer.parseInt(input[2]) - 1;

        go = new int[N];
        back = new int[N];

        for(int i = 0; i < N; i++){
            GO.add(new ArrayList<>());
            BACK.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]) - 1;
            int e = Integer.parseInt(input[1]) - 1;
            int cost = Integer.parseInt(input[2]);
            GO.get(s).add(new Node(e, cost));
            BACK.get(e).add(new Node(s, cost));
        }

        Arrays.fill(go, Integer.MAX_VALUE);
        Arrays.fill(back, Integer.MAX_VALUE);

        cal(X, GO, go);
        cal(X, BACK, back);

        int answer = 0;

        for(int i = 0; i < N; i++){
            int temp = go[i] + back[i];
            answer = Math.max(answer, temp);
        }
        System.out.println(answer);
    }
    private static void cal(int start, List<List<Node>> ls, int[] dis){
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dis[cur.node] <= cur.cost) continue;
            dis[cur.node] = cur.cost;
            for(Node node : ls.get(cur.node)){
                pq.offer(new Node(node.node, node.cost + dis[cur.node]));
            }
        }
    }
}