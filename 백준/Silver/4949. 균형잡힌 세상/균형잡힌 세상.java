import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        while(true){
            String input = br.readLine();
            if(input.equals(".")) break;

            int[] arr = new int[2];
            boolean flag = true;
            Stack<Character> stack = new Stack<>();
            Loop1:
            for(int i = 0; i < input.length(); i++){
                char a = input.charAt(i);
                if(a == '('){
                    stack.add(a);
                    arr[0]++;
                }
                else if(a == ')'){

                    if(arr[0] == 0 || stack.peek() != '('){
                        sb.append("no").append("\n");
                        flag = false;
                        break Loop1;
                    }
                    arr[0]--;
                    stack.pop();
                }
                else if(a == '['){
                    stack.add(a);
                    arr[1] ++;
                }
                else if(a == ']'){
                    if(arr[1] == 0 || stack.peek() != '['){
                        sb.append("no").append("\n");
                        flag = false;
                        break Loop1;
                    }
                    arr[1]--;
                    stack.pop();
                }
            }

            if(flag){
                if(arr[0] == 0 && arr[1] == 0){
                    sb.append("yes").append("\n");
                }
                else{

                    sb.append("no").append("\n");
                }
            }

        }
        System.out.println(sb);
    }
}