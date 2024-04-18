
class Solution {
    static boolean[][][][] visit = new boolean[11][11][11][11];
    public int solution(String dirs) {
        int answer = 0;
        int x = 5, y = 5;
        for(int i = 0; i < dirs.length(); i++){
            char c = dirs.charAt(i);
            if(c == 'U'){
                if(x - 1 >= 0){
                    if(!visit[x][y][x-1][y]) answer++;
                    visit[x][y][x-1][y] = true;
                    visit[x-1][y][x][y] = true;
                    x -= 1;
                }
            }
            else if(c == 'D'){
                if(x + 1 <= 10){
                    if(!visit[x][y][x+1][y]) answer++;
                    visit[x][y][x+1][y] = true;
                    visit[x+1][y][x][y] = true;
                    x += 1;
                }
                
            }
            else if(c == 'L'){
                if(y - 1 >= 0){
                    if(!visit[x][y][x][y-1]) answer++;
                    visit[x][y][x][y - 1] = true;
                    visit[x][y - 1][x][y] = true;
                    y -= 1;
                }
            }
            else{
                if(y + 1 <= 10){
                    if(!visit[x][y][x][y+1]) answer++;
                    visit[x][y][x][y + 1] = true;
                    visit[x][y + 1][x][y] = true;
                    y += 1;
                }
            }
        }
        return answer;
    }
}