import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    static int N,answer;
    static int[] arr;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int crain_weight = 0;
        int box_weight = 0;
        N = Integer.parseInt(br.readLine()); //N 크레인 개수
        arr = new int[N]; //각 크레인의 무게 제한
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > crain_weight){
                crain_weight = arr[i];
            }
        }

        int M = Integer.parseInt(br.readLine()); //옮길 박스 개수
        int[] brr = new int[M];//각 박스의 무게 정보

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            brr[i] = Integer.parseInt(st.nextToken());
            if(box_weight < brr[i]){
                box_weight = brr[i];
            }
        }
        //1분에 하나씩 움직인다.
        //만약 박스 최대 무게가 크레인 최대 무게보다 높다면 -1 출력
        if(box_weight > crain_weight){
            answer = -1;
        }
        else{
            answer = 10000;
            int end = answer;
            Arrays.sort(arr);
            Arrays.sort(brr);
//            System.out.println(Arrays.toString(arr));
//            System.out.println(Arrays.toString(brr));
            int start = 0;
            while (start <= end){
                int mid = (start+end)/2; //걸리는 시간
//                System.out.println(mid);
                int count = 0; //옮긴 박스 개수
                for(int i : arr){
                    if(count >= M){break;}
                    for(int j = 0; j < mid; j++){
                        if(count >= M){
                            break;
                        }
                        if(brr[count] > i){
                            break;
                        }
                        count += 1;
                    }
                }
                //만약 count가 박스 개수 M보다 작다면 더 많은 시간 필요
                if(count < M){
//                    System.out.println(count);
                    start = mid + 1;
                }
                else{//count가 박스 개수보다 크거나 같다면 더 적은 시간 가능
                    end = mid - 1;
                    answer = mid;
                }

            }

        }
        System.out.println(answer);
    }

}