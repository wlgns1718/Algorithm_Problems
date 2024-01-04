import java.io.*;
import java.util.*;

public class Main {
    static int C;
    static int[] dp;
    static class Data{
        int cost;
        int customer;

        public Data(int cost, int customer){
            this.cost = cost;
            this.customer = customer;
        }

        @Override
        public String toString() {
            return "Data{" +
                    "cost=" + cost +
                    ", customer=" + customer +
                    '}';
        }
    }
    static List<Data> ls = new ArrayList<>();

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int max = 0;
        dp = new int[C+1];
        Arrays.fill(dp, 987654321);

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int customer = Integer.parseInt(st.nextToken());
            max = Math.max(max, customer);
            ls.add(new Data(cost, customer));
        }
//        System.out.println(ls.toString());
        dp[0] = 0;
        for(int i = 0; i <= C + max; i++){
            for(Data d : ls){
                if(i - d.customer < 0){
                    continue;
                }
                if(i > C){
                    if(i-d.customer > C) continue;
                    dp[C] = Math.min(dp[C], dp[i-d.customer] + d.cost);
                }
                else{
                    dp[i] = Math.min(dp[i], dp[i-d.customer] + d.cost);
                }



            }
        }
//        System.out.println(Arrays.toString(dp));
        System.out.println(dp[C]);
    }
}