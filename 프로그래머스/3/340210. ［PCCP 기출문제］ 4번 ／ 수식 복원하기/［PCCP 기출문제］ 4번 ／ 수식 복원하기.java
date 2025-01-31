import java.util.*;

class Solution {
    static boolean[] select = new boolean[10];
    static boolean[] ques;
    static int len = 0;
    
    public String[] solution(String[] expressions) {
        String[] answer;
        
        Arrays.fill(select, true);
        select[0] = false;
        select[1] = false;
        ques = new boolean[expressions.length];
        
        for(int i = 0; i < expressions.length; i++){
            String exp = expressions[i];
            find(exp, i);
        }
        answer = new String[len];
        int temp_len = 0;
        boolean flag = false;

        for(int i = 0; i < expressions.length; i++){
            String val = null;
            flag = true;
            if(ques[i]){

                Loop:
                for(int j = 2; j <= 9; j++){
                    if(select[j]){
                        int temp = cal(expressions[i], j);
                        if(val == null) val = Integer.toString(temp, j);
                        else{
                            if(!val.equals(Integer.toString(temp, j))){
                                flag = false;

                                answer[temp_len ++] = expressions[i].substring(0, expressions[i].length() - 1) + '?';
                                break Loop;
                            }
                        }
                    }
                }
                if(flag){
                    answer[temp_len ++] = expressions[i].substring(0, expressions[i].length()- 1) + val;
                }
            }
        }
        return answer;
    }
    
    private static void find(String exp, int i){

        String[] temp = exp.split(" ");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[2]);
        
        if(temp[4].equals("X")){
            ques[i] = true;
            int max_a = 0;
            int max_b = 0;
            for(char t : temp[0].toCharArray()){
                max_a = Math.max(max_a, Integer.parseInt(String.valueOf(t)));
            }
            for(char t : temp[2].toCharArray()){
                max_b = Math.max(max_b, Integer.parseInt(String.valueOf(t)));
            }
            ques[i] = true;
            for(int j = 2; j <= max_a; j++){
                select[j] = false;
            }
            for(int j = 2; j <= max_b; j++){
                select[j] = false;
            }
            len++;
            return;
        }
        
        int c = Integer.parseInt(temp[4]);
        char op = temp[1].charAt(0);
        int a1, b1, c1;
        if(op == '+'){

            for(int j = 2; j <= 9; j++){
                a1 = check(a, j);
                b1 = check(b, j);
                c1 = check(c, j);
                if(a1 == -1 || b1 == -1 || c1 == -1){
                    select[j] = false;
                    continue;
                }
                if(check(a, j) + check(b, j) != check(c, j)){
                    select[j] = false;
                }
            }
        }
        else{
            for(int j = 2; j <= 9; j++){
                a1 = check(a, j);
                b1 = check(b, j);
                c1 = check(c, j);
                if(a1 == -1 || b1 == -1 || c1 == -1){
                    select[j] = false;
                    continue;
                }
                if(check(a, j) - check(b, j) != check(c, j)){
                    select[j] = false;
                }
            }
        }
    }
    private static int check(int num, int bin){
        int res = 0;
        int cnt = 0;
        while(num > 0){
            int temp = num % 10;
            if(temp >= bin) return -1;
            res += (temp * (int) Math.pow(bin, cnt++));
            num /= 10;
        }
        return res;
    }
    private static int cal(String exp, int i){
        String[] temp = exp.split(" ");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[2]);
        char op = temp[1].charAt(0);

        int a1, b1;
        if(op == '+'){
            a1 = check(a, i);
            b1 = check(b, i);
            return a1 + b1;
        }
        else {
            a1 = check(a, i);
            b1 = check(b, i);
            return a1 - b1;
        }
    }
}