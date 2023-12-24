import java.util.*;

class Solution {
    static int[][] map;
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int cnt = 0;
        map = new int[rows][columns];
        
        //숫자 채우기
        fill(rows, columns);
        for(int[] query : queries){
            answer[cnt++] = rotation(query[0]-1,query[1]-1,query[2]-1,query[3]-1);
        }
        return answer;
    }
    private static void fill(int rows, int cols){
        int temp = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                map[i][j] = temp++;
            }
        }
    }
    private static int rotation(int x1, int y1, int x2, int y2){
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(map[x1][y1]);
        
        int idx = 0;
        int p1 = x1;
        int p2 = y1 + 1;
        int min = 987654321;
        if(queue.peek() < min){
            min = queue.peek();
        }
        while(idx < 4){
            queue.offer(map[p1][p2]);
            map[p1][p2] = queue.poll();
            if(queue.peek() < min){
                min = queue.peek();
            }
            if(idx == 0){
                p2 ++;
                if(p2 == y2+1){
                    p2 = y2;
                    p1 ++;
                    idx = 1;
                }
            }
            else if(idx == 1){
                p1 ++;
                if(p1 == x2 + 1){
                    p1 = x2;
                    p2 --;
                    idx = 2;
                }
            }
            else if(idx == 2){
                p2 --;
                if(p2 == y1 - 1){
                    p2 = y1;
                    p1 --;
                    idx = 3;
                }
            }
            else if(idx == 3){
                p1 --;
                if(p1 == x1 - 1){
                    p1 = x1;
                    idx = 4;
                    break;
                }
            }
        }
        return min;
    }
}