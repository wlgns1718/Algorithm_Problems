import javax.lang.model.element.NestingKind;
import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int l = input.length() * 9;
        int num = Integer.parseInt(input);
        for(int i = num - l; i < num; i++){
            int answer = i;
            int temp = i;
            while(temp > 0){
                answer += temp % 10;
                temp /= 10;
            }
            if(answer == num){
                flag = true;
                System.out.println(i);
                break;
            }
        }
        if(!flag) System.out.println(0);
    }
}