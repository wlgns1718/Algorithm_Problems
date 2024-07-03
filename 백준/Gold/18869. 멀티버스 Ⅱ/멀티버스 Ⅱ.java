import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] arr;

    static class Info{
        int size;
        int idx;

        public Info(int size, int idx){
            this.size = size;
            this.idx = idx;
        }

    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input = br.readLine().split(" ");
        M = Integer.parseInt(input[0]); //우주 개수
        N = Integer.parseInt(input[1]); //행성 개수

        //크기와 상관 없이 순서로 배치했을 때 모양이 같다.
        arr = new int[M][N];
        PriorityQueue<Info> pq = new PriorityQueue<>((o1,o2) -> o1.size - o2.size);

        for(int i = 0; i < M; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                pq.offer(new Info(Integer.parseInt(input[j]), j));
            }
            Info info = pq.poll();
            int val = 0;
            arr[i][info.idx] = val;
            int pre_size = info.size;
            for (int j = 1; j < N; j++) {
                info = pq.poll();
                if (pre_size == info.size) {
                    arr[i][info.idx] = val;
                } else {
                    val++;
                    arr[i][info.idx] = val;
                }
                pre_size = info.size;
            }
        }
        int answer = 0;
        boolean flag = true;
        for(int i = 0; i < M; i++){
            for(int j = i + 1; j < M; j++){
                flag = true;

                Loop:
                for(int idx = 0; idx < N; idx++){
                    if(arr[i][idx] != arr[j][idx]){
                        flag = false;
                        break Loop;
                    }
                }
                if(flag) answer ++;
            }
        }
        System.out.println(answer);
    }
}