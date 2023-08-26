import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.Buffer;
import java.util.*;


public class Main {
    static int answer = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(stack.empty()){
                if(y != 0){
                    stack.push(y);
                }
                continue;
            }
            if(y == stack.peek()){
                continue;
            }
            else if(y > stack.peek()){
                stack.push(y);
            }
            else if (y < stack.peek()) {
                //같아지거나 거질 때 까지 빼기
                while(!stack.empty() && stack.peek() > y){
                    stack.pop();
                    answer += 1;
                }
                if((!stack.empty() && y == stack.peek()) || y == 0){
                    continue;
                }
                stack.push(y);
            }
        }
        while(!stack.empty()){
            stack.pop();
            answer += 1;
        }
        System.out.println(answer);
    }


}