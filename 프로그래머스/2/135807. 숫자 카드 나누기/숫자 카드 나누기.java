import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);
        
        
        //A를 모두 나눌 수 있는데 B는 나눌 수 없을 때
        //B를 모두 나눌 수 있는데 A는 나눌 수 없을 때
        
        answer = Math.max(cal(arrayA, arrayB), cal(arrayB, arrayA));
        return answer;
    }
    public static int cal(int[] arr, int[] brr){
        //arr의 수를 모두 나눌 수 있는데 brr의 수를 모두 나눌 수 없는 수 반환
        int res = 0;
        //arr을 모두 나눌 수 있는 경우는 arr수들의 공약수
        
        int temp = arr[0]; //arr중 가장 작은 수 선택
        
        //arr의 약수 1제외하고 구하기
        
        //높은 수 부터 확인하기
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        pq.offer(temp);
        for(int i = 2; i <= (int) Math.sqrt(temp); i++){
            if(temp % i == 0){
                pq.add(i);
                pq.add(temp / i);
            }
        }
        boolean flag = true;
        
        while(!pq.isEmpty()){
            int cur = pq.poll();
            flag = true;
            for(int i = 0; i < arr.length; i++){
                
                if(arr[i] % cur != 0 || brr[i] % cur == 0){
                    flag = false;
                    break;
                }
            }
            if(flag) return cur;
        }
        return res;
    }
}