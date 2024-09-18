import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int one = 0;
        int two = 0;

        int temp = 0;
        for(char c : input[0].toCharArray()){
            temp += Integer.parseInt(String.valueOf(c));
        }
        one = temp * input[0].length();
        temp = 0;
        for(char c : input[1].toCharArray()){
            temp += Integer.parseInt(String.valueOf(c));
        }

        two = temp * input[1].length();
        if(one == two){
            System.out.println(0);
        }
        else if(one > two){
            System.out.println(1);
        }
        else{
            System.out.println(2);
        }
    }
}