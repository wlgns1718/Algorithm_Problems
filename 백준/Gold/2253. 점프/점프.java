import java.util.*;
import java.io.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static int N, M;
    static boolean[] arr;
    static List<Map<Integer, Integer>> ls = new ArrayList<>();

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]); //총 돌의 개수
        M = Integer.parseInt(input[1]); //밟을 수 없는 돌의 개수
        for(int i = 0; i < N; i++){
            ls.add(new HashMap<>());
        }

        arr = new boolean[N];
        for(int i = 0; i < M; i++){
            int idx = Integer.parseInt(br.readLine());
            arr[idx - 1] = true;
        }

        //ls의 index = 돌 번호, map의 key = 점프크기, val = 횟수
        ls.get(0).put(0, 0);
        ls.get(1).put(1, 1);
        //돌번호 0번 부터 시작
        for(int i = 1; i < N - 1; i++){
            //만약 갈 수 없는 돌 번호면 생략
            if(arr[i]) continue;

            //현재 돌 범위에서 갈 수 있는 점프 범위 탐색
            for(Integer jump : ls.get(i).keySet()){
                int cnt = ls.get(i).get(jump);

                for(int j = -1; j <= 1; j++){

                    int temp = jump + j;

                    //점프가 1이상 안되는 경우
                    if(temp <= 0) continue;

                    //범위를 벗어나는 경우
                    if(i + temp >= N) continue;

                    //해당 돌로 갈 수 없는 경우
                    if(arr[i + temp]) continue;

                    //이미 해당 jump크기가 있는 경우
                    if(ls.get(temp + i).containsKey(temp)){
                        //횟수 비교
                        ls.get(temp + i).replace(temp, Math.min(cnt + 1, ls.get(temp + i).get(temp)));
                    }
                    //없으면 새로 담기
                    else{
                        ls.get(temp + i).put(temp, cnt + 1);
                    }
                }

            }
        }
        int answer = Integer.MAX_VALUE;

        for(Integer jump : ls.get(N-1).keySet()){
            answer = Math.min(answer, ls.get(N-1).get(jump));
        }
        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
    }
}