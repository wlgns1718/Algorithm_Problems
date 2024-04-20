import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] tree = new int[N];
        int end = 0;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            tree[i] = Integer.parseInt(st.nextToken());
            if(tree[i] > end) end = tree[i];
        }
        int start = 0;

        int answer = 0;
        while(start < end){
            int mid = (start + end) / 2;
            long temp = 0;
            for(int i = 0; i < N; i++){
                if(tree[i] - mid > 0) temp += (tree[i] - mid);
            }

            if(temp < M){
                //모자란 경우 높이를 더 낮추기
                end = mid;
            }
            else{
                answer = mid;
                start = mid + 1;
            }
        }
        System.out.println(answer);
    }
}