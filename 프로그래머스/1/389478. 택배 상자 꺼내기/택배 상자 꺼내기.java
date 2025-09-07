import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 1;
       
        
        int height = n % w == 0? n/w : n/w + 1;
        int x = 0, y = 0;
        
        int[][] arr = new int[height][w];
        int idx = 1;
        for(int i = 0; i <= height; i++){
            if(i % 2 == 0){
                for(int j = 0; j < w; j++){
                    arr[i][j] = idx++;
                    if(arr[i][j] == num){
                        x = i;
                        y = j;
                    }
                }
            }
            else{
                for(int j = w-1; j >= 0; j--){
                    arr[i][j] = idx++;
                    if(arr[i][j] == num){
                        x = i;
                        y = j;
                    }
                }
            }
            if(idx > n) break;
        }
        
        while(x < height){
            if(x + 1 < height && arr[x+1][y] <= n) answer++;
            x ++;
        }
        return answer;
    }
}