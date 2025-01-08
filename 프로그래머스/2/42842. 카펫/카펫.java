class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int row, col, sum, res;
        sum = (brown - 4) / 2;
        row = sum - 1;
        col = 1;
        while(col <= row){
            if(col * row == yellow){
                answer[0] = row + 2;
                answer[1] = col + 2;
                return answer;
            }
            col ++;
            row --;
        }
        return answer;
    }
}