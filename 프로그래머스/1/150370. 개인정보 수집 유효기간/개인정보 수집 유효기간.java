import java.util.*;

class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    public int[] solution(String today, String[] terms, String[] privacies) {
        int cnt = 0;
        List<Integer> ls = new ArrayList<>();
        //기간 정보 담기
        for(String term : terms){
            StringTokenizer st = new StringTokenizer(term);
            String alp = st.nextToken();
            int during = Integer.parseInt(st.nextToken());
            map.put(alp,during);
        }
        for(int i = 0; i < privacies.length; i++){
            StringTokenizer st = new StringTokenizer(privacies[i]);
            String privacy = st.nextToken();
            String alp = st.nextToken();
            String date = cal(privacy, map.get(alp));
            if(sol(date, today)){
                //만약 반환 해야 한다면
                ls.add(i+1);
            }
        }
        int[] answer = new int[ls.size()];
        int idx = 0;
        for(int temp : ls){
            answer[idx++] = temp;
        }
        return answer;
    }
    private static String cal(String privacy, int during){
        
        StringTokenizer st = new StringTokenizer(privacy, ".");
        int year = Integer.parseInt(st.nextToken());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        
        //현재 day에서 -1
        day -= 1;
        
         // during을 현재 month에 더하기
        month += during;
        
        //현재 day가 0이라면 month -1과 28일로 셋팅
        if(day == 0){
            day = 28;
            month -= 1;
        }
        
        //현재 month가 12를 넘는다면 넘는 달 만큼 년수 계산
        if(month > 12){
            int temp = month/12;
            year += temp;
            // month 다시 계산
            month -= temp * 12;
            //만약 month가 0이 된다면
            if(month == 0){
                month = 12;
                year -= 1;
            }
        }
        
        //계산 올바른지 검사
        StringBuilder sb = new StringBuilder();
        sb.append(year).append(".").append(month).append(".").append(day);
        // System.out.println(sb.toString());
        return sb.toString();
    }
    private static boolean sol(String cal, String today){
        
        StringTokenizer st = new StringTokenizer(cal,".");
        int cal_year = Integer.parseInt(st.nextToken());
        int cal_month = Integer.parseInt(st.nextToken());
        int cal_day = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(today,".");
        int today_year = Integer.parseInt(st.nextToken());
        int today_month = Integer.parseInt(st.nextToken());
        int today_day = Integer.parseInt(st.nextToken());
        
        //오늘 날짜와 비교 만약 빼야 한다면 true 반환
        if(cal_year == today_year){
            if(cal_month < today_month){ //moth 비교
                return true;
            }
            else if(cal_month == today_month){ //day 비교
                if(cal_day < today_day){
                    return true;
                }
            }
        }
        else if(cal_year < today_year){
            return true;
        }
        return false;
    }
}