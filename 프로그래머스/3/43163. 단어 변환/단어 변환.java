import java.util.*;
class Solution {
    static String tar;
    static int ans = Integer.MAX_VALUE;
    static boolean[] visit;
    static int[] val;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        tar = target;
        visit = new boolean[words.length];
        val = new int[words.length];
        Arrays.fill(val, Integer.MAX_VALUE);
        sol(begin, 0, words);
        answer = ans == Integer.MAX_VALUE ? 0 : ans;
        return answer;
    }
    private static void sol(String word, int cnt, String[] words){
        
        if(word.equals(tar)){
            ans = Math.min(cnt, ans);
            return;
        }
        for(int i = 0; i < words.length; i++){
            if(visit[i]) continue;
            int temp = 0;
            for(int j = 0; j < word.length(); j++){
                if(word.charAt(j) != words[i].charAt(j)) temp++;
                if(temp > 1) break;
            }
            if(temp == 1){
                if(val[i] > cnt + 1){
                    visit[i] = true;
                    val[i] = cnt + 1;
                    sol(words[i], cnt + 1, words);
                    visit[i] = false;
                }
            }
        }
    }
}