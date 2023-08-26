import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.*;


public class Main {
    static int[] boseok;
    static int answer;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boseok = new int[M];
        for(int i = 0; i < M; i++){
            boseok[i] = Integer.parseInt(br.readLine());
        }
        int start = 1;
        int end = 1000000001;
        while(start <= end){
            int mid = (start+end)/2;
            int count = 0;
            for(int i = 0; i < M; i++){
                count += (boseok[i] / mid) + (boseok[i] % mid == 0 ? 0 : 1);
            }
            //만약 count가 N에 모자라다면 더 쪼갤 수 있다 => 더 작게
            if(count <= N){
                end = mid - 1;
                answer = mid;
            }
            else{
                start = mid + 1;
                answer = start;
            }
        }
        System.out.println(answer);
    }
}