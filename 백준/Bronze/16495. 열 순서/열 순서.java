import java.io.*;
import java.util.HashMap;

class Main {
    static HashMap<Character, Integer> map = new HashMap<>(){{
        for(int i = 65; i <= 90; i++){
            put((char) i, i-65);
        }
    }};
    public static void main(String[] args) throws Exception{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = input.length() - 1;
        long answer = 0;

        long temp_val = 0;
        for(int i = 0; i < input.length(); i++){
            answer += (long) (Math.pow(26, i));
            char cur = input.charAt(input.length() - 1 - i);
            long temp = (long) map.get(cur);
            temp_val = (temp * (long) Math.pow(26, i));
            answer += temp_val;
        }
        System.out.println(answer);
    }
}