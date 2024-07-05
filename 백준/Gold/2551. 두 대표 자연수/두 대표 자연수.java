import java.io.*;

public class Main {
    static int N, nums[] = new int[10001];
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        long sum = 0;
        for(int i = 0; i < N; i++){
            int a = Integer.parseInt(input[i]);
            nums[a] ++;
            sum += a;
        }

        int idx = N % 2 == 0 ?  N/2 : N/2 + 1;
        int cnt = 0;

        for(int i = 1; i <= 10000; i++){
            cnt += nums[i];
            if(cnt >= idx){
                sb.append(i).append(" ");
                break;
            }
        }
        if(sum % N == 0){
            sb.append(sum/N);
        }
        else{
            long case1 = sum/N;
            long case2 = sum/N + 1;
            long answer = 0;
            long total1 = 0;
            long total2 = 0;
            for(int i = 1; i <= 10000; i++){
                if(nums[i] == 0) continue;
                total1 += (long) Math.pow((i - case1), 2) * nums[i];
                total2 += (long) Math.pow((i - case2), 2) * nums[i];

            }
            answer = (total1 <= total2) ? case1 : case2;
            sb.append(answer);
        }
        System.out.println(sb);
    }
}