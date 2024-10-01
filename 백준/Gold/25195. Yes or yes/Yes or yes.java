import java.io.*;
import java.util.*;

class Main {
    static int N, M, S;
    static boolean[] arr;
    static Map<Integer, List<Integer>> info = new HashMap<>();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); //노드 개수
        M = Integer.parseInt(input[1]); //간선 개수

        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            if(!info.containsKey(s)) info.put(s, new ArrayList<>());
            info.get(s).add(e);
        }

        S = Integer.parseInt(br.readLine());
        arr = new boolean[N + 1];
        input = br.readLine().split(" ");
        for(int i = 0; i < S; i++){
            int n = Integer.parseInt(input[i]);
            arr[n] = true; //팬클럽 곰곰이 숨어 있는 곳
        }

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(arr[cur]) continue;

            //팬클럽 곰곰이가 없을 때
            if(!info.containsKey(cur)){
                //더이상 갈 곳이 없다면 종료
                System.out.println("yes");
                return;
            }
            //더 갈 곳이 있다면
            for(int temp : info.get(cur)){
                queue.offer(temp);
            }
        }
        System.out.println("Yes");

    }

}