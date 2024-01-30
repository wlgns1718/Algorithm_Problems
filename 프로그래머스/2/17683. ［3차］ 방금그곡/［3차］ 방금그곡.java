import java.util.*;

class Solution {
    static String[] arr;
    static String[] brr = {"C","C#","D","D#","E","F","F#","G","G#","A","A#","B"};
    static String[] crr = {"A","B","C","D","E","F","G","H","I","J","K","L"};
    static HashMap<String, String> map = new HashMap<>();
    static StringBuilder sb = new StringBuilder();
    
    public String solution(String m, String[] musicinfos) {
        int time = 0;
        String answer = "(None)";
        int n = musicinfos.length;
        arr = new String[n];
        for(int i = 0; i < 12; i++){
            map.put(brr[i], crr[i]);
        }
        m = exchange(m.length(), m);
        sb.delete(0, sb.length());
        
        for(int i = 0; i < n; i++){
            
            String music = musicinfos[i];
            String[] temp = music.split(",");
            //시작 시간
            int S_hour = Integer.parseInt(temp[0].substring(0,2));
            int S_Min = Integer.parseInt(temp[0].substring(3,5));
            //끝나는 시간
            int E_hour = Integer.parseInt(temp[1].substring(0,2));
            int E_Min = Integer.parseInt(temp[1].substring(3,5));
            
            if(S_hour > E_hour){
                E_hour = 24;
            }
            int hour = E_hour - S_hour;
            int total = (hour * 60 + E_Min - S_Min);
            
            sb.delete(0,sb.length());
            String temp_word = exchange(temp[3].length(), temp[3]);
            sb.delete(0,sb.length());
            int mot = total / (temp_word.length());
            int remain = total % (temp_word.length());
            
            sb.append(temp_word.repeat(mot));
            sb.append(temp_word.substring(0,remain));
            arr[i] = sb.toString();
            if(arr[i].contains(m) && time < total){
                answer = temp[2];
                time = total;
            }
        }
        
        return answer;
    }
    static private String exchange(int size, String word){
        for(int i = 0; i < size; i++){
            if(i+1 < size && word.charAt(i+1) == '#'){
                sb.append(map.get(word.substring(i,i+2)));
                i++;
            }
            else{
                sb.append(map.get(word.substring(i,i+1)));
            }
        }
        return sb.toString();
    }
}