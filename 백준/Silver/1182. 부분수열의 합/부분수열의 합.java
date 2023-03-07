import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int N,S,answer,sum;
    static boolean[] selected;
    static  int[] nums;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        selected = new boolean[N];
        answer = 0;
        nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i= 0; i<N;i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }
        m1(0);
        if(S==0){
            answer -=1;
        }
        System.out.println(answer);

    }
    public static void m1(int idx){
        if(idx==N){
            sum = 0;
            for(int i=0; i<N; i++){
                if(!selected[i]) continue;
                sum += nums[i];
            }
            if(sum==S){
                answer += 1;
            }
            return;
        }

        selected[idx] = true;
        m1(idx+1);
        selected[idx] = false;
        m1(idx+1);
    }
}