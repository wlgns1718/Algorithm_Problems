import java.io.*;
import java.util.*;

public class Main {
    static class Data{
        int start;
        int end;

        public Data(int start, int end){
            this.start = start;
            this.end = end;
        }

        @Override
        public int hashCode(){
            return this.start * 1000 + end;
        }
        @Override
        public boolean equals(Object o){
            Data data = (Data) o;
            return data.start == this.start && data.end == end;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    static HashMap<Data, Integer> map = new HashMap<>();
    static final int INF = Integer.MAX_VALUE;
    static int N, dis[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        dis = new int[N+1];
        Arrays.fill(dis, INF);

        int M = Integer.parseInt(br.readLine());
        for(int i = 0; i < M; i++){
            String[] input = br.readLine().split(" ");
            Data data = new Data(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
            if(!map.containsKey(data)){
                map.put(data, Integer.parseInt(input[2]));
            }
            else{
                if(Integer.parseInt(input[2]) < map.get(data)){
                    map.replace(data, Integer.parseInt(input[2]));
                }
            }

        }

        String[] input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);
        dis[s] = 0;
        sol(s);
        System.out.println(dis[e]);
    }
    private static void sol(int start){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            for(int i = 1; i <= N; i++){
                if(cur == i) continue;
                Data data = new Data(cur,i);
                if(map.containsKey(data)){
                    if(dis[i] > dis[cur] + map.get(data)){
                        dis[i] = dis[cur] + map.get(data);
                        queue.offer(i);
                    }
                }
            }
        }
    }
}