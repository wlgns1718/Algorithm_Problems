import java.io.*;
import java.util.*;

public class Main {
    static int N, M, L, K, answer = Integer.MAX_VALUE;
    static class Data{
        int x;
        int y;
        public Data(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static List<Data> ls = new ArrayList<>();

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        L = Integer.parseInt(input[2]);
        K = Integer.parseInt(input[3]);

        for (int i = 0; i < K; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            ls.add(new Data(x, y));
        }
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < K; j++) {
                int cnt = 0;
                for (int p = 0; p < K; p++) {
                    Data data = ls.get(p);
                    if (ls.get(i).x <= data.x && data.x <= ls.get(i).x + L &&
                            ls.get(j).y <= data.y && data.y <= ls.get(j).y + L) {
                        cnt++;
                    }
                    if (K - cnt < answer) {
                        answer = K - cnt;
                    }
                }
            }
        }
        System.out.println(answer);

    }
}