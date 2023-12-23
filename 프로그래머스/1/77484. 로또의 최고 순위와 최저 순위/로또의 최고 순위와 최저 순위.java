import java.util.*;

class Solution {
    static HashSet<Integer> win_set = new HashSet<>();
    static HashSet<Integer> set = new HashSet<>();
    static int cnt_zero = 0;
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        for(int win : win_nums){
            win_set.add(win);
        }
        
        for(int lotto : lottos){
            if(lotto == 0){
                cnt_zero++;
                continue;
            }
            if(win_set.contains(lotto)){
                set.add(lotto);
            }
        }
        answer[0] = 7 - (set.size() + cnt_zero);
        answer[1] = 7 - (set.size());
        if(answer[0] >= 6){
            answer[0] = 6;
        }
        if(answer[1] >= 6){
            answer[1] = 6;
        }
        return answer;
    }
}