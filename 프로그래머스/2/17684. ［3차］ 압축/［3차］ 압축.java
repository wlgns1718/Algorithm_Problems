import java.util.*;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    static int idx = 1;
    static int cnt = 0;
    public List<Integer> solution(String msg) {
        List<Integer> ls = new ArrayList<>();
        init();
        for(int i = 0; i < msg.length(); i++){
            for(int j = i+1; j <= msg.length(); j++){
                if(!map.containsKey(msg.substring(i,j))){
                    if(map.containsKey(msg.substring(i,j-1))){
                        ls.add(map.get(msg.substring(i,j-1)));
                        cnt++;
                    }
                    map.put(msg.substring(i,j), idx++);
                    i += (j-2-i);
                    break;
                }
                if(j == msg.length()){
                    //끝까지 온 경우
                    if(map.containsKey(msg.substring(i,j))){
                        ls.add(map.get(msg.substring(i,j)));
                        cnt++;
                    }
                    return ls;
                }
            }
            
        }
        return ls;
    }
    
    private static void init(){
        char temp = '@';
        while(idx <= 26){
            map.put(String.valueOf((char)(temp + idx)), idx);
            idx++;
        }
    }
}