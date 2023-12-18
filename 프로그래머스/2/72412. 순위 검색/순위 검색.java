import java.util.*;

class Solution {
    static HashMap<String, List<Integer>> map = new HashMap<>();
    
    public List<Integer> solution(String[] info, String[] query) {
        String[] infos = new String[4];
        for(String temp : info){
            StringTokenizer st = new StringTokenizer(temp);
            //언어, 포지션, 경력, 음식, 점수
            for(int i = 0; i <= 3; i++){
                infos[i] = st.nextToken();
            }
            int point = Integer.parseInt(st.nextToken());
            for(int i = 0; i < 1 << 4; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < 4; j++){
                    if((1<<j & i) > 0){
                        sb.append("-");
                    }
                    else{
                        sb.append(infos[j]);
                    }
                }
                //key로 등록
                if(!map.containsKey(sb.toString())){
                    map.put(sb.toString(), new ArrayList<>());
                }
                map.get(sb.toString()).add(point);
            }
        }
        List<Integer> answer = new ArrayList<>();
        //정렬
        map.values().forEach((value) -> value.sort((o1,o2) -> o1-o2));
        for(String temp : query){
            String q = temp.replaceAll(" and ", "");
            StringTokenizer st = new StringTokenizer(q);
            String key = st.nextToken();
            int point = Integer.parseInt(st.nextToken());
            answer.add(cal(key, point));
            
        }
        
        return answer;
    }
    private static int cal(String key, int point){
        //값 가져오기
        if(!map.containsKey(key)){
            return 0;
        }
        List<Integer> value = map.get(key);
        int start = 0;
        int end = value.size() - 1;
        int result = 0;
        if(end == -1){
            return 0;
        }
        while(start <= end){
            int mid = (start + end) / 2;
            if(value.get(mid) < point){
                result = mid;
                start = mid + 1;
            }
            else{ //get >= point
                end = mid - 1;
                result = end;
            }
        }
        // System.out.println("key: "+key+" point: "+point);
        // System.out.println(value);
        // System.out.println(value.size() - result);
        return value.size() - result - 1;
        
    }
}