import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int answer = 0;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());//풍선 개수
        int[] balloon = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            balloon[i] = Integer.parseInt(st.nextToken());
        }
        int[] height = new int[1000001];
        for (int i : balloon){
            if(height[i] > 0){
                height[i] -= 1;
                if(i-1 <=0){continue;}
                height[i-1] += 1;
            }
            else{
                height[i-1] += 1;
                answer += 1;
            }
        }
        System.out.println(answer);

    }

}