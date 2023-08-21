import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.*;

public class Main {



    public static void main(String[] args) throws Exception {
        //좌우로 인접한 같은수 전부 + 1
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        //prefix
        long answer = 0;
        long max_num= 0;
        long[] numbers = new long[1];
        for(int i = 0; i < n; i++){
            long a = Long.parseLong(br.readLine());
            max_num = Math.max(max_num,a);
            if(i==0){
                numbers[0] = a;
                continue;
            }
            if(numbers[0] > a){
                numbers[0] = a;
            }else{
                answer += (a-numbers[0]);
                numbers[0] = a;
            }
            //왼쪽이 양수고 오른쪽이 음수일 때 abs값이 낮은 걸 0으로
        }
        answer += (max_num - numbers[0]);
        System.out.println(answer);
    }

}