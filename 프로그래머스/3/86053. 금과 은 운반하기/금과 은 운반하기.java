class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long answer = 0;
        long start = 1;
        long end = ((long) Math.pow(10,9)) * 2 * ((long)Math.pow(10,5)) * 2;
        long mid;
        
        while(start <= end){
            
            mid = (start + end) / 2;
        
            long gold = 0;
            long silver = 0;
            long total = 0;
            
            long move;
            long weight;
            
            for(int i = 0; i < t.length; i++){
                move = mid / (t[i] * 2);
                if(mid % (t[i] * 2) >= t[i]){
                    move++;
                }
                
                weight = w[i] * move;
                
                gold += Math.min(weight, g[i]);
                silver += Math.min(weight, s[i]);
                total += Math.min(weight, s[i] + g[i]);
            }
            if(gold >= a && silver >= b && a + b <= total){
                answer = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return answer;
    }
}