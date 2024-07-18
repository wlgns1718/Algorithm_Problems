import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        int end = -1;
        
        Arrays.sort(targets, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        for(int[] temp : targets){
            if(end == -1){
                answer ++;
                end = temp[1];
                continue;
            }
            if(end > temp[0]) continue;
            answer ++;
            end = temp[1];
        }
        return answer;
    }
}