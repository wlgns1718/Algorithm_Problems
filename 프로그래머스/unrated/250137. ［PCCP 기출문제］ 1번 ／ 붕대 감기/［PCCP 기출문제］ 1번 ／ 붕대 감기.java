class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health; //현재 hp
        int time = 0; //현재 시간
        int skill = 0; //기술 사용 시간
        for(int[] attack : attacks){
            time++;
            while(time < attack[0]){
                //현재 시간이 괴물의 공격 시간보다 작을 때
                time++;
                skill++;
                if(answer < health){ //최대 채력 밑이라면 회복하기
                    answer += bandage[1];
                    //만약 health를 넘었다면
                    if(answer > health){
                        answer = health;
                    }
                }
                //만약 연속 사용에 성공했다면
                if(skill == bandage[0]){
                    skill = 0;
                    answer += bandage[2];
                    //만약 최대 체력을 넘겼다면
                    if(answer > health){
                        answer = health;
                    }
                }
                
                
            }
            //괴물의 공격을 맞는 순간
            answer -= attack[1]; //hp 감소
            skill = 0; // 스킬 사용시간 초기화
            // System.out.println("현재 hp: "+ answer + " 현재 시간: "+time);
            //만약 hp가 0이하가 된다면
            if(answer <= 0){
                return -1;
            }
            
        }
        
        // System.out.println(time);
        return answer;
    }
}