import java.io.*;
import java.util.*;

public class Main {
    static int target;
    static List<String> arr = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static class Coin{
        int cost;
        int cnt;
        public Coin(int cost, int cnt){
            this.cost = cost;
            this.cnt = cnt;
        }
    }
    public static void main(String[] args) throws Exception {
            for(int i = 0; i <= 2; i++){
                System.out.println(sol());
            }
    }
    private static int sol() throws Exception{

        int n = Integer.parseInt(br.readLine());
        target = 0;
        PriorityQueue<Coin> pq = new PriorityQueue<>((o1,o2) -> o1.cost - o2.cost);
        for(int i = 0; i < n; i++){
            String[] input = br.readLine().split(" ");
            int cost = Integer.parseInt(input[0]);
            int cnt = Integer.parseInt(input[1]);
            target += (cost * cnt);
            pq.offer(new Coin(cost, cnt));
        }
        if(target % 2 != 0){
            return 0;
        }
        boolean[] dp = new boolean[target+1];
        dp[0] = true;
        while(!pq.isEmpty()){
            Coin coin = pq.poll();
            for(int i = target/2; i >= coin.cost; i--){
                if(dp[i-coin.cost]){
                    for(int j = 0; j < coin.cnt; j++){
                        if(i + coin.cost * j <= target/2){
                            dp[i + coin.cost * j] = true;
                        }
                        else{
                            break;
                        }
                    }
                }
            }
        }
        if(dp[target/2])return 1;
        else return 0;
    }
}