import java.util.*;

class Solution {
    static PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> o2 - o1);
    static PriorityQueue<Integer> min = new PriorityQueue<>();
    
    public int[] solution(String[] operations) {
        int[] answer = new int[2];
        for(String oper : operations){
            String[] temp = oper.split(" ");
            if(temp[0].equals("I")){
                //숫자 삽입
                int n = Integer.parseInt(temp[1]);
                max.offer(n);
                min.offer(n);
            }
            else{
                
                //모든 큐가 비어있다면 건너뛰기
                if(max.isEmpty()) continue;
                
                if(temp[1].equals("1")){
                    //최댓값 삭제
                    int n = max.poll();
                    min.remove(n);
                }
                else{
                    //최솟값 삭제
                    int n = min.poll();
                    max.remove(n);
                }
            }
        }
        if(!max.isEmpty()){
            answer[0] = max.peek();
            answer[1] = min.peek();
        }
        return answer;
    }
}