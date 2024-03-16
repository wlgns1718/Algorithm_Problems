import java.util.*;
import java.io.*;

/* Online Java Compiler and Editor */
public class Main {

    static int N, M, K, candy[], rel[], answer[];
    static boolean[] visit;
    static HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public static void main(String []args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        K = Integer.parseInt(input[2]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        candy = new int[N];
        rel = new int[N];
        visit = new boolean[N];
        answer = new int[K];
        for(int i = 0; i < N; i++){
            candy[i] = Integer.parseInt(st.nextToken());
            rel[i] = i;
        }
        for(int i = 0; i < M; i++){
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]) - 1;
            int b = Integer.parseInt(input[1]) - 1;
            set_union(a,b);
        }
        for(int i = 0; i < N; i++){
            int parent = find(i);
            if(!map.containsKey(find(i))){
                map.put(parent, new ArrayList<>());
            }
            map.get(parent).add(i);
        }
        for(int i = 0; i < N; i++){
            if(visit[i]) continue;
            visit[i] = true;

            int parent = find(i);
            int s = map.get(parent).size();
            int total = 0;
            for(int t : map.get(parent)){
                visit[t] = true;
                total += candy[t];
            }
            for(int j = K-1; j >= 0; j--){
                if(j - s < 0) break;
                answer[j] = Math.max(answer[j], answer[j-s] + total);
            }
        }
        System.out.println(answer[K-1]);
    }
    private static void set_union(int a, int b){
        a = find(a);
        b = find(b);

        if(a == b) return;

        if(a > b) rel[a] = b;
        else rel[b] = a;


    }
    private static int find(int x){

        if(rel[x] == x) return x;
        return find(rel[x]);
    }
}