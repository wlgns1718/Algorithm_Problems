import java.io.*;
import java.util.*;

class Main {

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //level
        String word = br.readLine();
        boolean tri = true;


        for(int i = 0; i < word.length() / 2; i++){
            if(word.charAt(i) != word.charAt(word.length()-1 - i)){
                tri = false;
                break;
            }
        }
        if(tri) System.out.println(1);
        else System.out.println(0);
    }
}