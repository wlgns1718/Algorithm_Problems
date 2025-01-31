class Solution {
    static char[] list = {'A', 'E', 'I', 'O', 'U'};
    public int solution(String word) {
        int answer = 0;
        for(int i = 0; i < word.length(); i++){
            char temp = word.charAt(i);
            answer += cal(i, temp);
        }
        return answer;
    }
    private static int cal(int idx, char alp){
        //1 5 25 125 625
        int res = 1;
        int index = 0;
        while(list[index] != alp){
            for(int i = 0; i < 5 - idx; i++){
                res += (int) Math.pow(5, i);
            }
            index++;
        }
        return res;
    }
}