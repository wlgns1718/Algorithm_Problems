import java.util.*;
import java.io.*;


public class Main {
    static int V, M,arr[][],brr[][],disA[], disB[], answer = -1;
    static final int MAX_VALUE = Integer.MAX_VALUE;
    static int min = Integer.MAX_VALUE;
    public static class Node{
        int node;
        int dis;

        public Node(int node, int dis){
            this.dis = dis;
            this.node = node;
        }

    }
    public static void main(String[] args) throws Exception {



        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[V+1][V+1];
        brr = new int[V+1][V+1];
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(arr[a][b] != 0 && arr[a][b] < c) continue;
            arr[a][b] = c;
            arr[b][a] = c;
            brr[a][b] = c;
            brr[b][a] = c;
        }

        disA = new int[V+1];
        disB = new int[V+1];
        Arrays.fill(disA, MAX_VALUE);
        Arrays.fill(disB,MAX_VALUE);

        st = new StringTokenizer(br.readLine());
        int startA = Integer.parseInt(st.nextToken());
        int startB = Integer.parseInt(st.nextToken());
        solA(startA);
        solB(startB);

//        System.out.println(Arrays.toString(disA));
//        System.out.println(Arrays.toString(disB));
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> {
            if(o1.dis == o2.dis){
                if(disA[o1.node] == disA[o2.node]){
                    return o1.node - o2.node;
                }
                return disA[o1.node] - disA[o2.node];
            }
            else{
                return o1.dis - o2.dis;
            }
        }));

        for(int i = 1; i <= V; i++){
            if(i == startA || i == startB) continue;
            if(min > disA[i] + disB[i]){
                min = disA[i] + disB[i];
            }

            if(disA[i] > disB[i]) continue;
            pq.offer(new Node(i, disA[i] + disB[i]));
        }
        if(pq.isEmpty()){
            System.out.println(-1);
        }else{
            while(!pq.isEmpty()){
                Node node = pq.poll();
                if(node.dis > min) continue;
                System.out.println(node.node);
                return;
            }
            System.out.println(-1);

        }
    }
    private static void solA(int start){

        disA[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> {
            if(o1.dis == o2.dis){
                return o1.node - o2.node;
            }
            else{
                return o1.dis - o2.dis;
            }
        }));

        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            //여기서 갈 수 있는 node 탐색
            for(int i = 1; i <= V; i++){
                //만약 해당 노드에서 갈 수 없거나 이미 초기화가 된 노드면 continue처리
                if(arr[node.node][i] == 0 || disA[i] < (arr[node.node][i] + disA[node.node])) continue;
                disA[i] = arr[node.node][i] + disA[node.node];
                pq.offer(new Node(i, disA[i]));
            }
        }

    }
    private static void solB(int start){

        disB[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> {
            if(o1.dis == o2.dis){
                return o1.node - o2.node;
            }
            else{
                return o1.dis - o2.dis;
            }
        }));

        pq.offer(new Node(start,0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            //여기서 갈 수 있는 node 탐색
            for(int i = 1; i <= V; i++){
                //만약 해당 노드에서 갈 수 없거나 이미 초기화가 된 노드면 continue처리
                if(brr[node.node][i] == 0 || disB[i] < (brr[node.node][i] + disB[node.node])) continue;
                disB[i] = brr[node.node][i] + disB[node.node];
                pq.offer(new Node(i, disB[i]));
            }
        }

    }
}