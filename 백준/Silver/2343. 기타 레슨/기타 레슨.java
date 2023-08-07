import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    static int N, M;
    static int answer = 1000000000;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        int start = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if (start < arr[i]){
                start = arr[i];
            }
        }

        int mid;
        while(start <= answer){
            mid = (start+answer)/2;
            int count = 0;
            int temp = 0;
            for (int i = 0; i < N; i++){
                int j = arr[i];
                if(i == N - 1 && temp + j == mid){
                    temp = 0;
                    break;
                }
                if (temp+ j > mid){
                    count += 1;
                    temp = j;
                }
                else{
                    temp += j;
                }

            }
            if (temp != 0){
                count += 1;
            }
            //만약 count가 M보다 클 때 길이를 더 늘려야한다.
            if(count > M){
                start = mid + 1;

            }
            else{//count가 M보다 작거나 같을 때 길이를 줄여야 한다.
                answer = mid - 1;

            }

        }
        System.out.println(answer+1);

    }

}