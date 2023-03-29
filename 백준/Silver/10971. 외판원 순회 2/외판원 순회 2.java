import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int[][] w;
    static int answer;
    static int start_city;
    static int tmp;
    static boolean[] visited;
    
    static void solve(int city,int n) {
        
        if(n==N-1) {
            if(w[city][start_city]!=0) {  // 현재 도시에서 출발 도시로 갈 수 있으면 최솟값 갱신
                tmp += w[city][start_city];
                answer = answer > tmp ? tmp : answer;
                tmp -= w[city][start_city];
            }
            return;
        }
        
        for(int i=0;i<N;i++) {
            if(w[city][i]!=0 && !visited[i]) { // city 에서 i로 갈 수 있고, 방문하지 않았으면
                tmp+=w[city][i];
                visited[i]=true;
                solve(i,n+1);
                tmp-=w[city][i];
                visited[i]=false;
            }
        }
        
        return;
        
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        
        N = Integer.parseInt(br.readLine());
        w = new int[N][N];
        answer = Integer.MAX_VALUE;
        
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for(int i=0;i<N;i++) {
            tmp = 0;
            visited = new boolean[N];
            start_city = i;
            visited[i]=true;
            solve(i,0);
        }
        
        System.out.println(answer);
        
        
    }
}    
