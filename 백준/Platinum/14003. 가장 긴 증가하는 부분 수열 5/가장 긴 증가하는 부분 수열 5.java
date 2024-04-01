import java.util.*;
import java.io.*;

public class Main {
    static int N, arr[], lis[];
    static class Info{
        int val;
        int idx;
        public Info(int val, int idx){
            this.val = val;
            this.idx = idx;
        }

        @Override
        public String toString() {
            return "Info{" + "val=" + val + ", idx=" + idx + '}';
        }
    }
    static List<Info> ls = new ArrayList<>();
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        lis = new int[N+1];
        int idx = 0;
        lis[0] = Integer.MIN_VALUE;

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(input[i]);
        }

        for(int i = 0; i < N; i++){
            int a = arr[i];
            if(lis[idx] < a){
                idx++;
                lis[idx] = a;
                ls.add(new Info(a, idx));
            }
            else{

                int start = 0;
                int end = idx;

                int mid;
                while(start < end){

                    mid = (start + end) / 2;

                    if(lis[mid] >= a){
                        end = mid;
                    }
                    else{
                        start = mid + 1;
                    }
                }
                lis[end] = a;
                ls.add(new Info(a, end));
            }
        }
//        System.out.println(Arrays.toString(lis));
//        System.out.println(ls.toString());


        sb.append(idx).append("\n");
        int[] answer = new int[idx];
        int temp = idx;

        for(int i = ls.size() - 1; i >= 0; i--){
            Info cur = ls.get(i);
            if(cur.idx == temp){
                answer[temp - 1] = cur.val;
                temp--;
                if(temp == 0) break;
            }
        }
        for(int ans : answer){
            sb.append(ans).append(" ");
        }
        System.out.println(sb);
    }
}