import java.lang.reflect.Array;
import java.util.*;
import java.io.*;

public class Main {
    static int n, b, a;
    static int[] arr;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]); //예산
        a = Integer.parseInt(input[2]); //할인가능 개수

        arr = new int[n];

        input = br.readLine().split(" ");
        for(int i = 0; i < input.length; i++){
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        int start = 0;
        int end = 0;
        int sum = 0;

        Loop:
        for(int gift : arr) {
            if(a > 0){
                //할인 가능할 때
                if(sum + gift/2 <= b){
                    sum += gift/2;
                    a --;
                    end++;
                }
                else{
                    break Loop;
                }
            }
            else{
                //할인 불가능 할 때
                sum += arr[start]/2;
                sum += gift/2;
                if(sum <= b){
                    start++;
                    end++;
                }
                else{
                    break Loop;
                }
            }
        }
        System.out.println(end);
    }
}