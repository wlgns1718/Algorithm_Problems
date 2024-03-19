class Solution {
    static int[] gok = new int[3];
    static int val = Integer.MAX_VALUE, total_gok = 0;
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        for(int i = 0; i < 3; i++){
            gok[i] = picks[i];
            total_gok += gok[i];
        }
        
        sol(0, 0, minerals, 0);
        answer = val;
        return answer;
    }
    private static void sol(int pirodo, int idx, String[] minerals, int cnt){
        
        if(idx == minerals.length || cnt == total_gok){
            if(val > pirodo){
                val = pirodo;
            }
            return;
        }
        
        for(int i = 0; i < 3; i++){
            if(gok[i] > 0){
                //현재 곡갱이를 쓸 수 있다면
                gok[i] -= 1;
                
                int temp = 0;
                int index = 0;
                
                if(i == 0){
                    //다이아 곡갱이라면
                    if(minerals.length - idx >= 5){
                        sol(pirodo + 5, idx + 5, minerals, cnt + 1);
                    }
                    else{
                        int a = minerals.length - idx;
                        sol(pirodo + a, idx + a, minerals, cnt + 1);
                    }
                    
                }
                else if(i == 1) {
                    //철 곡갱이라면
                    for(int j = idx; j < idx + 5; j++){
                        
                        if(j == minerals.length) break;
                        index++;
                        
                        if(minerals[j].equals("diamond")){
                            temp += 5;
                        }
                        else{
                            temp += 1;
                        }
                    }
                    sol(pirodo + temp, idx + index, minerals, cnt + 1);
                }
                else{
                    //돌 곡갱이라면
                    for(int j = idx; j < idx + 5; j++){
                        
                        if(j == minerals.length) break;
                        index++;
                        
                        if(minerals[j].equals("diamond")){
                            temp += 25;
                        }
                        else if(minerals[j].equals("iron")){
                            temp += 5;
                        }
                        else{
                            temp += 1;
                        }
                    }
                    sol(pirodo + temp, idx + index, minerals, cnt + 1);
                }
                gok[i] += 1;
            }
        }
    }
}