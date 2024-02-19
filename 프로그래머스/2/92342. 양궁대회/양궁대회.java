class Solution {
    static int total = 0;
    static int[] answer;
    static boolean tri;
    public int[] solution(int n, int[] info) {
        answer = new int[11];
        cal(n, 0, info, new int[11]);
        if(!tri){
            return new int[] {-1};
        }
        return answer;
    }
    private static void cal(int n, int idx, int[] info, int[] ls){
        if(n == 0 || idx >= 11){
            int ryan = 0;
            int appeach = 0;
            int temp;
            for(int i = 0; i < 11; i++){
                if(ls[i] != 0 && ls[i] > info[i]){
                    ryan += (10-i);
                }
                if(info[i] != 0 && info[i] > ls[i]){
                    appeach += (10-i);
                }
            }
            temp = ryan - appeach;
            if(total < temp){
                tri = true;
                total = temp;
                for(int j = 0; j < 11; j++){
                    answer[j] = ls[j];
                }
                if(n != 0){
                    answer[10] += n;
                }
            }
            else if(total == temp){
                boolean flag = false;
                for(int i = 10; i >= 0; i--){
                    if(answer[i] > ls[i]){
                        break;
                    }
                    else if(answer[i] < ls[i]){
                        flag = true;
                        break;
                    }
                }
                if(flag){
                    for(int j = 0; j < 11; j++){
                        answer[j] = ls[j];
                    }
                }
            }
            return;
        }
        // n으로 점수를 얻을 수 있다면
        if(info[idx] < n){
            ls[idx] = info[idx] + 1;
            cal(n - ls[idx], idx + 1, info, ls);
            ls[idx] = 0;
            // 점수를 얻지 않고 넘기기
            cal(n, idx + 1, info, ls);
        }
        else{
            // 점수를 얻을 수 없다면 그냥 넘기기
            cal(n, idx + 1, info, ls);
        }
        
        
    }
}