import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] answer = new int[3];
    static int start, end, mid;
    static long temp;
    public static void main(String[] args) throws Exception{
        temp = 9876543210L;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        int N;
        N = Integer.parseInt(br.readLine());
//        System.out.println(N);
        st = new StringTokenizer(br.readLine());
        List<Integer> liquid = new ArrayList<>();
        while(st.hasMoreTokens()){
            liquid.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(liquid);
//        System.out.println(liquid);

        for(int i = 0 ; i < N; i++){
            for(int j = i + 1; j < N; j++){
                start = j+1;
                end = N-1;
                if (start >= N){
                    break;
                }
                long val = liquid.get(i) + liquid.get(j);
                
                while(start <= end){
                    long temp_val;
                    mid = (start+end) / 2;
                    temp_val = val + liquid.get(mid);
                    if (Math.abs(temp_val) < temp){
                        temp = Math.abs(temp_val);
                        answer[0] = liquid.get(i);
                        answer[1] = liquid.get(j);
                        answer[2] = liquid.get(mid);
                    }
                    if (temp_val <= 0){
                        start = mid + 1;
                    }
                    else{
                        end = mid - 1;
                    }

                }
            }
        }
//        System.out.println(Arrays.toString(answer));
        for(int i : answer){
            System.out.print(i+" ");
        }
    }

}