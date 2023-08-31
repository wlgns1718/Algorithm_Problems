import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    static int N,M,T,Node[],cnt = 0;
    static boolean[] tri;
    public static void main(String[] args)throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        while(true){
            cnt++;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            if(N == 0 && M == 0) break;
            T = 0;
            Node = new int[N+1];
            tri = new boolean[N+1];
            for(int i = 0; i < N + 1; i++){
                Node[i] = i;
            }
            for(int i = 0; i < M; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                setUnion(a,b);
            }
            for (int i = 0; i <= N; i++) {
                findSet(i);
            }

            for (int i = 0; i <= N; i++) {
                for (int j = 0; j <= N; j++) {
                    if (Node[i] == Node[j]) {
                        if (tri[i]) {
                            tri[j] = true;
                        }
                    }
                }
            }
            HashSet<Integer> set = new HashSet<>();
            for(int i = 1; i < N+1; i++){
                if (!tri[i]) {
                    set.add(Node[i]);
                }
            }
            T = set.size();
            if(T >= 2){
                System.out.println("Case " + cnt + ": A forest of "+ T + " trees.");
            }
            else if(T == 1){
                System.out.println("Case " + cnt + ": There is one tree.");
            }
            else{
                System.out.println("Case " + cnt + ": No trees.");
            }
        }

    }

    static void setUnion(int a, int b){
        int temp_A = findSet(a);
        int temp_B = findSet(b);

        if(temp_A == temp_B){
            tri[temp_A] = true;
        }

        if(temp_A < temp_B) Node[temp_B] = temp_A;
        else Node[temp_A] = temp_B;
    }
    static int findSet(int a){
        if(Node[a] == a) return a;

        return Node[a] = findSet(Node[a]);
    }

}