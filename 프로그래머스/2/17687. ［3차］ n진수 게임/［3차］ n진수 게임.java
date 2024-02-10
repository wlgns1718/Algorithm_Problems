import java.io.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        
        for(int i = 0; temp.length() <= t * m; i++){
            temp.append(Integer.toString(i, n));
        }
        for(int i = p - 1; answer.length() < t; i += m){
            answer.append(temp.charAt(i));
        }
        return answer.toString().toUpperCase();
    }
}