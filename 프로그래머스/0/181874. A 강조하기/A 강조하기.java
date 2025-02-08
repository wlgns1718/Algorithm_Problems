import java.util.*;
class Solution {
    public String solution(String myString) {
        String answer = myString.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(char a : answer.toCharArray()){
            if(a == 'a'){
                sb.append("A");
            }else{
                sb.append(a);
            }
        }
        answer = sb.toString();
        return answer;
    }
}