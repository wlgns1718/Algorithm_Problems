import java.util.*;
class Solution {
    static Map<String, Integer> map = new HashMap<>();
    static Map<String, Integer> contain = new HashMap<>();
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        for(int i = 0; i < want.length; i++){
            String w = want[i];
            int cnt = number[i];
            map.put(w, cnt);
        }
        
        for(int i = 0; i < 10; i++){
            String d = discount[i];
            if(!contain.containsKey(d)) contain.put(d, 0);
            int temp = contain.get(d);
            contain.replace(d, temp + 1);
        }
        
        for(int i = 10; i < discount.length; i++){
            if(compare(want)) answer++;
            
            String s = discount[i - 10];
            if(contain.get(s) == 1){
                contain.remove(s);
            }
            else{
                int temp = contain.get(s);
                contain.replace(s, temp-1);
            }
            
            s = discount[i];
            if(!contain.containsKey(s)) contain.put(s, 0);
            int temp = contain.get(s);
            contain.replace(s, temp + 1);
        }
        if(compare(want)) answer++;
        return answer;
    }
    
    public static boolean compare(String[] want){
        for(String s : want){
            if(!contain.containsKey(s)) return false;
            if(contain.get(s) != map.get(s)) return false;
        }
        return true;
    }
}