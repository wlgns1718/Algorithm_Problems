import java.util.*;
import java.io.*;

public class Main {
    static int M, N, L;
    static int[] x;
    static Loc[] animal;
    static int count = 0;
    static boolean visited[];
    static class Loc {
        int x, y;

        public Loc(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        x = new int[M];

        // 사대
        st = new StringTokenizer(br.readLine());

        // 사대 X좌표
        for (int i = 0; i < M; i++) {
            x[i] = Integer.parseInt(st.nextToken());
        }

        // 사대 정렬
        Arrays.sort(x);

        // 동물의 좌표
        animal = new Loc[N];
        visited = new boolean[N+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
//            animal[i] = new Loc(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(b > N){
                continue;
            }
            int temp = L - b;
            int end = M - 1;
            int start = 0;
            while(start <= end){
                int mid = (start+end) / 2;
                int val = a - x[mid];
                if (Math.abs(val) <= temp){
                    count += 1;
                    break;
                }
                if (val < 0){
                    end = mid - 1;
                }
                else{
                    start = mid + 1;
                }

            }


        }

        // 동물 정렬
//        Arrays.sort(animal, (o1, o2) -> o1.x - o2.x);

//        for (int i = 0; i < N; i++) {
//            for(int j = 0; j < M; j++){
//                if (visited[i]) {
//                    break;
//                }
//
//                if (Math.abs(x[j] - animal[i].x) <= L - animal[i].y) {
//                    count++;
//                    visited[i] = true;
//                }
//
//            }
//        }
        System.out.println(count);

    }
}