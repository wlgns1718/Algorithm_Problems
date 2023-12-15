import java.util.*;
class Solution {
    static HashMap<String, String> map = new HashMap<>();
    public String[] solution(String[] record) {
        int cnt = 0;
        
        for(String temp : record){
            StringTokenizer st = new StringTokenizer(temp);
            String order = st.nextToken();
            String uid = st.nextToken();
            if(order.equals("Leave")){
                cnt++;
                continue;
            };
            String nickname = st.nextToken();
            
            if(order.equals("Enter")){
                map.put(uid, nickname);
                cnt++;
            }
            else{
                // System.out.println(order);
                map.put(uid,nickname);
                // System.out.println(map.get(uid));
            }
        }
        int idx = 0;
        String[] answer = new String[cnt];
        for(String temp : record){
            StringTokenizer st = new StringTokenizer(temp);
            StringBuilder sb = new StringBuilder();
            String order = st.nextToken();
            String uid = st.nextToken();
            sb.append(map.get(uid)).append("님이 ");
            if(order.equals("Leave")){
                sb.append("나갔습니다.");
                answer[idx++] = sb.toString();
            }
            else if(order.equals("Enter")){
                sb.append("들어왔습니다.");
                answer[idx++] = sb.toString();
            }
        }
        
        return answer;
    }
}