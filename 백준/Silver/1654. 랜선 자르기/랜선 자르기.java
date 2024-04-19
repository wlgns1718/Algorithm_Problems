import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static long temp,start, end,mid;
    static ArrayList<Integer> cable = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        for (int i = 0; i<K; i++){
            cable.add(Integer.parseInt(br.readLine()));
        }
        int cnt;
        start = 1;
        end = Integer.MAX_VALUE;
        temp = 0;
        while(true){
            cnt = 0;
            mid = (long)(start + end)/2;
            if(temp == mid) break;
            temp = mid;
            for(int c : cable){
                cnt += (c/mid);
            }
            if (cnt < N) end = mid-1;

            else if(cnt >= N){ start = mid+1;}
        }
        System.out.println(mid);

    }

}
