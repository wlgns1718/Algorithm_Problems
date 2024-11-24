import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Stack<Character> stack = new Stack<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int i = 0; i < N; i++){
            String word = br.readLine();
            answer += sol(word);
        }
        System.out.println(answer);
    }
    private static int sol(String word){
        stack.clear();

        for(char c : word.toCharArray()) {
            if (stack.isEmpty() || stack.peek() != c) {
                stack.add(c);
            } else {
                stack.pop();
            }
        }
        if(stack.isEmpty()) return 1;
        else return 0;
    }
}