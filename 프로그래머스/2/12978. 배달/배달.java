import java.util.*;

class Solution {
    static int[] arr;
    static int[][] map;
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        arr = new int[N + 1]; //1번 마을부터 걸리는 최소 시간
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[1] = 0;
        map = new int[N+1][N+1]; //걸리는 시간 정보
        
        for(int i = 0; i <= N; i++){
            Arrays.fill(map[i], Integer.MAX_VALUE);
            map[i][i] = 0;
        }
        
        for(int[] r : road){
            //도로 정보 업데이트
            map[r[0]][r[1]] = Math.min(map[r[0]][r[1]], r[2]);
            map[r[1]][r[0]] = Math.min(map[r[1]][r[0]], r[2]);
        }
        
        
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(1);
        
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i = 1; i <= N; i++){
                //갈 수 없다면 건너뛰기
                if(i == cur || map[cur][i] == Integer.MAX_VALUE) continue;
                //만약 갈 수 있다면
                
                if(arr[i] > arr[cur] + map[cur][i]){
                    arr[i] = arr[cur] + map[cur][i];
                    q.offer(i);
                }
                
            }
        }
        
        for(int temp : arr){
            if(temp <= K) answer++;
        }
        
        return answer; //1번집 뻬기
    }
}