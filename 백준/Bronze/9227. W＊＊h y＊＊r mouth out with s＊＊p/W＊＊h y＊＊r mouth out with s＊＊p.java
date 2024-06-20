import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashMap<Character, HashSet<Character>> map = new HashMap<>();
        String input;
        while(true){
            input = br.readLine();
            if(input.equals("##")) break;
            if(!map.containsKey(input.charAt(0))){
                map.put(input.charAt(0), new HashSet<>());
            }
            map.get(input.charAt(0)).add(input.charAt(1));
        }
        String[] input2;
        while (true){
            input2 = br.readLine().split(" ");
            if(input2[0].equals("#"))break;

            for(int i = 0; i < input2.length; i++){
                String temp = input2[i];
                if(temp.charAt(0) >= 'a' && temp.charAt(0) <= 'z'){
                    if(map.containsKey(temp.charAt(0))){
                        if(temp.length() < 4) sb.append(temp);
                        else{
                            if(map.get(temp.charAt(0)).contains(temp.charAt(3))){
                                for(int j = 0; j < temp.length(); j++){
                                    if (j == 1 || j == 2) sb.append('*');
                                    else sb.append(temp.charAt(j));
                                }
                            }
                            else{
                                sb.append(temp);
                            }
                        }
                    }
                    else{
                        sb.append(temp);
                    }
                }
                else{
                    sb.append(temp);
                }
                if(i < input2.length - 1) sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}