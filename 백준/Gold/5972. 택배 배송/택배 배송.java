import java.io.*;
import java.util.*;

public class Main {

    static int N, M, answer, brr[];
    static Map<Integer, List<Data>> map = new HashMap<>();

    static class Data{

        int x;
        int val;

        public Data(int x, int val){
            this.x = x;
            this.val = val;
        }
    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]) - 1;
            int b = Integer.parseInt(input[1]) - 1;
            int val = Integer.parseInt(input[2]);

            if(!map.containsKey(a)){
                map.put(a, new ArrayList<>());
            }
            map.get(a).add(new Data(b, val));
            if(!map.containsKey(b)){
                map.put(b, new ArrayList<>());
            }
            map.get(b).add(new Data(a, val));
        }

        brr = new int[N];
        Arrays.fill(brr, Integer.MAX_VALUE);
        brr[0] = 0;

        answer = Integer.MAX_VALUE;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            List<Data> ls = map.get(cur);

            for(Data d : ls){
                if(brr[d.x] > brr[cur] + d.val){
                    brr[d.x] = brr[cur] + d.val;
                    queue.offer(d.x);
                }
            }

        }
//        System.out.println(Arrays.toString(brr));
        System.out.println(brr[N-1]);
    }
}