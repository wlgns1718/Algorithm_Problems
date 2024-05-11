import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input;
        arr = new int[19][19];

        for(int i = 0; i < 19; i++){
            input = br.readLine().split(" ");
            for(int j = 0; j < 19; j++){
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }
        int[] answer = new int[2];
        Loop1:
        for(int i = 0; i < 19; i++){
            for(int j = 0; j < 19; j++){
                if(arr[i][j] == 0) continue;
                answer = check(i,j);
                if(answer != null){
                    sb.append(arr[answer[0]][answer[1]]).append("\n");
                    sb.append(answer[0] + 1).append(" ").append(answer[1] + 1);
                    System.out.println(sb);
                    break Loop1;
                }
            }
        }
        if(sb.length() == 0) System.out.println(0);
    }
    private static int[] check(int x, int y){
        int[] res = new int[2];
        
        int color = arr[x][y];

        //가로 확인
        if(y + 4 < 19){
            for(int i = 1; true; i++){
                if(arr[x][y+i] != color) break;
                if(i == 4){
                    //양쪽이 같은 돌인지 확인
                    if(y - 1 >= 0 && arr[x][y-1] == color) break;
                    if(y + 5 < 19 && arr[x][y+5] == color) break;
                    res[0] = x;
                    res[1] = y;
                    return res;
                }
            }
        }
        //세로 확인
        if(x + 4 < 19){
            for(int i = 1; true; i++){
                if(arr[x+i][y] != color) break;
                if(i == 4){

                    //같은 돌인지 확인
                    if(x - 1 >= 0 && arr[x-1][y] == color) break;
                    if(x + 5 < 19 && arr[x + 5][y] == color) break;
                    res[0] = x;
                    res[1] = y;
                    
                    return res;
                }
            }
        }
        //대각선 확인
        if(x + 4 < 19 && y + 4 < 19){
            for(int i = 1; true; i++){
                if(arr[x+i][y+i] != color) break;
                if(i == 4){
                    if(x - 1 >= 0 && y - 1 >= 0 && arr[x-1][y-1] == color) break;
                    if(x + 5 < 19 && y + 5 < 19 && arr[x+5][y+5] == color) break;
                    res[0] = x;
                    res[1] = y;
                    return res;
                }
            }
        }
        if(x + 4 < 19 && y - 4 >= 0){
            for(int i = 1; true; i++){
                if(arr[x+i][y-i] != color) break;
                if(i == 4){
                    if(x - 1 >= 0 && y + 1 < 19 && arr[x-1][y+1] == color)break;
                    if(x + 5 < 19 && y - 5 >= 0 && arr[x+5][y-5] == color) break;
                    res[0] = x + 4;
                    res[1] = y - 4;
                    
                    return res;
                }
            }
        }
        return null;

    }

}