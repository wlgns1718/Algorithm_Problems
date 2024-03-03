import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class Main {
    static int n;
    static int[] arr;
    static int answer;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        // 숫자 입력받기
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        boolean[] visited = new boolean[n+1];
        for(int i = 1; i <= n; i++){
            int curr = i;
            Set<Integer> temp = new HashSet<>();
            if(!visited[curr]){
                while(true){
                    int next = arr[curr];
                    if(!temp.contains(next)){
                        temp.add(next);
                        curr = next;
                        if(next == i){ // 싸이클 생성되면 해당 집합을 정답에 포함
                            temp.forEach(t -> visited[t] = true);
                            break;
                        }
                    }else break;
                }
            }
        }
        // 결과 출력을 위한 StringBuilder
        IntStream.range(1, n+1).forEach(i -> {
            if(visited[i]){
                sb.append(i).append('\n');
                answer++;
            }
        });
        System.out.println(answer);
        System.out.println(sb);
    }
}