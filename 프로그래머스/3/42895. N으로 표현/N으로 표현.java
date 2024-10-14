import java.util.*;
class Solution {
    static List<List<Integer>> dp = new ArrayList<>();
    public int solution(int N, int number) {
        int answer = -1;
        for(int i = 1; i <= 8; i++){
            //N을 사용하는 총 개수 i
            HashSet<Integer> set = new HashSet<>();
            //N을 i개 붙인 수
            set.add(Integer.parseInt(String.valueOf(N).repeat(i)));
            
            //N을 1개부터 i-1개로 만들 수 있는 모든 수로 만들 수 있는 수
            for(int j = 0; j < i - 1; j++){
                //N을 j + 1만큼 사용한 수들 모음 dp[j]
                for(int num1 : dp.get(j)){
                    for(int num2 : dp.get(i-j-2)){
                        //N을 i-(j+1)만큼 사용한 수들 모음 dp[i-j-2]
                        set.add(num1 + num2);
                        set.add(num1 - num2);
                        set.add(num1 * num2);
                        if(num2 != 0){
                            set.add(num1/num2);
                        }
                    }
                }
                
            }
            if(set.contains(number)){
                return i;
            }
            dp.add(new ArrayList<Integer>());
            for(int temp : set){
                dp.get(i-1).add(temp);
            }
        }
        return answer;
    }
}