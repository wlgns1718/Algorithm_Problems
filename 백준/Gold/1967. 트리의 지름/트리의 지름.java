import java.io.*;
import java.util.*;

public class Main {
    static int N, maxNode;
    static class Node{
        int link;
        int weight;
        public Node(int link, int weight){
            this.link = link;
            this.weight = weight;
        }
    }
    static List<List<Node>> nodes = new ArrayList<>();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        init(br);
        bfs(1);
        System.out.println(bfs(maxNode));
    }
    private static void init(BufferedReader br) throws Exception{
        N = Integer.parseInt(br.readLine()); //노드 개수
        for(int i = 0; i <= N; i++){
            nodes.add(new LinkedList<>());
        }
        String[] input;
        for(int i = 0; i < N-1; i++){
            input = br.readLine().split(" ");
            //부모, 자식, 가중치
            int p = Integer.parseInt(input[0]); //부모노드
            int c = Integer.parseInt(input[1]); //자식노드
            int w = Integer.parseInt(input[2]); //가중치
            nodes.get(p).add(new Node(c, w));
            nodes.get(c).add(new Node(p, w));
        }
    }

    private static int bfs(int root){
        int max = 0;
        //루트노드에서 가장 거리가 먼 노드 탐색
        boolean[] visit = new boolean[N+1];
        visit[root] = true;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(root, 0));
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(max < cur.weight){
                max = cur.weight;
                maxNode = cur.link;
            }
            for(Node node : nodes.get(cur.link)){

                if(visit[node.link]) continue;
                visit[node.link] = true;
                q.offer(new Node(node.link, cur.weight + node.weight));
            }
        }
        return max;
    }
}