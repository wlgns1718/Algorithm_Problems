import java.io.*;
import java.util.*;

public class Main {
    static int answer = Integer.MAX_VALUE;
    static class Info{
        int stage;
        int cnt;

        public Info(int stage, int  cnt){
            this.stage = stage;
            this.cnt = cnt;
        }
    }
    static int[] dx = {1,2,3,4,5,6};
    static int[] map = new int[101];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int ladder = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> l = new HashMap<>();
        HashMap<Integer, Integer> s = new HashMap<>();
        String[] input;
        for(int i = 0; i < ladder; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            l.put(a,b);
        }
        for(int i = 0; i < snake; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            s.put(a, b);
        }

        Queue<Info> queue = new ArrayDeque<>();
        Arrays.fill(map, Integer.MAX_VALUE);
        for(int idx = 0; idx < 6; idx++){
            if(!s.containsKey(idx+2) && !l.containsKey(idx+2)){
                map[idx + 2] = 1;
                queue.offer(new Info(idx + 2, 1));
            }
            else{
                if(s.containsKey(idx + 2)){
                    int temp = s.get(idx + 2);
                    if(map[temp] != 1){
                        map[temp] = 1;
                        queue.offer(new Info(idx + 2, 1));
                    }
                }
                else{
                    int temp = l.get(idx + 2);
                    if(map[temp] != 1){
                        map[temp] = 1;
                        queue.offer(new Info(temp, 1));
                    }
                }
            }
        }
        while(!queue.isEmpty()){
            Info cur = queue.poll();
            if(cur.stage == 100) {
                map[100] = Math.max(map[100], cur.cnt);
                continue;
            }
            for(int idx = 0; idx < 6; idx++){
                int nx = dx[idx] + cur.stage;
                if(nx > 100) continue;
                if(s.containsKey(nx)){
                    int temp = s.get(nx);
                    if(map[temp] > cur.cnt + 1){
                        map[temp] = cur.cnt + 1;
                        queue.offer(new Info(temp, cur.cnt + 1));
                    }
                }
                else if(l.containsKey(nx)){
                    int temp = l.get(nx);
                    if(map[temp] > cur.cnt + 1){
                        map[temp] = cur.cnt + 1;
                        queue.offer(new Info(temp, cur.cnt + 1));
                    }
                }
                else{
                    if(cur.cnt + 1 < map[nx]){
                        map[nx] = cur.cnt + 1;
                        queue.offer(new Info(nx, cur.cnt + 1));
                    }
                }
            }

        }
        System.out.println(map[100]);
    }
}