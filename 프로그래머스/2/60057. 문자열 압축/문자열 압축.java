class Solution {
    public int solution(String s) {
        int answer = s.length();
        int end = s.length() / 2;
        int start = 1;
        
        while(start <= end){
            String pre = null;
            int diff = 0;
            int res = s.length();
            boolean flag = false;
            int count = 1;
            
            for(int i = 0; i <= s.length() - start; i += start){
                if(i == 0){
                    pre = s.substring(0, start);
                    continue;
                }
                if(pre.equals(s.substring(i, i + start))){
                    flag = true;
                    diff ++;
                    count ++;
                }
                else{
                    if(flag){
                        flag = false;
                        res += String.valueOf(count).length();
                    }
                    pre = s.substring(i, i + start);
                    count = 1;
                }
                
            }
            if(flag) res += String.valueOf(count).length();
            
            res -= (diff * start);
            answer = Math.min(answer, res);
            start ++;
        }
        return answer;
    }
}