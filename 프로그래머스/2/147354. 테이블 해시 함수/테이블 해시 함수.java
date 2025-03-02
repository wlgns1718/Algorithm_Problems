import java.util.*;
class Solution {
    static List<Integer> ls = new ArrayList<>();
    static class Info{
        int key;
        int x;
        int idx;
        public Info(int key, int x, int idx){
            this.key = key;
            this.x = x;
            this.idx = idx;
        }
    }
    static PriorityQueue<Info> pq = new PriorityQueue<>((o1, o2) ->{
        if(o1.x != o2.x) return o1.x - o2.x;
        else return o2.key - o1.key;
    });
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        //col 컬럼을 기준으로 ASC, 만약 같으면 KEY로 DESC,
        //S_i는 해당 행의 각 값을 i로 나눈 나머지 합
        for(int i = 0; i < data.length; i++){
            pq.offer(new Info(data[i][0], data[i][col - 1], i));
        }
        
        for(int i = 0; i < row_begin - 1; i++) pq.poll();
        int cnt = row_end - row_begin + 1;
        int mod = row_begin;
        for(int i = 0; i < cnt; i++, mod++){
            
            Info info = pq.poll();
            int res = 0;
            for(int temp : data[info.idx]){
                res += (temp % mod);
            }
            ls.add(res);
        }
        for(int temp : ls){
            answer = (answer ^ temp);
        }
        return answer;
    }
}