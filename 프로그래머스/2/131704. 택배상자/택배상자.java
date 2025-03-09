import java.util.*;
class Solution {
    
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> one = new Stack<>();
        Stack<Integer> two = new Stack<>();
        
        for(int i = order.length; i >= 1; i--){
            one.add(i);
        }
        
        for(int o : order){
            if(!one.isEmpty()){
                //one에서 꺼낼 수 없을 때
                if(one.peek() > o){
                    if(!two.isEmpty() && two.peek() == o){
                        answer++;
                        two.pop();
                    }
                    else{
                        return answer;
                    }
                }
                else{
                    //one에서 꺼낼 수 있을 떄
                    while(!one.isEmpty() && one.peek() < o){
                        two.add(one.pop());
                    }
                    answer++;
                    one.pop();
                }
            }
            else{
                //one이 다 비었을 때 two에서 꺼내기
                if(!two.isEmpty()){
                    if(two.peek() == o){
                        answer ++;
                        two.pop();
                    }
                }
                else{
                    return answer;
                }
            }
        }
        return answer;
    }
}