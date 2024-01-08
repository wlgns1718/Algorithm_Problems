import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static int N,idx,cnt;
    static String[] nums = new String[1000001];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        nums[0] = "";
        cnt = 1;
        idx = 0;
        while(cnt <= 1000000){
            for(int i = 0; i<10; i++){
                if(idx == 0 && i == 0) continue;
                if(nums[idx].contains(String.valueOf(i))) continue;
                nums[cnt++] = nums[idx] + i;
                if(cnt >= 1000001) break;
            }
            idx++;
        }
        while(true){
            N = Integer.parseInt(br.readLine());
            if(N == 0)break;
            bw.write(Integer.parseInt(nums[N])+"\n");

        }
        bw.close();
    }

}