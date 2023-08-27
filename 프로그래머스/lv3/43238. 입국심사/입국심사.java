class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        long start = 0;
        long end = 1000000000L * 1000000000L;
        while(start <= end){
            long mid = (start+end) / 2;
            long count = 0;
            for(int time : times){
                count += (mid/time);
            }
            if(count < n){
                start = mid + 1;
                answer = start;
            }
            else{
                end = mid - 1;
                answer = mid;
            }
        }
        return answer;
    }
}