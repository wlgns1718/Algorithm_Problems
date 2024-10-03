import java.io.*;
import java.util.*;

class Main {
    static int TC;
    static HashMap<Character, Integer> nums = new HashMap<>();
    static char[] letter = {'E', 'F', 'G', 'H', 'I', 'N', 'O', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Z'};
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());
        for(int i = 0; i < letter.length; i++){
            nums.put(letter[i], i);
        }
        String word;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < TC; i++){
            word = br.readLine();
            sb.append("Case #").append(i+1).append(": ").append(sol(word)).append("\n");
        }
        System.out.println(sb);
    }
    private static String sol(String word){
        int[] arr = new int[15];
        int[] answer = new int[10];
        for(char w : word.toCharArray()){
            arr[nums.get(w)] ++;
        }
        /*
        ZERO (Z유일) > SIX(X가 유일) > TWO(W가 유일) > FOUR(U가 유일) > EIGHT(G가 유일)
        > 위를 제외한, SEVEN(S유일) > FIVE(F유일) > THREE(T유일) > ONE(O유일) > NINE
        순서로 확인
         */
        while(arr[nums.get('Z')] != 0){
            answer[0]++;
            arr[14] --; //Z
            arr[0] --; //E
            arr[7] --; //R
            arr[6] --; //O
        }
        while(arr[nums.get('X')] != 0){
            answer[6]++;
            arr[4] --; //I
            arr[8] --; //S
            arr[13] --; //X
        }
        while(arr[nums.get('W')] != 0){
            answer[2]++;
            arr[6] --; //O
            arr[9] --; //T
            arr[12] --; //W
        }
        while(arr[nums.get('U')] != 0){
            answer[4] ++;
            arr[1] --; //F
            arr[6] --; //O
            arr[10] --; //U
            arr[7] --; //R
        }
        while(arr[nums.get('G')] != 0){
            answer[8] ++;
            arr[0] --; //E
            arr[4] --; //I
            arr[2] --; //G
            arr[3] --; //H
            arr[9] --; //T
        }
        while(arr[nums.get('S')] != 0){
            answer[7] ++;
            arr[0] -= 2; //E
            arr[8] --; //S
            arr[5] --; //N
            arr[11] --; //V
        }
        while(arr[nums.get('F')] != 0){
            answer[5] ++;
            arr[0] --; //E
            arr[4] --; //I
            arr[1] --; //F
            arr[11] --; //V
        }
        while(arr[nums.get('T')] != 0){
            answer[3] ++;
            arr[0] -= 2; //E
            arr[9] --; //T
            arr[3] --; //H
            arr[7] --; //R
        }
        while(arr[nums.get('O')] != 0){
            answer[1] ++;
            arr[6] --; //O
            arr[0] --; //E
            arr[5] --; //N
        }
        answer[9] = arr[nums.get('I')];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++){
            sb.append(String.valueOf(i).repeat(answer[i]));
        }
        return sb.toString();
    }
}