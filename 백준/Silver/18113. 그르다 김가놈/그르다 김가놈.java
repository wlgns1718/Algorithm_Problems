import java.util.*;
import java.io.*;

public class Main {
    static int N, K, M, answer = -1;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]); //김밥 개수
        K = Integer.parseInt(input[1]); //꼬다리 길이
        M = Integer.parseInt(input[2]); // 김밥조각 개수

        //양쪽 균일하게 Kcm씩 잘라낸다
        //이 때 2Kcm 보다 짧아서 한쪽밖에 자르지 못한다면 한쪽만 자른다.
        //김밥 길이가 kcm이거나 짧으면 폐기한다.
        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(br.readLine());
            if(temp <= K) continue; // 폐기
            if(temp < 2 * K)list.add(temp - K);
            else list.add(temp - (2 * K));
        }
        int start = 1;
        int end = 1_000_000_000;
        int mid;
        int temp;
        while(start <= end){
            temp = 0;
            mid = (start + end) / 2;

            for(int l : list){
                temp += l / mid;
            }
            if(temp >= M){
                answer = Math.max(answer, mid);
                //더 크게 잘라도 된다.
                start = mid + 1;
            }
            else{
                //M개 보다 더 적을 경우
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }
}