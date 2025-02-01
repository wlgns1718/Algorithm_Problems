import java.util.*;
class Solution {
    static int numMul;
    static int numPlus;
    public int solution(int n) {
        int answer = 0;
        numMul = getRemainMul(n);
        numPlus = numMul * 2;
        answer = getSimulation(n - 2, numMul, numPlus - 2);
    
        return answer;
    }
    private static int getRemainMul(int n){
        return (int)(Math.log(n) / Math.log(3));
    }
    private static int getSimulation(int n , int numMul, int numPlus){
    	// 종료 조건 정의
        if(numMul*2 < numPlus)
            return 0;
        if(n == 3 && numMul == 1 && numPlus == 0)
            return 1;
        if(n == 4 && numMul == 1 && numPlus == 1)
            return 1;
        if(n == 5 && numMul == 1 && numPlus == 2)
            return 1;
        
        // 재귀 수행 정의
        int count = 0;
        for(int i = 0; i <= numPlus; ++i){
            if((n-i > 0) && (n-i) % 3 == 0){
                count += getSimulation((n - i) /3, numMul - 1, numPlus - i);
            }
        }
        
        return count;
    }
}