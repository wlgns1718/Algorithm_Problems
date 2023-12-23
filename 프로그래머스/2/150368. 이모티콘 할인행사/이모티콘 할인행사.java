import java.util.*;

class Solution {
    static int[] sales = {10, 20 ,30, 40};
    static int[] info, answer;
    static int n;
    static boolean tri = true;
    public int[] solution(int[][] users, int[] emoticons) {
        // 이모티콘 가격 정렬, 비싼 것 부터 할인 적용
        Arrays.sort(emoticons);        
        answer = new int[2];
        n = emoticons.length;
        info = new int[n];
        sol(0, users, emoticons);
        
        
        return answer;
    }
    private static void sol(int idx, int[][] users, int[] emoticon){
        if(idx == n){
            //정해진 할인율로 정보 계산
            tri = cal(users, emoticon);
            return;
        }
        
        for(int i = 3; i >= 0; i--){
            info[idx] = sales[i];
            sol(idx + 1, users, emoticon);
        }
    }
    private static boolean cal(int[][] users, int[] emoticon){
        int price = 0; //가격
        int cnt = 0; //가입자 수
        for(int[] user : users){
            
            int target = user[0];
            int limit = user[1];
            int temp = 0;
            for(int i = 0; i < n; i++){
                if(target <= info[i]){
                    //할인율이 만족스러워 사는 경우
                    temp += emoticon[i] - ((emoticon[i] * info[i]) / 100);
                }
            }
            // limit 보다 작다면 사고 아니라면 가입하기
            if(temp >= limit){
                cnt++;
            }
            else{
                price += temp;
            }
        }
        
        //만약 기존 가입자 보다 적은 경우 취소
        if(answer[0] > cnt){
            return false;
        }
        else{
            if(answer[0] < cnt){
                //가입자 수가 더 많다면
                answer[0] = cnt;
                answer[1] = price;
                return true;
            }
            else{
                //가입자 수가 같다면
                if(answer[1] < price){
                    answer[1] = price;
                }
                return true;
            }
        }
    }
    
}