import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        int temp = 0;
        int idx = 0;
        boolean flag = true;
        for(int i = 1; i <= elements.length; i++){
            
            for(int j = 0; j < elements.length; j++){
                temp = 0;
                idx = 0;
                flag = false;
                for(int p = 0; p < i; p++){
                    temp += elements[j + idx++];
                    if(!flag && j + idx == elements.length){
                        flag = true;
                        idx = -j;
                    }
                }
                set.add(temp);
            }
        }
        answer = set.size();
        
        return answer;
    }
}