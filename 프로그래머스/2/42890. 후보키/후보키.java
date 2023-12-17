import java.util.*;

class Solution {
    static int n, m;
    static List<Integer> answer = new ArrayList<>();
    public int solution(String[][] relation) {
        n = relation.length;
        m = relation[0].length;
        
        for(int i = 1; i < 1 << m; i++){
            // i는 어떤 col 선택할건지
            // 중복검사
            Set<String> set = new HashSet<>();
            for(int j = 0; j < n; j++){
                StringBuilder sb = new StringBuilder();
                for(int k = 0; k < m; k++){
                    if((1<<k & i) > 0){ //포함이 된다면
                        sb.append(relation[j][k]);
                    }
                }
                set.add(sb.toString());
            }
            if(set.size() == n && check(i)){
                answer.add(i);
            }
        }
        
        return answer.size();
    }
    private static boolean check(int i){
        for(int ans : answer){
            if((ans & i) == ans){ //만약 부분이 포함된다면
                return false;
            }
        }
        return true;
    }
}