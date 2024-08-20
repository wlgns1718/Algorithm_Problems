import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();
        int[] arr = new int[26];

        for(char w : word.toCharArray()){
            arr[w - 'A'] ++;
        }
        boolean flag = false;
        int max = 0;
        char answer = 'A';
        for(int i = 0; i < 26; i++){
            if(max < arr[i]){
                answer = (char)('A' + i);
                flag = false;
                max = arr[i];
            }
            else if(max == arr[i]) flag = true;
        }
        if(flag) System.out.println('?');
        else System.out.println(answer);

    }
}