import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static List<Info> infos = new ArrayList<>();
    static boolean[][] check;
    static class Info{
        int idx;
        int height;
        public Info(int idx, int height){
            this.idx = idx;
            this.height = height;
        }
        @Override
        public String toString(){
            return "idx = " + this.idx + " height = " + this.height;
        }
    }
    static boolean[] visit;
    static int[] answer;
    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        visit = new boolean[N];
        check = new boolean[N][N];
        answer = new int[N];
        input = br.readLine().split(" ");

        for(int i = 0; i < N; i++){
            //높이 정보 저장
            int h = Integer.parseInt(input[i]);
            infos.add(new Info(i, h));
        }

        for(int i = 0; i < M; i++){

            //다리 사이 연결 정보 저장
            input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]) - 1;
            int b = Integer.parseInt(input[1]) - 1;
            if(infos.get(a).height > infos.get(b).height){
                //a가 더 높은경우 a에서 b로만 내려갈 수 있다.
                check[a][b] = true;
            }
            else{
                //반대의 경우 a에서 b로 내려갈 수 있다.
                check[b][a] = true;
            }
        }
        //높이 정보 정렬
        infos.sort((o1,o2) -> o2.height - o1.height);
        for(Info info : infos){
            if(answer[info.idx] == 0) answer[info.idx] = 1;
            for(int i = 0; i < N; i++){
                if(i == info.idx) continue;
                if(check[info.idx][i]){
                    //내려갈 수 있다면
                    answer[i] = Math.max(answer[i], answer[info.idx] + 1);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++){
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);

    }

}